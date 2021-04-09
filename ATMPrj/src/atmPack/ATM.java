package atmPack;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/***************************************************************************************************************
 * High end ATM Project
 * 
 * @author Nicholas Cone
 * @version February 4, 2017
 ***************************************************************************************************************/
public class ATM {
	private int hundred;
	private int fifty;
	private int twenty;
	private static boolean suspend = false;

	/***************************************************************************************************************
	 * Default constructor that sets the ATM to zero
	 ***************************************************************************************************************/
	public ATM() {
		// sets up instance variables for new atm
		hundred = 0;
		fifty = 0;
		twenty = 0;

	}

	/***************************************************************************************************************
	 * A constructor that initializes the instance variables for the ATM with
	 * the parameters.
	 ***************************************************************************************************************/
	public ATM(int hundred, int fifty, int twenty) {
		this.hundred = hundred;
		this.fifty = fifty;
		this.twenty = twenty;
		// checks if value is negative and throws and Illegal argument exception
		if (hundred < 0 || fifty < 0 || twenty < 0) {
			throw new IllegalArgumentException();
		}
	}

	/***************************************************************************************************************
	 * A constructor that initializes the instance variables with the other ATM
	 * parameter.
	 ***************************************************************************************************************/
	public ATM(ATM other) {
		this.hundred = other.hundred;
		this.fifty = other.fifty;
		this.twenty = other.twenty;
	}

	/***************************************************************************************************************
	 * Accessor Methods for objects of class ATM.
	 ***************************************************************************************************************/

	/***************************************************************************************************************
	 * Sets Hundreds to the parameter value
	 * 
	 * @parameter the value that you would like to set hundred to
	 ***************************************************************************************************************/
	public void setHundred(int h) {
		if (h >= 0) {
			hundred = h;
		} else {
			System.out.print("Did you forget to put in a positive amount of hundreds?");
			return;
		}
	}

	/***************************************************************************************************************
	 * Gets the current value for Hundreds returned
	 * 
	 * @return int hundred
	 ***************************************************************************************************************/
	public int getHundred() {
		return hundred;
	}

	/***************************************************************************************************************
	 * Sums the total amount of money in the ATM
	 * 
	 * @return total amount in ATM
	 ***************************************************************************************************************/
	public int getAmount() {
		int total = (hundred * 100) + (fifty * 50) + (twenty * 20);
		return total;
	}

	/***************************************************************************************************************
	 * Sets Fifties to the parameter value
	 * 
	 * @parameter the value that you would like to set fifty to
	 ***************************************************************************************************************/
	public void setFifty(int f) {
		if (f >= 0) {
			fifty = f;
		} else {
			System.out.print("Did you forget to put in a positive amount of fifties?");
			return;
		}
	}

	/***************************************************************************************************************
	 * Gets the current value for fifties returned
	 * 
	 * @return int fifty
	 ***************************************************************************************************************/
	public int getFifty() {
		return fifty;
	}

	/***************************************************************************************************************
	 * Sets Twenties to the parameter value
	 * 
	 * @parameter the value that you would like to set twenty to
	 ***************************************************************************************************************/
	public void setTwenty(int t) {
		if (t >= 0) {
			twenty = t;
		} else {
			System.out.print("Did you forget to put in a positive amount of twenties?");
			return;
		}
	}

	/***************************************************************************************************************
	 * Gets the current value for fifties returned
	 * 
	 * @return int fifty
	 ***************************************************************************************************************/
	public int getTwenty() {
		return twenty;
	}

	/***************************************************************************************************************
	 * Method that returns true if this ATM object is the same as the other
	 * object
	 * 
	 * @parameter other object
	 * @return true if objects are equal to eachother
	 * @return false if object are not equal to eachother
	 ***************************************************************************************************************/
	public boolean equals(Object s) {
		if (s instanceof ATM) {
			return this.equals((ATM) s);
		} else {
			return false;
		}
	}

	/***************************************************************************************************************
	 * A method that returns true if this ATM object is the same as the other
	 * ATM object
	 * 
	 * @parameter other ATM object
	 * @return true if the ATM objects are equal to eachother
	 * @return false if the ATM objects are not equal to eachother
	 ***************************************************************************************************************/
	public boolean equals(ATM other) {
		return this.hundred == other.hundred && this.fifty == other.fifty && this.twenty == other.twenty;

	}

	/***************************************************************************************************************
	 * A static method that returns true if this first ATM parameter is the same
	 * as the second ATM parameter
	 * 
	 * @parameter other1 ATM object
	 * @parameter other2 ATM object
	 * @return true if the ATM objects are equal to eachother
	 * @return false if the ATM objects are not equal to eachother
	 ***************************************************************************************************************/
	public static boolean equals(ATM other1, ATM other2) {
		return other1.equals(other2);
	}

