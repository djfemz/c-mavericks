import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataEncryptorTest{


	@Test
	public void testForEncryptData(){
		DataEncryptor dataEncryptor = new DataEncryptor();
		
		String encryptionOfFirstInput = dataEncryptor.encrypt("2468");
		String encryptionOfSecondInput = dataEncryptor.encrypt("2357");
			
		assertEquals("3591", encryptionOfFirstInput);
		assertEquals("2490", encryptionOfSecondInput);
	}


	
	@Test
	public void testForEncryptDataWithLeadingZero(){
		
		DataEncryptor dataEncryptor = new DataEncryptor();
		
		String encryption = dataEncryptor.encrypt("0123");

		assertEquals("9078", encryption);
	}


	@Test
	public void testThatEncryptGeneratesOutputWithLeadingZeros(){
		
		DataEncryptor dataEncryptor = new DataEncryptor();
		
		String encryption = dataEncryptor.encrypt("1234");

		assertEquals("0189", encryption);
	}


	@Test
	public void testCanEncryptOnlyFourDigitNumbers(){
		
		DataEncryptor dataEncryptor = new DataEncryptor();
		
		assertThrows(IllegalArgumentException.class, ()->dataEncryptor.encrypt("123888"));
	}


	@Test
	public void testWillThrowExceptionWhenNegativeNumberIsEncrypted(){
		
		DataEncryptor dataEncryptor = new DataEncryptor();
		
		assertThrows(IllegalArgumentException.class, () -> dataEncryptor.encrypt("-123"));
	}


	
	@Test
	public void testValidateData(){
		
		DataEncryptor dataEncryptor = new DataEncryptor();
		
		assertFalse(dataEncryptor.isValidData("-123"));
		assertFalse(dataEncryptor.isValidData("0-23"));	
		assertFalse(dataEncryptor.isValidData("12_3"));
		assertFalse(dataEncryptor.isValidData("123+"));
		assertTrue(dataEncryptor.isValidData("1234"));

	}


	@Test
	public void testForDecryptData(){

		DataEncryptor dataEncryptor = new DataEncryptor();

		String decryptionOfFirstInput = dataEncryptor.decrypt("3591");
		String decryptionOfSecondInput = dataEncryptor.decrypt("2490");

		assertEquals("2468", decryptionOfFirstInput);
		assertEquals("2357", decryptionOfSecondInput);	
	}
	
}
