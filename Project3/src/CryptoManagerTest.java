
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
* CryptoManagerTest ensures that the methods in Crypto Manager work as intended.
* @author Josue Ponce
* version 1.0
*/

class CryptoManagerTest {
/**
 * Thrown to signal abnormal conditions that will be handled by some catcher
 * @throws  IOException
 */
	@BeforeAll
	static void setUp() throws Exception {
	}
	
	/**
	 * Thrown to signal abnormal conditions that will be handled by some catcher
	 * @throws  IOException
	 */
	@AfterAll
	static void tearDown() throws Exception {
	}
	
    /** Verifies if a string is within the allowable bounds of ASCII codes .
     * For the first assert the method will return true because it is inbounds. 
     * if the string is out of range it will return false. 
     * if the string is in lower case letters the test will fail returning false. 
     */
	
	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.stringInBounds("THIS TEST SHOULD SUCCEED"));
		assertFalse(CryptoManager.stringInBounds("THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE"));
		assertFalse(CryptoManager.stringInBounds("This test should fail because of lowercase letters"));
	}
	
	/** Verifies if the Ceasar cipher is encrypting strings correctly. 
	 * This test also verifies that the string keys are all shifting the string 
	 * appropriately regardless of how large the integer is or if the integer is 
	 * a negative or positive number.
	 */
	
	@Test
	public void testEncryptCeasar() {
		assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.encryptCaesar("THIS IS ANOTHER TEST", 3));
		assertEquals("RFGQ^RCQR^QFMSJB^QSAACCB", CryptoManager.encryptCaesar("THIS TEST SHOULD SUCCEED", -2));
		assertEquals("DAHHK\\SKNH@", CryptoManager.encryptCaesar("HELLO WORLD",444));
	}
	
	/** Verifies if the Ceasar cipher is DecryptCeasarstrings correctly. 
	 * This test also verifies that the keys used originally to encrypt the string
	 * also decrypt the string properly. 
	 */
		
	@Test
	public void testDecryptCeasar() {
		
		assertEquals("HELLO WORLD", CryptoManager.decryptCaesar("DAHHK\\SKNH@",444));
		assertEquals("THIS TEST SHOULD SUCCEED", CryptoManager.decryptCaesar("RFGQ^RCQR^QFMSJB^QSAACCB", -2));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.decryptCaesar("WKLV#LV#DQRWKHU#WHVW", 3));
	}
	
	 /** Verifies that the string is encrypted correctly using Bellaso Cipher.
     * Also verifies if the string key is encrypting the string correctly and shifting letters appropriately. 
     */
	
	@Test
	public void testEncryptBellaso() {
		assertEquals("WN#\\N &",CryptoManager.encryptBellaso("TESTING","CIPHER_IS_LOWER_THAN_PLAINTEXT"));
		assertEquals("UJ^^((HT^X[YYM\"", CryptoManager.encryptBellaso("MERRY CHRISTMAS", "HELLO"));
		assertEquals("WU\\VR9F#N!RF88U-'HED",CryptoManager.encryptBellaso("THIS IS ANOTHER TEST", "CMSC203"));
	
	
	}
	
	 /** Verifies if the string is being decrypted properly using the original key from the Bellaso encryption.
	  * Also, verifies if the decrypted string outputs the original message. 
      */
	@Test
	public void testDecryptBellaso() {
		
		assertEquals("TESTING",CryptoManager.decryptBellaso("WN#\\N &","CIPHER_IS_LOWER_THAN_PLAINTEXT"));
		assertEquals("MERRY CHRISTMAS", CryptoManager.decryptBellaso("UJ^^((HT^X[YYM\"", "HELLO"));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.decryptBellaso("WU\\VR9F#N!RF88U-'HED", "CMSC203"));
	}
}
