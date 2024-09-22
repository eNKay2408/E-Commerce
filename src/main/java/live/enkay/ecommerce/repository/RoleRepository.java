package live.enkay.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import live.enkay.ecommerce.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
