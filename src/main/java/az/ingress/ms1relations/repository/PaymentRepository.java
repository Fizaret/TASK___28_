package az.ingress.ms1relations.repository;

import az.ingress.ms1relations.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
