package hr.kreso.api.service;

import java.util.List;

import hr.kreso.api.model.Media;

/**
 * Servis za pretragu media.
 */
public interface MediaSearchService {
	/**
	 * Metoda koja pretražuje lokalnu bazu i udaljene endpointeve za dohvat podataka
	 * po nazivu filma ili showa.
	 * 
	 * @param naziv naziv filma ili showa
	 * @return lista objekata modela Media
	 * @see Media
	 */
	List<Media> pretraziPoNazivu(String naziv);
}
