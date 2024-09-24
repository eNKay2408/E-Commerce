package live.enkay.ecommerce.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import live.enkay.ecommerce.global.GlobalData;
import live.enkay.ecommerce.model.Role;
import live.enkay.ecommerce.model.User;
import live.enkay.ecommerce.repository.RoleRepository;
import live.enkay.ecommerce.repository.UserRepository;
import live.enkay.ecommerce.service.JwtService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {
  private final RoleRepository roleRepository;
  private final UserRepository userRepository;
  private final JwtService jwtService;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    GlobalData.cart.clear();

    OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
    String email = token.getPrincipal().getAttributes().get("email").toString();

    if (userRepository.findByEmail(email).isPresent()) {
      // User already exists, do nothing
    } else {
      User user = new User();
      user.setFirstName(token.getPrincipal().getAttributes().getOrDefault("given_name", "").toString());
      user.setLastName(token.getPrincipal().getAttributes().getOrDefault("family_name", "").toString());
      user.setEmail(email);

      List<Role> roles = new ArrayList<>();
      roles.add(roleRepository.findById(2).get());
      user.setRoles(roles);

      userRepository.save(user);
    }

    User user = userRepository.findByEmail(email).get();
    String jwtToken = jwtService.generateToken(Map.of(), user);
    response.sendRedirect("https://e-commerce.enkay.live/?token=" + jwtToken);
  }
}
