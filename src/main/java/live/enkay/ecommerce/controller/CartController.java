package live.enkay.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import live.enkay.ecommerce.global.GlobalData;
import live.enkay.ecommerce.model.Product;
import live.enkay.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartController {
  private final ProductService productService;

  @GetMapping("/cart/{id}")
  public String addToCart(@PathVariable int id) {
    GlobalData.cart.add(productService.getProductById(id).get());

    return "redirect:/shop";
  }

  @GetMapping("/cart")
  public String getCart(Model model) {
    model.addAttribute("cartCount", GlobalData.cart.size());
    model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
    model.addAttribute("cart", GlobalData.cart);

    return "cart-details";
  }

  @GetMapping("/cart/remove/{index}")
  public String removeProductFromCart(@PathVariable int index) {
    GlobalData.cart.remove(index);

    return "redirect:/cart";
  }

  @GetMapping("/checkout/success")
  public String checkoutSuccess() {
    GlobalData.cart.clear();

    return "shop-paid";
  }
}
