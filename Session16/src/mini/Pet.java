package mini;

public class Pet {
    private String id;
    private String name;
    private String species;
    private int age;
    private double price;
    private String ownerId;

    public Pet(String id, String name, String species, int age, double price, String ownerId) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.price = price;
        this.ownerId = ownerId;
    }
    public String getId() {
        return id;
    }
    public String getOwnerId() {
        return ownerId;
    }
    @Override
    public String toString() {
        return "id: " + id + "name: " + name + "species: " + species + "age=" + age + "price=" + price + "ownerId='" + ownerId;
    }
}
