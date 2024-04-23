public class Message {
    
    String input;

    public Message(String input) {
        this.input = input; // Set the input for the Decrypter object as a global variable
    }

    public void decryptInput() {
        for (int i = 0; i < 26; i++) { // This for loop will iterate through all possible keys
            System.out.println(decryptSingleMessage(i)); // Print out each attempt
        }
    }

    public String decryptSingleMessage(int key) {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //String containing all the upper case letters
        String lowerAlphabet = upperAlphabet.toLowerCase(); //String containing all the lower case letters
        String decrypted = ""; //String to store the decryped string

        if(input == null){ //If the input is null, tell the user and break out of the method
            System.out.println("Error! Input is null!");
            return "";
        }

        for (int i = 0; i < input.length(); i++) { // This will iterate through all possible characters in the string
            if (upperAlphabet.indexOf(input.charAt(i)) == -1 && lowerAlphabet.indexOf(input.charAt(i)) == -1) { //If the character is not a letter
                decrypted += input.charAt(i); // Add the character directly to the array as it is a space
            } else 
            if (upperAlphabet.indexOf(input.charAt(i)) != -1) { //If the letter is in the upperAlphabet
                char c = input.charAt(i); //Save the char
                int alphabetIndex = upperAlphabet.indexOf(c); //Get the current index of the char
                int shiftedIndex = (alphabetIndex - key); //Shift the index via the key
                while (shiftedIndex < 0) { //If it is negative, make it positive in mod 26
                    shiftedIndex += 26;
                }
                String newC = upperAlphabet.substring(shiftedIndex, shiftedIndex + 1); //Make a new string with the shifted index 
                decrypted += newC; //Add the new character to the decrypted string
            } else { //The character must be lower case
                char c = input.charAt(i); //Save the char
                int alphabetIndex = lowerAlphabet.indexOf(c); //Get the current index of the char
                int shiftedIndex = (alphabetIndex - key); //Shift the index via the key
                while (shiftedIndex < 0) { //If it is negative, make it positive in mod 26
                    shiftedIndex += 26;
                }
                String newC = lowerAlphabet.substring(shiftedIndex, shiftedIndex + 1); //Make a new string with the shifted index 
                decrypted += newC;  //Add the new character to the decrypted string
            }
            
        }
        return decrypted; //Return the decrypted string
    }
}