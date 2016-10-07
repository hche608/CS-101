public class Star {
    private double x, y, z;  // coordinates of star
    private int draper;   // Henry Draper number (unique identifier)
    private double magnitude; // Magnitude (brightness) of star
    private String[] names;  // Star name(s) - not always present
    
    public Star( double x, double y, double z, int draper, double magnitude, String[] names ) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.draper = draper;
        this.magnitude = magnitude;
        this.names = names;
    }
    
    public String toString( ) {
        String info = "";
        for (int i = 0; i < names.length; i++) {
            info += names[i];
            if (i < names.length - 1) {
                info += ", ";
            }
        }
        info += " (" + draper + ")";
        return info;
    }
    
    public boolean isBrighterThan(Star other) {
        return magnitude < other.magnitude;
    }
    
    public boolean isCloserToOriginThan(Star other) {
        return (x * x + y * y) < (other.x * other.x + other.y * other.y);
    }
    
    public boolean isFurtherFromOriginThan(Star other) {
        return (x * x + y * y) > (other.x * other.x + other.y * other.y);
    }
    
    public int getNumberOfNames() {
        return names.length;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getZ() {
        return z;
    }
    
    public String getCoordinates() {
        return x + "," + y + "," + z;
    }
    
    public int getDraper() {
        return draper;
    }
    
    public double getMagnitude() {
        return magnitude;
    }
    
    public String[] getNames() {
        return names;
    }

}