	/***************************************************************************************************************
	 * A method that compares the other ATM total and the "this" ATM total
	 * 
	 * @parameter other ATM object
	 * @return 1 if the this ATM total is greater than the other ATM total
	 * @return -1 if the this ATM total is less than the other ATM total
	 * @return 0 if the this ATM total is equal to the other ATM total
	 ***************************************************************************************************************/
	public int compareTo(ATM other) {
		int total = (this.hundred * 100) + (this.fifty * 50) + (this.twenty * 20);
		int ototal = (other.hundred * 100) + (other.fifty * 50) + (other.twenty * 20);
		if (ototal == total) {
			return 0;
		} else if (ototal < total) {
			return 1;
		}
		return -1;
	}

	/***************************************************************************************************************
	 * A method that compares the first parameter ATM total and the second
	 * parameter ATM total
	 * 
	 * @parameter other1 (ATM object)
	 * @parameter other2 (ATM object)
	 * @return 1 if the first parameter ATM total is greater than the second
	 *         parameter ATM total
	 * @return -1 if the first parameter ATM total is less than the second
	 *         parameter ATM total
	 * @return 0 if the first parameter ATM total is equal to the second
	 *         parameter ATM total
	 ***************************************************************************************************************/
	public static int compareTo(ATM other1, ATM other2) {
		int total2 = (other2.hundred * 100) + (other2.fifty * 50) + (other2.twenty * 20);
		int total1 = (other1.hundred * 100) + (other1.fifty * 50) + (other1.twenty * 20);
		if (total1 == total2) {
			return 0;
		} else if (total1 < total2) {
			return -1;
		}
		return 1;
	}

	/***************************************************************************************************************
	 * A method that adds the parameters from the this ATM object
	 * 
	 * @parameter int hundred
	 * @parameter int fifty
	 * @parameter int twenty
	 * @throws IllegalArgumentException();
	 *             if user inputs a negative integer for the parameter
	 ***************************************************************************************************************/
	public void putIn(int hundred, int fifty, int twenty) {
		if (suspend) {
			return;
		}
		// checks if value is negative and throws and Illegal argument exception
		if (hundred < 0 || fifty < 0 || twenty < 0) {
			throw new IllegalArgumentException();
		}
		this.hundred += hundred;
		this.fifty += fifty;
		this.twenty += twenty;
	}

	/***************************************************************************************************************
	 * A method that adds ATM other to the this ATM object
	 * 
	 * @parameter ATM other
	 ***************************************************************************************************************/
	public void putIn(ATM other) {
		// makes sure ATM is not suspended
		if (suspend) {
			return;
		}
		hundred += other.hundred;
		fifty += other.fifty;
		twenty += other.twenty;
	}

	/***************************************************************************************************************
	 * A method that adds the parameters from the this ATM object
	 * 
	 * @parameter int hundred
	 * @parameter int fifty
	 * @parameter int twenty
	 * @throws IllegalArgumentException();
	 *             if user inputs a negative integer
	 ***************************************************************************************************************/
	public void takeOut(int hundred, int fifty, int twenty) {
		// makes sure ATM is not suspended
		if (suspend) {
			return;
		}
		// checks if value is negative and throws and Illegal argument exception
		if (hundred < 0 || fifty < 0 || twenty < 0) {
			throw new IllegalArgumentException();
		}
		this.hundred -= hundred;
		this.fifty -= fifty;
		this.twenty -= twenty;
	}

	/***************************************************************************************************************
	 * A method that subtracts ATM other to the this ATM object
	 * 
	 * @parameter ATM other
	 ***************************************************************************************************************/
	public void takeOut(ATM other) {
		// makes sure ATM is not suspended
		if (suspend) {
			return;
		}
		hundred -= other.hundred;
		fifty -= other.fifty;
		twenty -= other.twenty;
	}

	/***************************************************************************************************************
	 * A method that returns a string that represents a ATM
	 * 
	 * @return String with the values for ATM objects
	 ***************************************************************************************************************/
	public String toString() {
		String h = "";
		String t = "";
		String f = "";
		// determines if bill needs to be singular or plural
		if (hundred == 1) {
			h = "bill, ";
		} else if (hundred > 1 || hundred == 0) {
			h = "bills, ";
		}
		if (fifty > 1 || fifty == 0) {
			f = "bills, and ";
		} else if (fifty == 1) {
			f = "bill, and ";
		}
		if (twenty == 1) {
			t = "bill.";
		} else if (twenty > 1 || twenty == 0) {
			t = "bills.";
		}

		String W = (hundred + " hundred dollar " + h + "\n" + fifty + " fifty dollar " + f + "\n" + twenty
				+ " twenty dollar " + t);
		return W;
	}

