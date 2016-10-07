public class Ex2Program {
    public void start() {
        
        // Step 1. Declare and construct an array of 12 MobilePhone objects (name the array phones)
        MobilePhone[] phones = new MobilePhone[12];
        
        fillPhonesArray(phones);
        printPhonesArray(phones);
        
        MobilePhone mostExpensivePhone = getMostExpensivePhone(phones);
        int numberOfSamsungPhones = countPhones(phones, "Samsung");
        printResults(mostExpensivePhone, numberOfSamsungPhones, "Samsung");
        
    }
    
    private void fillPhonesArray(MobilePhone[] phones) {
        phones[0] = new MobilePhone("LG","P725 Optimus 3D Max",684.95);
        phones[1] = new MobilePhone("Apple","iPhone 5 64GB",1349.99);
        phones[2] = new MobilePhone("Apple","iPhone 5 16GB",1049.99);
        phones[3] = new MobilePhone("Apple","iPhone 4 8GB",753.57);
        phones[4] = new MobilePhone("Motorola","ES400",920.79);
        phones[5] = new MobilePhone("Samsung","GT-B7620 Giorgio Armani 2",683.97);
        phones[6] = new MobilePhone("LG","P720 Optimus 3D Max",665.88);
        phones[7] = new MobilePhone("Samsung","SGH-i897 Captivate",745.25);
        phones[8] = new MobilePhone("Nokia","E7",525.65);
        phones[9] = new MobilePhone("LG","P725 Optimus 3D Max",684.25);
        phones[10] = new MobilePhone("Samsung","GT-i903 Galaxy R",508.96);
        phones[11] = new MobilePhone("HTC","Vivid",633.74);
        
    }
    
    
    private void printPhonesArray(MobilePhone[] phonesForSale) {
        // Step 2.  Complete the printPhonesArray() method using a for loop and the toString() method
        //              in the MobilePhone class.
        System.out.println("Phones for Sale");
        System.out.println("===============");
        for (int i = 0; i < phonesForSale.length; i++){
            System.out.println(phonesForSale[i].toString());
        }
        
        
    }
    
    
    private MobilePhone getMostExpensivePhone(MobilePhone[] phones) {
        // Step 4.  Complete the mostExpensivePhone() method using a for loop
        //   and the isDearerThan() method in the MobilePhone class.
        MobilePhone mostExpensiveSoFar = phones[0];
        for (int i = 1; i < phones.length; i++){            
            if (!phones[i].isCheaperThan(mostExpensiveSoFar)){
                mostExpensiveSoFar = phones[i];
            }
        }
        return mostExpensiveSoFar;        
    }
    
    private int countPhones(MobilePhone[] phones, String brand) {
        // Step 5.  Complete the countPhones() method which returns the number of phones
        //   of the brand passed in as a parameter.
        int count = 0;
        for (int i = 0; i < phones.length; i++){
            if (phones[i].getBrand() == brand){
                count++;
            }
        }
        return count;
    }
    
    private void printResults(MobilePhone dearestMobilePhone, int numberOfPhones, String brand) {
        System.out.println();
        System.out.println("Most expensive mobile phone is: " + dearestMobilePhone.toString());
        System.out.println("There are: " + numberOfPhones + " " + brand + " phones.");
    }
    
}
