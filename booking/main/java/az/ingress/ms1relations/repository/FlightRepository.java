package az.ingress.ms1relations.repository;

import az.ingress.ms1relations.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
