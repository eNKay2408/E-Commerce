package live.enkay.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.ShippingAddressCollection;

import jakarta.servlet.http.HttpServletResponse;
import live.enkay.ecommerce.global.GlobalData;
import live.enkay.ecommerce.model.Product;

@RestController
public class CheckoutController {
  @Value("${stripe.secret.key}")
  private String stripeSecretKey;

  @GetMapping("/checkout")
  public void createCheckoutSession(HttpServletResponse response) throws Exception {
    Stripe.apiKey = stripeSecretKey;

    List<Product> products = GlobalData.cart;

    if (products.isEmpty()) {
      response.sendRedirect("/shop");
      return;
    }

    List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();

    for (Product product : products) {
      SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
          .setQuantity(1L)
          .setPriceData(
              SessionCreateParams.LineItem.PriceData.builder()
                  .setCurrency("usd")
                  .setUnitAmount(Math.round(product.getPrice() * 100))
                  .setProductData(
                      SessionCreateParams.LineItem.PriceData.ProductData.builder()
                          .setName(product.getName())
                          .build())
                  .build())
          .build();

      lineItems.add(lineItem);
    }

    SessionCreateParams params = SessionCreateParams.builder()
        .setMode(SessionCreateParams.Mode.PAYMENT)
        .setSuccessUrl("http://localhost:8080/checkout/success")
        .setCancelUrl("http://localhost:8080/")
        .addAllLineItem(lineItems)
        .setShippingAddressCollection(
            ShippingAddressCollection.builder()
                .addAllowedCountry(
                    SessionCreateParams.ShippingAddressCollection.AllowedCountry.US)
                .addAllowedCountry(
                    SessionCreateParams.ShippingAddressCollection.AllowedCountry.VN)
                .build())
        .build();

    Session session = Session.create(params);

    String checkoutUrl = session.getUrl();

    response.sendRedirect(checkoutUrl);
  }
}
