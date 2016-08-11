package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.Brand;

/**
 * Created by SC on 10.08.2016.
 */
public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
