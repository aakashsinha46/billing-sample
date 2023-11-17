package in.aakashsinha.billingsimple.repository;

import in.aakashsinha.billingsimple.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
}
