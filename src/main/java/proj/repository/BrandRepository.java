package proj.repository;

import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proj.entity.Brand;

/**
 * Created by SC on 10.08.2016.
 */
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    Brand findByName(String name);

    @Modifying
    @Query("DELETE FROM Brand brand WHERE brand.brandName=:name" )
    void deleteByName(@Param("name") String name);
}
