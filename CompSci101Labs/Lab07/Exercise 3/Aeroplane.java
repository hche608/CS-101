public class Aeroplane {
    
    private String make;
    private String model;
    private int yearOfManufacture;
    
    public Aeroplane(String make, String model, int year) {
        
        this.make = make;
        this.model = model;
        yearOfManufacture = year;
    }
    
    public String toString() {
        return yearOfManufacture + " " + make + " " + model;
    }
    
    public boolean isOlderThan(Aeroplane other) {
        return yearOfManufacture < other.yearOfManufacture;
    }
    
    public boolean equals(Aeroplane other) {
        return make.equals(other.make)
            && model.equals(other.model)
            && yearOfManufacture == other.yearOfManufacture;
    }

}