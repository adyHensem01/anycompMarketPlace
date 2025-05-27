package stc.anycomp_marketplace.dto;

import java.time.LocalDateTime;

public class ItemResponse {

    private Long itemID;
    private String status;
    private LocalDateTime timestamp;


    // Constructors
    public ItemResponse(Long itemID, String status, LocalDateTime timestamp) {
        this.itemID = itemID;
        this.status = status;
        this.timestamp = timestamp;
    }

     public ItemResponse(){}

    // Getters and Setters
    public Long getItemId() {
        return itemID;
    }

    public void setItemId(Long itemID) {
        this.itemID = itemID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    
}
