package live.enkay.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import live.enkay.ecommerce.model.Product;
import live.enkay.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public void deleteProductById(long id) {
    productRepository.deleteById(id);
  }

  public Optional<Product> getProductById(long id) {
    return productRepository.findById(id);
  }

  public List<Product> getProductsByCategory(int id) {
    return productRepository.findAllByCategoryId(id);
  }

  public void addProduct(Product product) {
    productRepository.save(product);
  }
}
