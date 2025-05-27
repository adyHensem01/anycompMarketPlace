package stc.anycomp_marketplace.dto;

public class SellerRequest {

    private String name;
    private String email;

    public SellerRequest(String name, String email){
        this.name = name;
        this.email = email;
    }

    public SellerRequest(){}

  //getter and setter
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
    
}
