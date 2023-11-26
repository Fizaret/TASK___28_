package az.ingress.ms1relations.repository.security;

import az.ingress.ms1relations.domain.securityDomain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByAuthority(String authority);
}