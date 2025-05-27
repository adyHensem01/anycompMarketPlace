package stc.anycomp_marketplace.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stc.anycomp_marketplace.dto.PurchaseRequest;
import stc.anycomp_marketplace.model.Buyer;
import stc.anycomp_marketplace.model.Item;
import stc.anycomp_marketplace.model.Purchase;
import stc.anycomp_marketplace.repository.BuyerRepository;
import stc.anycomp_marketplace.repository.ItemRepository;
import stc.anycomp_marketplace.repository.PurchaseRepository;

@Service
public class PurchaseService {
    // This service class is responsible for handling purchase-related operations.
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private BuyerRepository buyerRepository;

    
    public Purchase createPurchase(PurchaseRequest request) {

        Buyer buyer = buyerRepository.findById(request.getBuyerId())
            .orElseThrow(() -> new RuntimeException("Buyer not found"));
    
        Item item = itemRepository.findById(request.getItemId())
            .orElseThrow(() -> new RuntimeException("Item not found"));

        Integer quantity = request.getQuantity();

        

        if (buyer == null || item == null) {
            return null; // Buyer or item not found
        }

        if (item.getQuantity() < quantity) {
            return null; // Not enough stock
        }

         // Deduct quantity
        item.setQuantity(item.getQuantity() - quantity);
        itemRepository.save(item);

        // Create purchase
        Purchase purchase = new Purchase();
        purchase.setBuyer(buyer);
        purchase.setItem(item);
        purchase.setQuantity(quantity);
        purchase.setPurchaseDate(new Timestamp(System.currentTimeMillis()));

        return purchaseRepository.save(purchase);

    }
}
