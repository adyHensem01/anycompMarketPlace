package stc.anycomp_marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stc.anycomp_marketplace.model.Item;
import stc.anycomp_marketplace.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    //List all items
    @RequestMapping
    public List<Item> getAllItem(){
        return itemService.getAllItems();     
    }

    //Get Item by ID
    @GetMapping("/{id}")
    public ResponseEntity <Item> getItemById(@PathVariable Long id ){
        Item getItem = itemService.getItemById(id);
        if(getItem!=null){
           return ResponseEntity.ok(getItem);
        }else{
          return ResponseEntity.notFound().build();
        }

    }

   

    //update item
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody Item item,@PathVariable Long id){
        Item updateItem =  itemService.updateItem(id, item);
        if(updateItem!=null){
            return ResponseEntity.ok(updateItem);
        }else{
             return ResponseEntity.notFound().build();
        }
        
    }

    //Delete item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id){
        Item deleteItem = itemService.getItemById(id);
        if(deleteItem!=null){
            itemService.deleteItem(id);
           return  ResponseEntity.noContent().build();
        }else{
            return  ResponseEntity.notFound().build();
        }
    }



    
}
