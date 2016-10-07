public class MobilePhone {
    
    private String brand; // brand
    private String model; // model
    private double price; // price
    
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String toString() {
        String info = "";
        info += brand + " " + model + ": $" + price;
        return info;
    }
    
    public boolean isCheaperThan(MobilePhone other) {
        return price < other.price;
    }
    
    public boolean isDearerThan(MobilePhone other) {
        return price > other.price;
    }
    
    public boolean equals(MobilePhone other) {
        return brand.equals(other.brand)
            && model.equals(other.model)
            && price == other.price;
    }

}


