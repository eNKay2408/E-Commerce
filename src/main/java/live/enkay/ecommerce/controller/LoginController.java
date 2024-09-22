package live.enkay.ecommerce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import live.enkay.ecommerce.model.Role;
import live.enkay.ecommerce.model.User;
import live.enkay.ecommerce.repository.RoleRepository;
import live.enkay.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  @GetMapping("/login")
  public String login() {
    return "access-login";
  }

  @GetMapping("/register")
  public String getRegister() {
    return "access-register";
  }

  @PostMapping("/register")
  public String postRegister(@ModelAttribute("user") User user, HttpServletRequest request)
      throws ServletException, IOException {

    String password = user.getPassword();
    user.setPassword(bCryptPasswordEncoder.encode(password));

    List<Role> roles = new ArrayList<>();
    roles.add(roleRepository.findById(2).get());
    user.setRoles(roles);

    userRepository.save(user);

    return "redirect:/login";
  }

  @GetMapping("/denied")
  public String accessDenied() {
    return "access-denied";
  }
}
