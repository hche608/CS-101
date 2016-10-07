public class Flying {
    public void start() {
        // Step 1. Declare an array of Aeroplane objects (named planes)
        
        Aeroplane[] planes;
        // Step 2. Construct the array of 10 Aeroplane objects
        planes = new Aeroplane[10];
        
        // Initialise the array of Aeroplane objects
        fillPlanesArray(planes);
        
        // Print the array of Aeroplane objects
        printPlanesArray(planes);
        
        // Print details of the fleet's oldest Aeroplane.
        Aeroplane oldestAeroplane = getOldestAeroplane(planes);
        System.out.println();
        System.out.println("Oldest aeroplane is: " + oldestAeroplane);
    }
    
    private void fillPlanesArray(Aeroplane[] aeroplanes) {
        aeroplanes[0] = new Aeroplane("Piper", "Cherokee", 1968);
        aeroplanes[1] = new Aeroplane("Cessna", "152", 1980);
        aeroplanes[2] = new Aeroplane("Cessna", "172", 2006);
        aeroplanes[3] = new Aeroplane("Piper", "Tomahawk", 1980);
        aeroplanes[4] = new Aeroplane("Piper", "Cub", 1956);
        aeroplanes[5] = new Aeroplane("Learjet", "23", 1970);
        aeroplanes[6] = new Aeroplane("Piper", "Cherokee", 1968);
        aeroplanes[7] = new Aeroplane("Airbus", "A320", 2001);
        aeroplanes[8] = new Aeroplane("Cirrus", "SR22", 2006);
        aeroplanes[9] = new Aeroplane("Cessna", "Caravan", 1986);
    }
    
    // Step 3.  Write the printPlanesArray() method
    private void printPlanesArray(Aeroplane[] planes){
        System.out.println("Fleet of Planes");
        System.out.println("---------------");
        for (int i = 0; i < planes.length; i++){
            System.out.println(planes[i].toString());
        }
    }
    
    
    
    // Step 4.  Write the getOldestAeroplane() method.
    private Aeroplane getOldestAeroplane(Aeroplane[] planes){
        Aeroplane oldestSoFar = planes[0];
        for (int i = 0; i < planes.length; i++){
            if (planes[i].isOlderThan(oldestSoFar)){
                oldestSoFar = planes[i];
            }
        }
        return oldestSoFar;
    }
    
    
    
}
