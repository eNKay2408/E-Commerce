package live.enkay.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import live.enkay.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findAllByCategoryId(int id);
}
