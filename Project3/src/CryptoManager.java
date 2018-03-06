/**
 * CryptoManger class encrypts and decrypts strings using either a caesar Cipher or 
 * Bellaso cipher. User gets to choose which method they would like to use for encryption
 * The GUI handles capitalization of strings and user selection prompt. 
 * 
 * @author Josue Ponce
 * version 1.0
 */


public class CryptoManager {

	/** Attribute LOWER_BOUND holds lower allowable bounds of ASCII codes. */
    private static final char LOWER_BOUND = ' ';
    
    /** Attribute UPPER_BOUND holds upper allowable bounds of ASCII codes.  */
    private static final char UPPER_BOUND = '_';
    
    /** Attribute RANGE holds UPPER_BOUND SUBTRACTED BY LOWER_BOUND. */
    private static final int RANGE = (int) UPPER_BOUND - (int) LOWER_BOUND + 1;


    /**

    * This method determines if a string is within the allowable bounds of ASCII codes 

    * according to the LOWER_BOUND and UPPER_BOUND characters

    * @param plainText a string to be encrypted, if it is within the allowable bounds

    * @return true if all characters within the string are within the allowable bounds, false if any characters are outside.

    */

    public static boolean stringInBounds(String plainText) {


        boolean neko = true;

        for (int i = 0; i < plainText.length(); i++) {

            if (!(charInBounds(plainText.charAt(i)))) {

                neko = false;
            }
        }

        return neko;
    }

    /** This method determines if a characters are within the allowable bounds of ASCII codes.

    *  according to the LOWER_BOUND and UPPER_BOUND characters

    * @param charAt is a character that will be encrypted if it's in the allowable bonds and false if character is outside. 

    * @return true if characters are greater or equal to the LOWER BOUND and Less than or equal to the UPPER_BOUND.

    */
    private static boolean charInBounds(char charAt) {

        if (charAt >= LOWER_BOUND && charAt <= UPPER_BOUND)

            return true;

        else
            return false;


    }
    /**

    * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset

    * and each character in plainText is replaced by the character \"offset\" away from it 

    * @param plainText an uppercase string to be encrypted.

    * @param key an integer that specifies the offset of each character

    * @return the encrypted string

    */

    public static String encryptCaesar(String plainText, int key) {

        String encryptedText = "";

        if (stringInBounds(plainText)) {
            for (int i = 0; i < plainText.length(); i++) {

                char t = plainText.charAt(i);

                int encryptedKey = ((int) t + key);


                while (encryptedKey < LOWER_BOUND || encryptedKey > UPPER_BOUND) {

                    encryptedKey += RANGE;

                }
                encryptedText += (char) encryptedKey;
            }
        }
        return encryptedText;
    }
    /**

     * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset

     * and each character in encryptedText is replaced by the character \"offset\" characters before it.

     * This is the inverse of the encryptCaesar method.

     * @param encryptedText an encrypted string to be decrypted.

     * @param key an integer that specifies the offset of each character

     * @return the plain text string

     */

    public static String decryptCaesar(String encryptedText, int key) {


        String decryptText = "";


        for (int i = 0; i < encryptedText.length(); i++) {

            char t = encryptedText.charAt(i);

            int decryptedNum = ((int) t - key);

            while (decryptedNum < LOWER_BOUND || decryptedNum > UPPER_BOUND) {

                decryptedNum += RANGE;

            }

            decryptText += (char) decryptedNum;

        }

        return decryptText;

    }


    /**

    * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 

    * according to the ASCII value of the corresponding character in bellasoStr, which is repeated

    * to correspond to the length of plainText

    * @param plainText an uppercase string to be encrypted.

    * @param bellasoStr an uppercase string that specifies the offsets, character by character.

    * @return the encrypted string

    */

    public static String encryptBellaso(String plainText, String bellasoStr) {

        String encryptedText = "";

        int bellasoLength = bellasoStr.length();

        for (int i = 0; i < plainText.length(); i++) {

            char meow = plainText.charAt(i);

            int encryptedKeyword = ((int) meow + (int) bellasoStr.charAt(i % bellasoLength));


            while (encryptedKeyword > (int) UPPER_BOUND) {

                encryptedKeyword -= RANGE;

            }
            encryptedText += (char) encryptedKeyword;
        }

        return encryptedText;




    }
    
    /**

    * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by

    * the character corresponding to the character in bellasoStr, which is repeated

    * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.

    * @param encryptedText an uppercase string to be encrypted.

    * @param bellasoStr an uppercase string that specifies the offsets, character by character.

    * @return the decrypted string

    */

    public static String decryptBellaso(String encryptedText, String bellasoStr) {
        String decryptedText = "";

        int bellasoStrlength = bellasoStr.length();

        for (int i = 0; i < encryptedText.length(); i++) {

            char t = encryptedText.charAt(i);

            int charIntEncrypt = ((int) t - (int) bellasoStr.charAt(i % bellasoStrlength));

            while (charIntEncrypt < LOWER_BOUND) {

                charIntEncrypt += RANGE;

            }

            decryptedText += (char) charIntEncrypt;

        }

        return decryptedText;
    }
}