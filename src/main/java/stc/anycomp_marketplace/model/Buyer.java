package stc.anycomp_marketplace.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id")
    private long id;
    private String name;
    private String email;
    
    @OneToMany(mappedBy = "buyer")
    @JsonIgnore 
    private List<Purchase> purchasedItems;

    public Buyer(){}

    public Buyer(Long id, String name, String email, List<Purchase> purchasedItems) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.purchasedItems = purchasedItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Purchase> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(List<Purchase> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

    
}
