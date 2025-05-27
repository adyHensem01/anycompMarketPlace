package stc.anycomp_marketplace.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stc.anycomp_marketplace.dto.BuyerRequest;
import stc.anycomp_marketplace.model.Buyer;
import stc.anycomp_marketplace.repository.BuyerRepository;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    //list all buyers
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    //find a specific buyer by ID
    public Buyer getBuyerById(Long id) {
        return buyerRepository.findById(id).orElse(null);
    }

    //create a new buyer
    public Buyer createBuyer(BuyerRequest buyerRequest) {
        Buyer buyer = new Buyer();
         buyer.setName(buyerRequest.getName());
         buyer.setEmail(buyerRequest.getEmail());
        return buyerRepository.save(buyer);
    }

    //update an existing buyer
    public Buyer updateBuyer(Long id, Buyer buyerDetails) {
        Buyer buyer = buyerRepository.findById(id).orElse(null);
        if (buyer != null) {
            buyer.setName(buyerDetails.getName());
            buyer.setEmail(buyerDetails.getEmail());
            return buyerRepository.save(buyer);
        
        }
        return null;
    }   
    
    //delete a buyer
    public void deleteBuyer(Long id) {
          Buyer buyer = buyerRepository.findById(id).orElse(null);
          if (buyer != null) {
              buyerRepository.delete(buyer);
          }
    }
    
                
    
}
