package hr.kreso.api.repo;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import hr.kreso.api.model.Media;
import hr.kreso.api.model.MediaSource;
import hr.kreso.api.model.MediaType;

@Mapper
@Repository
public interface MediaRepository {
	Optional<MediaType> dohvatiMediaTypePoId(Integer id);

	List<MediaType> dohvatiSveTipove();

	Optional<MediaSource> dohvatiMediaSourcePoId(Integer id);

	List<MediaSource> dohvatiSveIzvore();

	Optional<Media> dohvatiPoId(Integer id);

	List<Media> dohvatiSve();

	List<Media> dohvatiPoNazivu(String naziv);

	Integer dodaj(Media zapis);
}
