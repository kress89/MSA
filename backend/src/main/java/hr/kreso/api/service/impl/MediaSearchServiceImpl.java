package hr.kreso.api.service.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hr.kreso.api.MediaDto;
import hr.kreso.api.MediaSearchDto;
import hr.kreso.api.MediaTypes;
import hr.kreso.api.model.Media;
import hr.kreso.api.model.MediaSource;
import hr.kreso.api.service.MediaSearchService;
import hr.kreso.api.service.MediaService;

/**
 * Implementacija {@link MediaSearchService}.
 */
@Service
public class MediaSearchServiceImpl implements MediaSearchService {
	private static final String TOKEN_API_KEY = "@key@";
	private static final String TOKEN_TITLE = "@title@";
	private static final String TOKEN_TYPE = "@type@";

	private static final String DEFAULT_TYPE = "movie";
	private static final String DEFAULT_API_KEY = "2026c892";
	private static final String DEFAULT_SOURCE_LOCAL = "localhost";

	private MediaService mediaService;

	/**
	 * Konstruktor.
	 * 
	 * @param mediaService media servis
	 */
	public MediaSearchServiceImpl(MediaService mediaService) {
		this.mediaService = mediaService;
	}

	@Override
	public List<Media> pretraziPoNazivu(String naziv) {
		List<MediaSource> izvori = mediaService.dohvatiSveIzvore();
		List<Media> filmovi = new ArrayList<>();
		for (MediaSource izvor : izvori) {
			if (izvor.getUrl().contains(DEFAULT_SOURCE_LOCAL)) {
				List<Media> dohvaceniFilmovi = mediaService.dohvatiPoNazivu(naziv);
				if (dohvaceniFilmovi != null && !dohvaceniFilmovi.isEmpty()) {
					filmovi.addAll(dohvaceniFilmovi);
					break;
				}
			} else {
				MediaSearchDto dto = dohvatiSaRemoteUrla(izvor.getUrl(), naziv);
				if (dto != null) {
					for (MediaDto mDto : dto.getSearch()) {
						Media result = new Media();
						result.setIzvor(izvor);
						result.setNaziv(mDto.getTitle());
						result.setOpis(mDto.getPoster());
						result.setTip(mediaService.dohvatiMediaTypePoId(MediaTypes.MOVIE.getId()).get());
						result.setDodaci(mDto.getYear());
						Integer id = mediaService.dodaj(result);
						if (id != null && id > 0) {
							filmovi.add(result);
						}
					}
				}
			}
		}
		return filmovi;
	}

	/**
	 * Pomoćna metoda za dohvat podataka s remote endpointa koristeći REST API
	 * poziv.
	 * 
	 * @param url   udaljeni URL s kojeg se dohvaćaju podaci
	 * @param naziv naziv filma ili showa koji se koristi u pretrazi
	 * @return MediaSearchDto
	 * @see MediaSearchDto
	 * @see RestTemplate
	 */
	private MediaSearchDto dohvatiSaRemoteUrla(String url, String naziv) {
		String encodedTitle = URLEncoder.encode(naziv, StandardCharsets.UTF_8);
		String builtUrl = url.replace(TOKEN_API_KEY, DEFAULT_API_KEY).replace(TOKEN_TITLE, encodedTitle)
				.replace(TOKEN_TYPE, DEFAULT_TYPE);
		ResponseEntity<MediaSearchDto> response = new RestTemplate().exchange(builtUrl, HttpMethod.GET, null,
				MediaSearchDto.class);
		if (response.getStatusCode().is2xxSuccessful()) {
			MediaSearchDto dto = response.getBody();
			if (dto != null && dto.getSearch() != null && !dto.getSearch().isEmpty()) {
				return dto;
			}
		}
		return null;
	}
}
