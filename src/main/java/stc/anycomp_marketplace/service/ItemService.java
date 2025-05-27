package stc.anycomp_marketplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stc.anycomp_marketplace.dto.ItemRequest;
import stc.anycomp_marketplace.model.Item;
import stc.anycomp_marketplace.repository.ItemRepository;
import stc.anycomp_marketplace.repository.SellerRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private SellerRepository sellerRepository;
   

    // list all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }   

    //find a specific item by ID
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    //get items by seller
    public List<Item> getItemsBySellerId(Long sellerId) {
        return itemRepository.findAll().stream()
                .filter(item -> item.getSeller() != null && item.getSeller().getId().equals(sellerId))
                .toList();
        
       
    }

    //add new item to seller's inventory
    public Item createItembySellerId(ItemRequest itemRequest, Long id) {
       var seller = sellerRepository.findById(id).orElse(null);
       if (seller != null) {
            Item item = new Item();
            item.setName(itemRequest.getName());
            item.setDescription(itemRequest.getDescription());
            item.setPrice(itemRequest.getPrice());
            item.setQuantity(itemRequest.getQuantity());
            item.setSeller(seller);
            return itemRepository.save(item);
        }
        return null;
    }

    //update an existing item
    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            item.setName(itemDetails.getName());
            item.setDescription(itemDetails.getDescription());
            item.setPrice(itemDetails.getPrice());
            item.setSeller(itemDetails.getSeller());
            item.setQuantity(itemDetails.getQuantity());
            return itemRepository.save(item);
        }
        return null;
    }
    //delete an item
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            itemRepository.delete(item);
        }
    }
}
