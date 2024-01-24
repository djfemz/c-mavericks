public class FactorialComputator{


public int calculateFactorial(int number){
	for(int index=number-1; index>=1; index--){
		number *= index;
	}
	return number;
}


public double calculateExponential(int number){
	int factorial=0;
	double exponential = 1.0;	
	for(int count=1; count<=number; count++){
		factorial = calculateFactorial(count);
		exponential += 1.0/factorial;

	}
	String num = String.format("%.2f", exponential);
	exponential = Double.parseDouble(num);
	return exponential;

}



	public float calculateExponentialPower(int number){
		float exponentialPower = 1f;
		for(int counter=1;counter<=number;counter++){
			int numerator = power(number, counter);
			int denominator = calculateFactorial(counter);
			exponentialPower+= numerator/(float)denominator;
			
		}
		String num = String.format("%.2f", exponentialPower);
		exponentialPower = Float.parseFloat(num);
		return exponentialPower;	

	}



	public int power(double number, int exponent){
		int pow=1;
		for(int count=0; count < exponent; count++){
			pow *= number;
		}
		return pow;
	}

	
}