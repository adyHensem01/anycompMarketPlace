package stc.anycomp_marketplace.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import stc.anycomp_marketplace.dto.SellerRequest;
import stc.anycomp_marketplace.dto.SellerResponse;
import stc.anycomp_marketplace.model.Seller;
import stc.anycomp_marketplace.service.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    //List all sellers
    @GetMapping
    public List<Seller> getAllSellers(){
        return sellerService.getAllSellers();
        
    }

    //Get a specific seller
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id){
        Seller seller = sellerService.getSellerById(id);
        if (seller !=null){
            return ResponseEntity.ok(seller);
        } else{
            return ResponseEntity.notFound().build();
        }
        
    }

    //create a seller
    @PostMapping
    public ResponseEntity<SellerResponse> createSeller(@RequestBody SellerRequest sellerRequest){
        Seller createSeller = sellerService.createSeller(sellerRequest);

      if (createSeller != null) {
          SellerResponse sellerResponse = new SellerResponse(
            createSeller.getId(),
            "SUCCESS",
            LocalDateTime.now() 

          );

          return ResponseEntity.ok(sellerResponse);
      }else{
        SellerResponse sellerResponse = new SellerResponse(
            null,
            "Failed",
            LocalDateTime.now() 

          );
           return ResponseEntity.ok(sellerResponse);

      }

        
    }

    //update a sellers
    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller sellerDetails){
        Seller updateSeller = sellerService.updateSeller(id, sellerDetails);
        if(updateSeller != null){
            return ResponseEntity.ok(updateSeller);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //delete a sellers
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id){
        Seller deleteSeller = sellerService.getSellerById(id);
        if (deleteSeller!= null){
            sellerService.deleteSeller(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    
}
