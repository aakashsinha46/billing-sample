package in.aakashsinha.billingsimple.repository;

import in.aakashsinha.billingsimple.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.phone = :phoneNumber")
    Boolean findByPhone(@Param("phoneNumber") Long phoneNumber);

    @Query("SELECT c.id FROM Customer c WHERE c.phone = :phoneNumber")
    Long getCustomerIdByPhone(@Param("phoneNumber") Long phoneNumber);
}
