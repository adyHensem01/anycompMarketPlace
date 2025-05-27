package stc.anycomp_marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stc.anycomp_marketplace.dto.SellerRequest;
import stc.anycomp_marketplace.model.Seller;
import stc.anycomp_marketplace.repository.SellerRepository;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    // List all sellers
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    // Find a specific seller by ID
    public Seller getSellerById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    // Create a new seller
    public Seller createSeller(SellerRequest sellerRequest) {
        Seller seller = new Seller();
        seller.setName(sellerRequest.getName());
        seller.setEmail(sellerRequest.getEmail());
        return sellerRepository.save(seller);
    }

    // Update an existing seller
    public Seller updateSeller(Long id, Seller sellerDetails) {
        Seller seller = sellerRepository.findById(id).orElse(null);
        if (seller != null) {
            seller.setName(sellerDetails.getName());
            seller.setEmail(sellerDetails.getEmail());
            return sellerRepository.save(seller);
        }
        return null;
    }

    // Delete a seller
    public void deleteSeller(Long id) {
        Seller seller = sellerRepository.findById(id).orElse(null);
        if (seller != null) {
            sellerRepository.delete(seller);
        }
    }


    
}
