package az.ingress.ms1relations.repository;

import az.ingress.ms1relations.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
