package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.Category;

/**
 * Created by SC on 10.08.2016.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
