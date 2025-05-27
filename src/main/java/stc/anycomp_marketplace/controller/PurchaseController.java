package stc.anycomp_marketplace.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stc.anycomp_marketplace.dto.PurchaseRequest;
import stc.anycomp_marketplace.dto.PurchaseResponse;
import stc.anycomp_marketplace.model.Purchase;
import stc.anycomp_marketplace.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity <PurchaseResponse> createPurchase(@RequestBody PurchaseRequest request){
        Purchase savePurchase =  purchaseService.createPurchase(request);

        if(savePurchase!=null){
            // Manually map or use a mapper like MapStruct
            PurchaseResponse response = new PurchaseResponse(
            savePurchase.getId(),            
            "SUCCESS",
            LocalDateTime.now()                
        );
        return ResponseEntity.ok(response);

        }else{
             PurchaseResponse response = new PurchaseResponse(
            null,            
            "PLEASE CHECK QUANTITY/Error",
            LocalDateTime.now());  
            return ResponseEntity.ok(response);
        }

         

    }
    
}
