package stc.anycomp_marketplace.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stc.anycomp_marketplace.dto.ItemRequest;
import stc.anycomp_marketplace.dto.ItemResponse;
import stc.anycomp_marketplace.model.Item;
import stc.anycomp_marketplace.service.ItemService;

@RestController
@RequestMapping("/ext/sellers/{sellerId}/items")
public class itemExtentionController {
    
    @Autowired
    private ItemService itemService; 

     //Get items by seller
    @GetMapping
    public List<Item> getItemsBySeller(@PathVariable Long sellerId){
        return itemService.getItemsBySellerId(sellerId);
    }

    //add new item to seller
    @PostMapping
    public ResponseEntity <ItemResponse> addNewItemEntity(@RequestBody ItemRequest itemRequest, @PathVariable Long sellerId){
        Item postItem = itemService.createItembySellerId(itemRequest, sellerId);
        ItemResponse itemResponse = new ItemResponse(
            postItem.getId(),
            "SUCCESS",
            LocalDateTime.now() 

        );

        return ResponseEntity.ok(itemResponse);
    }

}
