public class Ex02Program {
    public void start() {
        String cipher = "abcdefghijklmnopqrstuvwxyz ,.!";
        String plainAlphabet = "abcdefghijklmnopqrstuvwxyz ,.!";
        String cipherAlphabet = "zebrascdfghijklmnopqtuvwxy ,.!";
        String encrypted = "";
        int length = cipher.length();
        int i = 0;
        while ( i < length){
            char tempLetter = cipher.charAt(i);
            int position = plainAlphabet.indexOf(tempLetter);
            String encryptedLetter = cipherAlphabet.substring(position,position+1);
            encrypted = encrypted + encryptedLetter;
            i++;
   }
  
        System.out.println(encrypted); 
    
    }
}
