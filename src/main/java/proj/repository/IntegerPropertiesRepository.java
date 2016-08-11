package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.IntegerProperties;

/**
 * Created by SC on 10.08.2016.
 */
public interface IntegerPropertiesRepository extends JpaRepository<IntegerProperties, Integer> {
}
