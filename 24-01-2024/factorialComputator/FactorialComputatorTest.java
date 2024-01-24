import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FactorialComputatorTest{

	@Test
	public void testCalculateFactorial(){
		FactorialComputator computator = new FactorialComputator();
		
		int factorial = computator.calculateFactorial(5);

		assertEquals(120, factorial);
		assertEquals(720, computator.calculateFactorial(6));

	}


	@Test
	public void testCalculateExponential(){
		FactorialComputator computator = new FactorialComputator();
		
		double exponential = computator.calculateExponential(5);

		assertEquals(2.72, exponential);
	}

	@Test
	public void testCalculateExponentialPower(){
		FactorialComputator computator = new FactorialComputator();
		
		double exponentialPower = computator.calculateExponentialPower(3);

		assertEquals(13.0f, exponentialPower);
	}

	@Test
	public void testPower(){
		FactorialComputator computator = new FactorialComputator();
		int square = computator.power(3, 2);
		assertEquals(9, square);
	}


	



}