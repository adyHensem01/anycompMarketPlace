package stc.anycomp_marketplace.dto;

import java.time.LocalDateTime;

public class PurchaseResponse {

    private Long purchaseId;
    private String status;
    private LocalDateTime timestamp;

    // Constructors
    public PurchaseResponse(Long purchaseId, String status, LocalDateTime timestamp) {
        this.purchaseId = purchaseId;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
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
