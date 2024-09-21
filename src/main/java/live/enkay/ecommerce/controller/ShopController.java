package live.enkay.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import live.enkay.ecommerce.service.CategoryService;
import live.enkay.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ShopController {
  private final CategoryService categoryService;
  private final ProductService productService;

  @GetMapping("/")
  public String home(Model model) {
    return "home-user";
  }

  @GetMapping("/shop")
  public String shop(Model model) {
    model.addAttribute("categories", categoryService.getAllCategories());
    model.addAttribute("products", productService.getAllProducts());

    return "shop-list";
  }

  @GetMapping("/shop/category/{id}")
  public String shopByCategory(Model model, @PathVariable int id) {
    model.addAttribute("categories", categoryService.getAllCategories());
    model.addAttribute("products", productService.getProductsByCategory(id));

    return "shop-list";
  }

  @GetMapping("/shop/product/{id}")
  public String shopByProduct(Model model, @PathVariable int id) {
    model.addAttribute("product", productService.getProductById(id).get());

    return "shop-details";
  }
}
