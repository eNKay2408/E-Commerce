package live.enkay.ecommerce.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import live.enkay.ecommerce.dto.ProductDTO;
import live.enkay.ecommerce.model.Category;
import live.enkay.ecommerce.model.Product;
import live.enkay.ecommerce.service.CategoryService;
import live.enkay.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {
  // -- CATEGORY SECTION
  private final CategoryService categoryService;
  private final ProductService productService;

  private String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

  @GetMapping("/admin")
  public String adminHome() {
    return "home-admin";
  }

  @GetMapping("/admin/categories")
  public String getCategories(Model model) {
    model.addAttribute("categories", categoryService.getAllCategories());
    return "category-list";
  }

  @GetMapping("/admin/categories/add")
  public String getAddCategory(Model model) {
    model.addAttribute("category", new Category());
    return "category-add";
  }

  @PostMapping("/admin/categories/add")
  public String postAddCategory(@ModelAttribute("category") Category category) {
    categoryService.addCategory(category);
    return "redirect:/admin/categories";
  }

  @GetMapping("/admin/categories/delete/{id}")
  public String deleteCategory(@PathVariable int id) {
    categoryService.deleteCategoryById(id);
    return "redirect:/admin/categories";
  }

  @GetMapping("/admin/categories/update/{id}")
  public String updateCategory(@PathVariable int id, Model model) {
    Optional<Category> category = categoryService.getCategoryById(id);

    if (category.isPresent()) {
      model.addAttribute("category", category.get());
      return "category-add";
    } else {
      return "404";
    }
  }

  // -- PRODUCT SECTION
  @GetMapping("/admin/products")
  public String getProducts(Model model) {
    model.addAttribute("products", productService.getAllProducts());
    return "product-list";
  }

  @GetMapping("/admin/products/add")
  public String getAddProduct(Model model) {
    model.addAttribute("productDTO", new ProductDTO());
    model.addAttribute("categories", categoryService.getAllCategories());
    return "product-add";
  }

  @PostMapping("/admin/products/add")
  public String postAddProduct(@ModelAttribute("productDTO") ProductDTO productDTO,
      @RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName) throws IOException {

    Product product = new Product();
    product.setId(productDTO.getId());
    product.setName(productDTO.getName());
    product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
    product.setPrice(productDTO.getPrice());
    product.setWeight(productDTO.getWeight());
    product.setDescription(productDTO.getDescription());

    String imageUUID;
    if (!file.isEmpty()) {
      imageUUID = file.getOriginalFilename();
      Path fileNameAndPath = Paths.get(uploadDirectory, imageUUID);
      Files.write(fileNameAndPath, file.getBytes());
    } else {
      imageUUID = imgName;
    }
    product.setImageName(imageUUID);

    productService.addProduct(product);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return "redirect:/admin/products";
  }

  @GetMapping("/admin/products/delete/{id}")
  public String deleteProduct(@PathVariable long id) {
    String imageName = productService.getProductById(id).get().getImageName();
    Path fileNameAndPath = Paths.get(uploadDirectory, imageName);
    try {
      Files.delete(fileNameAndPath);
    } catch (IOException e) {
      e.printStackTrace();
    }

    productService.deleteProductById(id);

    return "redirect:/admin/products";
  }

  @GetMapping("/admin/products/update/{id}")
  public String updateProduct(@PathVariable long id, Model model) {
    Product product = productService.getProductById(id).get();

    ProductDTO productDTO = new ProductDTO();
    productDTO.setId(product.getId());
    productDTO.setName(product.getName());
    productDTO.setCategoryId(product.getCategory().getId());
    productDTO.setPrice(product.getPrice());
    productDTO.setWeight(product.getWeight());
    productDTO.setDescription(product.getDescription());
    productDTO.setImageName(product.getImageName());

    model.addAttribute("productDTO", productDTO);
    model.addAttribute("categories", categoryService.getAllCategories());

    return "product-add";
  }
}
