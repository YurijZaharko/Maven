package proj.service;

import proj.entity.Category;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */
public interface CategoryService {
    void save(String name);
    Category findByName(String name);
    void delete(String name);
    List<Category> findAll();
}
