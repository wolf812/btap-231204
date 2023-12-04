package ra.baitap_231204.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.baitap_231204.model.Categories;

@Repository

public interface CategoriesRepository extends JpaRepository<Categories,Long> {
}
