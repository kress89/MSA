package hr.kreso.api.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.kreso.api.Konstante;
import hr.kreso.api.model.Media;
import hr.kreso.api.service.MediaSearchService;

@RestController
@CrossOrigin
public class MediaRestController {
	private MediaSearchService mediaSearchService;

	public MediaRestController(MediaSearchService mediaSearchService) {
		this.mediaSearchService = mediaSearchService;
	}

	@GetMapping(Konstante.API_MOVIE_FETCH_URL)
	public ResponseEntity<List<Media>> pretraziFilmove(@RequestParam(name = "title") String naziv) {
		return ResponseEntity.ok(mediaSearchService.pretraziPoNazivu(naziv));
	}
}
