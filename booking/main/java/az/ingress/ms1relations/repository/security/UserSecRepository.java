package az.ingress.ms1relations.repository.security;

import az.ingress.ms1relations.domain.securityDomain.UserSecurity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserSecRepository extends JpaRepository<UserSecurity, Long>, JpaSpecificationExecutor<UserSecurity> {

    @EntityGraph(attributePaths = {"authorities"})
    Optional<UserSecurity> findByUsername(String username);

    UserSecurity findById(long id);
}