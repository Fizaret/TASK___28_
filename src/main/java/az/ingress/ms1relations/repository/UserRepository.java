package az.ingress.ms1relations.repository;


import az.ingress.ms1relations.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
