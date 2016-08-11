package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.Country;

/**
 * Created by SC on 10.08.2016.
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
