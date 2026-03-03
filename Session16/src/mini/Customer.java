package mini;

public class Customer {
    private String id;
    private String name;
    private String phone;
    private int loyaltyPoint;

    public Customer(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.loyaltyPoint = 0;
    }

    public String getId() {
        return id;
    }
    @Override
    public String toString() {
        return "ID: " + id + "Name: " + name + "Phone" + phone + "loyaltyPoint" + loyaltyPoint;
    }
}
