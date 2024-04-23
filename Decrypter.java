public class Decrypter {
    
    String input;

    public Decrypter(String input) {
        this.input = input; // Set the input for the Decrypter object as a global variable
    }

    public void decryptInput() {
        for (int i = 0; i < 25; i++) { // This for loop will iterate through all possible keys
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

        for (int i = 0; i < input.length()-1; i++) { // This will iterate through all possible characters in the string
            if (upperAlphabet.indexOf(input.charAt(i)) == -1 && lowerAlphabet.indexOf(input.charAt(i)) == -1) { //If the character is not a letter
                decrypted += input.charAt(i); // Add the character directly to the array without c
            } else if (upperAlphabet.indexOf(input.charAt(i)) != -1) {
                int index = (upperAlphabet.indexOf(input.charAt(i)) - k) % 26;
                decrypted += upperAlphabet.substring(index, index + 1);
            } else {
                int index = (lowerAlphabet.indexOf(input.charAt(i)) - k) % 26;
                decrypted += lowerAlphabet.substring(index, index + 1);
            }
            
        }
        return decrypted;
    }
}