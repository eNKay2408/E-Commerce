package live.enkay.ecommerce.global;

import java.util.ArrayList;
import java.util.List;

import live.enkay.ecommerce.model.Product;

public class GlobalData {
  public static List<Product> cart;

  static {
    cart = new ArrayList<Product>();
  }
}
