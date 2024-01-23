public class DataEncryptor{


	public String encrypt(String data){
		if(!isValidData(data)) {
			IllegalArgumentException exception = new IllegalArgumentException("data must be four digits long");
			throw exception;
		
		}
		int firstDigit = data.charAt(0) - '0'; 
		int secondDigit = data.charAt(1)- '0';
		int thirdDigit = data.charAt(2) - '0';
		int fourthDigit = data.charAt(3) - '0';


		int digit1 = (firstDigit + 7) % 10;
		int digit2 = ((secondDigit + 7) % 10);
		int digit3 = ((thirdDigit + 7) % 10);
		int digit4 = (fourthDigit + 7) % 10;
		

		String result  = ""+ digit3 + digit4 + digit1 + digit2;

		return result;
	}

	public boolean isValidData(String data){
		if(data.length() != 4) {
			return false;
		}

		for(int index = 0; index < data.length(); index++){
			int digit = data.charAt(index) - '0';
			System.out.println(digit);
			if (digit < 0 || digit> 9) {
				return false;
			}

		}

		return true;

	}


}