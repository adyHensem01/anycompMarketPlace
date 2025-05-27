package stc.anycomp_marketplace.dto;

import java.time.LocalDateTime;

public class BuyerResponse {
    private Long BuyerId;
    private String status;
    private LocalDateTime timestamp;

    // Constructors
    public BuyerResponse(Long BuyerId, String status, LocalDateTime timestamp) {
        this.BuyerId = BuyerId;
        this.status = status;
        this.timestamp = timestamp;
    }

    public BuyerResponse(){

    }

    // Getters and Setters
    public Long getBuyerId() {
        return BuyerId;
    }

    public void setBuyerId(Long BuyerId) {
        this.BuyerId = BuyerId;
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
