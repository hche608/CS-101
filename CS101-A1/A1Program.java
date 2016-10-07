/*
============================
 UPI : HCHE608
============================
 CompSci 101 S2 2013
 
 
 Assignment 1 
******************************************************************************************************** 
This is a java application for encrypt the
message by using a cipherAlphabet which is created by user.
******************************************************************************************************** 

* *
*/

import java.util.*;
import java.io.*;

public class A1Program {
  public static final String PLAIN_ALPHA = "abcdefghijklmnopqrstuvwxyz"; 
  
//----------------------------------------------------------------
// Program starts here.
// 
//----------------------------------------------------------------
  public void start() {
    String userResponse = "";      
    int numberOfMessages = 0;
    String cipherAlphabet = "";
    
    displayTitle();  //2  
    
    cipherAlphabet = createCipher();  //Stage 2
    while (userResponse.length() == 0) {
      numberOfMessages++;    
      encrypt(cipherAlphabet);    // 8 + 9
      userResponse = getUserInput("Press enter to continue (anything else to quit)");  //1 + 4
    }
    
    displaySummary(numberOfMessages);   //3
  }
  
// Stage 2
//----------------------------------------------------------------
// Create the cipher alphabet using from a user given keyword. 
//----------------------------------------------------------------
  private String createCipher(){
    String userKeyword = ""; 
    String modifiedAlphabet  = "";
    String cipher = "";
    
    userKeyword = getUserInput("Please enter a valid keyword");  //1 + 4
    int length = userKeyword.length();
    while (length < 4){        //the length of a valid keyword must be greater than 3
      userKeyword = getUserInput("Please enter a valid keyword");
      length = userKeyword.length();
    }
    userKeyword = removeDuplicates(userKeyword);    //6
    modifiedAlphabet  = removeKeyword(userKeyword);     //7
    
    cipher = userKeyword + modifiedAlphabet ;           //Create the cipher

    int lengthOfAlpha = PLAIN_ALPHA.length();   //
    cipher = cipher.substring(0, lengthOfAlpha); //Only shows as long as the number of letters from PLAIN_ALPHA(it is able to use any symbol with any length)
    displayCipher(cipher);        //5  
    return cipher;    
    
  }
  
  
  
//1.+ 4.
//----------------------------------------------------------------
//-------- Method which obtains input from the user
//----------------------------------------------------------------
  private String getUserInput(String prompt) {
    System.out.print(prompt + " :");      // Print out the message from main method
    String userKeyword = Keyboard.readInput();  // Get the message from user
    userKeyword = userKeyword.toLowerCase();
    return userKeyword;
  }
  
//2.
//----------------------------------------------------------------
//-------- Display the title
//----------------------------------------------------------------
  private void displayTitle() {
    System.out.println("Secret Messages - by Hche608");  //Author 
  }
  
  
//3.
//----------------------------------------------------------------
//-------- Display summary information
//----------------------------------------------------------------
  private void displaySummary(int numberOfMessages) {
    System.out.println("==============================================");
    System.out.println("   Number of messages encrypted: " + numberOfMessages);  //Print out the counter.
    System.out.println("==============================================");
    return;
  }
  
  
// 5.
//----------------------------------------------------------------
//-------- Display plain text and cipher alphabets 
//----------------------------------------------------------------
  private void displayCipher(String cipher) {
    System.out.println("\n\n");
    System.out.println("   Plain Alphabet :" + PLAIN_ALPHA);
    System.out.println("   Cipher Alphabet:" + cipher);
    System.out.println("\n\n");      //Print out PLAIN_ALPHA and cipher
    
  }
  
//6.
//----------------------------------------------------------------
// Duplicate letters in the keyword are removed. 
// E.g. "mammal" will be changed to "mal".
// return the modified string with the duplicate letter removed.
//----------------------------------------------------------------
  private String removeDuplicates(String userKeyword){
    int length = userKeyword.length();
    int i = 0;
    String removedDuplicateLetter = "";       
    
    while (i < length){
      char tempLetter = userKeyword.charAt(i);  // Find a letter
      int letterCheck = removedDuplicateLetter.indexOf(tempLetter);            
      if (letterCheck == -1){                   //Check the letter if it exists in the removedDuplicateLetter
        removedDuplicateLetter = removedDuplicateLetter + tempLetter;  // Create the removedDuplicateLetter list
      }      
      i++;
    }
    return removedDuplicateLetter; 
  }
  
//7
//----------------------------------------------------------------
// loops through the plain alphabet (“abcdefghijklmnopqrstuvwxyz”) 
// and remove any of the characters in the parameters String, 
// modifiedKeyword, in the plain alphabet.
//---------------------------------------------------------------- 
//
  private String removeKeyword(String modifiedKeyword){
    String removeKeyword = "";
    //int length = modifiedKeyword.length();
    int lengthOfAlpha = PLAIN_ALPHA.length();
    int i = 0;
    
    while (i < lengthOfAlpha){ 
      char tempLetter = PLAIN_ALPHA.charAt(i);   // Find a letter from the PLAIN_ALPHA
      int letterCheck = modifiedKeyword.indexOf(tempLetter);            
      if (letterCheck == -1){               // Check the letter if it is exists in the word
        removeKeyword = removeKeyword + tempLetter;  //Check the removeKeyword list
      }      
      i++;
    }
    return removeKeyword;
  }
  
//8.    
//----------------------------------------------------------------
//-------- Display orignal and encrypted message information
//----------------------------------------------------------------
  private void displayEncryptedMessage(String originalMessage, String encryptedMessage) {
    System.out.println("\n\n");
    System.out.println("   Plain Text  : " + originalMessage);    //9
    System.out.println("   Cipher Text : " + encryptedMessage);  //9
    System.out.println("\n\n");
    
  }
  
// 9
//----------------------------------------------------------------
// Encrypted it by substituting the character with the corresponding character in the cipher.
// 
//----------------------------------------------------------------
  private void encrypt(String cipher){
    //String message = getUserInput("Enter message to be encrypted :");
    System.out.print("Enter message to be encrypted :");
    String originalMessage = Keyboard.readInput();      //Get a sentence/word from user
    originalMessage = originalMessage.toLowerCase();    //Convert to lower case
    String encrypted = "";
    int length = originalMessage.length();
    int i = 0;
    
    while ( i < length){
      char tempLetter = originalMessage.charAt(i); //Find each letter from originalMessage
      int position = PLAIN_ALPHA.indexOf(tempLetter); //Get the possition of the each letter
      if (position == -1){         //Check the the letter if it exists in the PLAIN_ALPHA
        encrypted = encrypted + tempLetter;            //if it does not exists in the PLAIN_ALPHA then return the letter as original   
      }else {                      //if it exists in the PLAIN_ALPHA, then encrypt the letter by using cipher
        String encryptedLetter = cipher.substring(position,position+1); //Locate the letter in cipher and return the encrypted letter
        encrypted = encrypted + encryptedLetter;
      }
      i++;
    } 
    displayEncryptedMessage(originalMessage, encrypted); //Pass to //8
  }
}
