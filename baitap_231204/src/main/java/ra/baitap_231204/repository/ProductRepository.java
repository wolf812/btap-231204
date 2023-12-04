package ra.baitap_231204.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.baitap_231204.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
}
