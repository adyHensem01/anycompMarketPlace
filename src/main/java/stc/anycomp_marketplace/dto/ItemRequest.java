package stc.anycomp_marketplace.dto;

public class ItemRequest {

    private String name;
    private String description;
    private double price;
    private Integer quantity;

    public ItemRequest(){}

    public ItemRequest(String name, String description, double price, Integer quantity){
        this.name = name;
        this.description =description;
        this.price = price;
        this.quantity = quantity;
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

     public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
}
