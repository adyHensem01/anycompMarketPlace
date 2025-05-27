package stc.anycomp_marketplace.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stc.anycomp_marketplace.dto.BuyerRequest;
import stc.anycomp_marketplace.dto.BuyerResponse;
import stc.anycomp_marketplace.model.Buyer;
import stc.anycomp_marketplace.service.BuyerService;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    // GET all buyers
    @GetMapping
    public List<Buyer> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    // GET buyer by ID
    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable Long id) {
        Buyer buyer = buyerService.getBuyerById(id);
        if (buyer != null) {
            return ResponseEntity.ok(buyer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST create new buyer
    @PostMapping
    public ResponseEntity<BuyerResponse> createBuyer(@RequestBody BuyerRequest buyerRequest) {
        Buyer createdBuyer = buyerService.createBuyer(buyerRequest);
    
         if (createdBuyer != null) {
            BuyerResponse response = new BuyerResponse(
                createdBuyer.getId(),
                "SUCCESS",
                LocalDateTime.now() 
            );

            return ResponseEntity.ok(response);
        }else {
            BuyerResponse response = new BuyerResponse(
                null,
                "Failed",
                LocalDateTime.now() 
            );
            return ResponseEntity.ok(response);
        }
         
    }

     // PUT update buyer
    @PutMapping("/{id}")
    public ResponseEntity<Buyer> updateBuyer(@PathVariable Long id, @RequestBody Buyer buyerDetails) {
        Buyer updatedBuyer = buyerService.updateBuyer(id, buyerDetails);
        if (updatedBuyer != null) {
            return ResponseEntity.ok(updatedBuyer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     // DELETE buyer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyer(@PathVariable Long id) {
        Buyer buyer = buyerService.getBuyerById(id);
        if (buyer != null) {
            buyerService.deleteBuyer(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
