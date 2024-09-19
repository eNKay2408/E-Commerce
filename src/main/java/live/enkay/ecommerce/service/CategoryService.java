package live.enkay.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import live.enkay.ecommerce.model.Category;
import live.enkay.ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
  private final CategoryRepository categoryRepository;

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public void addCategory(Category category) {
    categoryRepository.save(category);
  }

  public void deleteCategoryById(int id) {
    categoryRepository.deleteById(id);
  }

  public Optional<Category> getCategoryById(int id) {
    return categoryRepository.findById(id);
  }
}
