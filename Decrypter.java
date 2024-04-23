public class Decrypter {
    
    String input;

    public Decrypter(String input) {
        this.input = input; // Set the input for the Decrypter object as a global variable
    }

    public void decryptInput() {
        for (int i = 0; i < 26; i++) { // This for loop will iterate through all possible keys
            System.out.println(decryptSingleMessage(i)); // Print out each attempt
        }
    }

    public String decryptSingleMessage(int k) {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //String containing all the upper case letters
        String lowerAlphabet = upperAlphabet.toLowerCase(); //String containing all the lower case letters
        String decrypted = ""; //String to store the decryped string

        if(input == null){ //If the input is null, tell the user and break out of the method
            System.out.println("Error! Input is null!");
            return "";
        }

        for (int i = 0; i < input.length(); i++) { // This will iterate through all possible characters in the string
            if (upperAlphabet.indexOf(input.charAt(i)) == -1 && lowerAlphabet.indexOf(input.charAt(i)) == -1) { //If the character is not a letter
                decrypted += input.charAt(i); // Add the character directly to the array without c
            } else if (upperAlphabet.indexOf(input.charAt(i)) != -1) {
                char c = input.charAt(i);
                int alphabetIndex = upperAlphabet.indexOf(c);
                int shiftedIndex = (alphabetIndex - k);
                while (shiftedIndex < 0) {
                    shiftedIndex += 26;
                }
                String newC = upperAlphabet.substring(shiftedIndex, shiftedIndex + 1);
                decrypted += newC;
            } else {
                char c = input.charAt(i);
                int alphabetIndex = lowerAlphabet.indexOf(c);
                int shiftedIndex = (alphabetIndex - k) % 26;
                while (shiftedIndex < 0) {
                    shiftedIndex += 26;
                }
                String newC = lowerAlphabet.substring(shiftedIndex, shiftedIndex + 1);
                decrypted += newC;
            }
            
        }
        return decrypted;
    }
}