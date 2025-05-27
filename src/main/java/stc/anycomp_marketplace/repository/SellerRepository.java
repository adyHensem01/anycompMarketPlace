package stc.anycomp_marketplace.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stc.anycomp_marketplace.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    
}
