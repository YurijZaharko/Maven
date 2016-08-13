package proj.service;

import org.springframework.stereotype.Service;
import proj.entity.Brand;

import java.util.List;

/**
 * Created by SC on 10.08.2016.
 */

public interface BrandService {
    void save(String name);
    Brand findByName(String name);
    void delete(String name);
    List<Brand> findAll();

}