	/***************************************************************************************************************
	 * A method that loads the this ATM object from a file
	 * 
	 * @parameter name of the file the user wants to load
	 ***************************************************************************************************************/
	public void load(String filename) {

		try {
			// open the data file
			Scanner fileReader = new Scanner(new File(filename));

			// read one String in of data and an int
			hundred = fileReader.nextInt();
			fifty = fileReader.nextInt();
			twenty = fileReader.nextInt();
			System.out.println("File Contains: " + hundred + " " + fifty + " " + twenty);
			fileReader.close();
		}

		// could not find file
		catch (Exception error) {
			System.out.println("File not found ");
		}
	}

	/***************************************************************************************************************
	 * A method that saves the this ATM object to a file
	 * 
	 * @parameter name of the file the user wants to load
	 ***************************************************************************************************************/
	public void save(String filename) {
		PrintWriter out = null;
		String fileContents = hundred + " " + fifty + " " + twenty;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
		} catch (IOException e) {
			e.printStackTrace();
		}

		out.println(fileContents);
		out.close();
	}

	/***************************************************************************************************************
	 * A method that turns off takeOut and putIn methods
	 * 
	 * @parameter boolean on
	 ***************************************************************************************************************/
	public static void suspend(boolean on) {
		suspend = on;
	}

	/***************************************************************************************************************
	 * A method that turns on takeOut and putIn methods
	 * 
	 ***************************************************************************************************************/
	public static void toggleSuspend() {
		suspend = !suspend;
	}

	/***************************************************************************************************************
	 * The Main Method that does various tests on the ATM
	 ***************************************************************************************************************/
	public static void main(String[] args) {
		ATM s = new ATM(10, 2, 3);
		System.out.println("Created ChangeJar:$1160, result: " + s.getAmount());

		ATM s1 = new ATM();
		System.out.println("\nCreated ChangeJar:$0, result: " + s1.getAmount());

		s1.putIn(10, 2, 3);
		System.out.println("\nAdded ChangeJar:$1160, result: " + s1.getAmount());

		ATM s2 = new ATM(10, 2, 3);
		s2.putIn(0, 0, 0);
		System.out.println("\nAdded ChangeJar:$1160, result: " + s2.getAmount());

		s2 = new ATM(2, 1, 3);
		s2.takeOut(2, 1, 0);
		System.out.println("\nTake out the following:\n"
				+ " 2 hundred dollar bills\n 1 fifty dollar bill \n 0 twenty dollar bills");
		System.out.println("Remaining ChangeJar:$60, result: " + s2.getAmount());

		s2 = new ATM(5, 4, 3);
		s2.save("pizza");
		s2 = new ATM();
		s2.load("pizza");

		if (s2.equals(new ATM(5, 4, 3)))
			System.out.println("\nLoad and Save and Equals works!");

		System.out.println(s2);

		// tests if user tries to set hundreds to a negative amount
		ATM s3 = new ATM(2, 1, 3);
		System.out.println("\nAttempt to set value of hundreds to a Negative Value\n "
				+ "Should return error message and not change the final amount");
		s3.setHundred(-2);
		System.out.println("\nRemaining ChangeJar:$310, result: " + s3.getAmount());

		// tests if user tries to set fifties to a negative amount
		ATM s4 = new ATM(1, 6, 0);
		System.out.println("\nAttempt to set value of fifties to a Negative Value\n"
				+ "Should return error message and not change the final amount");
		s4.setFifty(-2);
		System.out.println("\nRemaining ChangeJar:$400, result: " + s4.getAmount());

		// tests if user tries to set twenties to a negative amount
		ATM s5 = new ATM(4, 1, 2);
		System.out.println("\nAttempt to set value of twenties to a Negative Value\n"
				+ "Should return error message and not change the final amount");
		s5.setTwenty(-2);
		System.out.println("\nRemaining ChangeJar:$490, result: " + s5.getAmount());

		// tests all get methods
		ATM s6 = new ATM(4, 1, 2);
		System.out.println(s6.toString());
		System.out.println("Test all get methods for atm above\n");
		// make sure that the get methods return the same value as the atm
		System.out.println(s6.getHundred());
		System.out.println(s6.getFifty());
		System.out.println(s6.getTwenty());
		System.out.println("\nRemaining ChangeJar:$490, result: " + s6.getAmount());

		// test equal method
		ATM s7 = new ATM(2, 5, 4);
		ATM s8 = new ATM(6, 5, 4);
		ATM s9 = new ATM(2, 5, 4);

		if (s7.equals(s8) == true) {
			System.out.println("Test for equal method: Failed");
		}
		if (s7.equals(s9) == true) {
			System.out.println("Test for equal method: Passed!");
		}
		if (s7.compareTo(s8) == 0) {
			System.out.println("Test for compare method: Failed");
		}
		if (s7.compareTo(s9) == 0) {
			System.out.println("Test for compare method: Passed!");
		}
	}

}
