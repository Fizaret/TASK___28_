package az.ingress.ms1relations.repository;

import az.ingress.ms1relations.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
