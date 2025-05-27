package stc.anycomp_marketplace.dto;

import java.time.LocalDateTime;

public class SellerResponse {

    private Long SellerId;
    private String status;
    private LocalDateTime timestamp;

     // Constructors
    public SellerResponse(Long SellerId, String status, LocalDateTime timestamp){
        this.SellerId = SellerId;
        this.status = status;
        this.timestamp = timestamp;
    }
    //empty constructor
    public SellerResponse(){}


     // Getters and Setters
    public Long getSellerId() {
        return SellerId;
    }

    public void setSellerId(Long SellerId) {
        this.SellerId = SellerId;
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
