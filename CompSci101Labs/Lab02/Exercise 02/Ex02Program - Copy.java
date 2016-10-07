public class Ex02Program {
    public void start() {
        userKeyword = "mmilllmn";
        int length = userKeyword.length();
        int i = 0;
        String removedDuplicateLetter = "";       
        while (i <= length){
            char tempLetter = userKeyword.charAt(i);
            boolean letterCheck;            
            if (letterCheck = removedDuplicateLetter.indexOf(tempLetter) == -1){
                Character.toString(tempLetter);
                removedDuplicateLetter = removedDuplicateLetter + tempLetter;
            }
            
            i++;
   }
  
        return removedDuplicateLetter; 
    
    }
}
