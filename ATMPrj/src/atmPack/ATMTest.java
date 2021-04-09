package atmPack;

import static org.junit.Assert.*;
import org.junit.*;

public class ATMTest {

	/***************************************************************************************************************
	 * J-Unit Testing for ATM Project
	 * 
	 * @author Nicholas Cone, Ira Woodring
	 * @version February 4, 2017
	 ***************************************************************************************************************/
	/* some examples provided to help you get started */

	// Testing valid constructors with wide range of values
	@Test
	public void testConstructor() {
		ATM s1 = new ATM(6, 5, 4);

		assertEquals(s1.getHundred(), 6);
		assertEquals(s1.getFifty(), 5);
		assertEquals(s1.getTwenty(), 4);

		ATM s2 = new ATM();
		assertEquals(s2.getHundred(), 0);
		assertEquals(s2.getFifty(), 0);
		assertEquals(s2.getTwenty(), 0);

		ATM s3 = new ATM(s1);
		assertEquals(s3.getHundred(), 6);
		assertEquals(s3.getFifty(), 5);
		assertEquals(s3.getTwenty(), 4);
	}

	// testing valid takeOut with wide range of
	// quarters, dimes, nickels, pennies
	@Test
	public void testTakeOut1() {
		ATM s1 = new ATM(3, 3, 2);
		s1.takeOut(1, 1, 1);
		assertEquals(s1.getHundred(), 2);
		assertEquals(s1.getFifty(), 2);
		assertEquals(s1.getTwenty(), 1);
	}

	// testing valid takeOut with wide range of amounts
	 @Test
	 public void testTakeOut2() {
	 ATM s1 = new ATM(5,3,3);
	  s1.takeOut(1,0,1);
	  ATM s2 = new ATM(5,5,33);
	  s2.takeOut(4,5,32);
	
	 assertEquals (s1.getHundred(), 4);
	 assertEquals (s1.getFifty(), 3);
	 assertEquals (s1.getTwenty(), 2);
	
	 assertEquals (s2.getHundred(), 1);
	 assertEquals (s2.getFifty(), 0);
	 assertEquals (s2.getTwenty(), 1);
	 }

	// testing putIn for valid low numbers
	@Test
	public void testPutIn() {
		ATM s1 = new ATM();
		s1.putIn(2, 3, 4);
		assertEquals(s1.getHundred(), 2);
		assertEquals(s1.getFifty(), 3);
		assertEquals(s1.getTwenty(), 4);
	}

	// testing putIn and takeOut together
	@Test
	public void testPutInTakeOut() {
		ATM s1 = new ATM();
		s1.putIn(3, 3, 2);
		s1.takeOut(1, 1, 1);
		assertEquals(s1.getHundred(), 2);
		assertEquals(s1.getFifty(), 2);
		assertEquals(s1.getTwenty(), 1);
	}

	// Testing equals for valid numbers
	@Test
	public void testEqual() {
		ATM s1 = new ATM(2, 5, 4);
		ATM s2 = new ATM(6, 5, 4);
		ATM s3 = new ATM(2, 5, 4);

		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s3));
	}

	// testing compareTo all returns
	@Test
	public void testCompareTo() {
		ATM s1 = new ATM(2, 5, 4);
		ATM s2 = new ATM(6, 5, 4);
		ATM s3 = new ATM(2, 3, 4);
		ATM s4 = new ATM(2, 5, 4);

		assertTrue(s2.compareTo(s1) > 0);
		assertTrue(s3.compareTo(s1) < 0);
		assertTrue(s1.compareTo(s4) == 0);
	}

	// load and save combined.
	@Test
	public void testLoadSave() {
		ATM s1 = new ATM(6, 5, 4);
		ATM s2 = new ATM(6, 5, 4);

		s1.save("file1");
		s1 = new ATM(); // resets to zero

		s1.load("file1");
		assertTrue(s1.equals(s2));

	}

	@Test
	public void testMutate() {
		ATM s1 = new ATM(6, 5, 4);
		ATM.suspend(true);
		s1.takeOut(1, 0, 0);
		assertEquals(s1.getHundred(), 6);
		assertEquals(s1.getFifty(), 5);
		assertEquals(s1.getTwenty(), 4);
		ATM.suspend(false);
	}

	// IMPORTANT: only one test per exception!!!
	// testing negative number for hundreds, takeOut
	@Test(expected = IllegalArgumentException.class)
	public void testTakeOutNegHundreds() {
		ATM s1 = new ATM(87, 7, 7);
		s1.takeOut(-1, 1, 1);
	}

	// testing negative number for fifties, takeOut
	@Test(expected = IllegalArgumentException.class)
	public void testTakeOutNegFifties() {
		ATM s1 = new ATM(4, 3, 2);
		s1.takeOut(1, -1, 1);
	}

	// testing negative number for twenties, takeOut
	@Test(expected = IllegalArgumentException.class)
	public void testTakeOutNegTwenties() {
		ATM s1 = new ATM(2, 2, 2);
		s1.takeOut(1, 1, -1);
	}

	// testing negative number for hundreds, for constructors
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegHundreds() {
		new ATM(-300, 0, 0);
	}

	// testing negative number for fifties, for constructors
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegFifties() {
		new ATM(0, -57, 0);
	}

	// testing negative number for twenties, for constructors
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegTwenties() {
		new ATM(0, 0, -923);
	}

	// testing negative number for hundreds, putIn
	@Test(expected = IllegalArgumentException.class)
	public void testPutInNegHundreds() {
		ATM s = new ATM(9, 3, 4);
		s.putIn(-30, 2, 30);
	}
	// testing negative number for fifties, putIn
		@Test(expected = IllegalArgumentException.class)
		public void testPutInNegFifties() {
			ATM s = new ATM(9, 9, 9);
			s.putIn(77, -7, 98);
		}
	// testing negative number for twenties, putIn
		@Test(expected = IllegalArgumentException.class)
		public void testPutInNegTwenties() {
			ATM s = new ATM(6, 6, 3);
			s.putIn(30, 72, -672);
		}
}