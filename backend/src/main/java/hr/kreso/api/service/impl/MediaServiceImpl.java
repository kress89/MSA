package hr.kreso.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hr.kreso.api.model.Media;
import hr.kreso.api.model.MediaSource;
import hr.kreso.api.model.MediaType;
import hr.kreso.api.repo.MediaRepository;
import hr.kreso.api.service.MediaService;

@Service
public class MediaServiceImpl implements MediaService {
	private MediaRepository mediaRepository;

	public MediaServiceImpl(MediaRepository mediaRepository) {
		this.mediaRepository = mediaRepository;
	}

	@Override
	public Optional<MediaType> dohvatiMediaTypePoId(Integer id) {
		return mediaRepository.dohvatiMediaTypePoId(id);
	}

	@Override
	public List<MediaType> dohvatiSveTipove() {
		return mediaRepository.dohvatiSveTipove();
	}

	@Override
	public Optional<MediaSource> dohvatiMediaSourcePoId(Integer id) {
		return mediaRepository.dohvatiMediaSourcePoId(id);
	}

	@Override
	public List<MediaSource> dohvatiSveIzvore() {
		return mediaRepository.dohvatiSveIzvore();
	}

	@Override
	public Optional<Media> dohvatiPoId(Integer id) {
		return mediaRepository.dohvatiPoId(id);
	}

	@Override
	public List<Media> dohvatiSve() {
		return mediaRepository.dohvatiSve();
	}

	@Override
	public List<Media> dohvatiPoNazivu(String naziv) {
		return mediaRepository.dohvatiPoNazivu(naziv);
	}

	@Override
	public Integer dodaj(Media zapis) {
		mediaRepository.dodaj(zapis);
		return zapis.getId();
	}
}
