package atmPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/***************************************************************************************************************
 * High end ATM Project GUI
 * 
 * @author Nicholas Cone
 * @version February 4, 2017
 ***************************************************************************************************************/
public class MyATMPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** menu items */
	JMenuItem quitItem;
	JMenuItem newGameItem;
	JMenuBar menus;

	/** ATM items */
	private ATM ATM1;
	private ATM ATM2;
	private ATM ATM3;
	private ATM current;

	/** text fields for user input */
	private JTextArea resultsArea;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	/** boolean value to control suspend */
	private boolean i = false;

	/** Buttons for each player action */
	private JButton withdrawal;
	private JButton deposit;
	private JButton suspend;

	/** Buttons for each ATM */
	private JButton one;
	private JButton two;
	private JButton three;

	/***************************************************************************************************************
	 * Main Method to run GUI
	 ***************************************************************************************************************/
	public static void main(String[] args) {
		JFrame frame = new JFrame("ATM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyATMPanel panel = new MyATMPanel();
		frame.getContentPane().add(panel);
		frame.setTitle(" ATM ");

		frame.pack();
		frame.setVisible(true);
	}

	/***************************************************************************************************************
	 * Positions Buttons, Menus, TextFields, and initial
	 ***************************************************************************************************************/
	public MyATMPanel() {
		setLayout(new GridBagLayout());
		GridBagConstraints position = new GridBagConstraints();
		ATMListener listener = new ATMListener();
		setupMenus();
		// sets starting values for all ATMs
		ATM1 = new ATM(0, 0, 0);
		ATM2 = new ATM(20, 20, 20);
		ATM3 = new ATM(1000, 1000, 1000);
		current = null;

		// displays results of atm;
		resultsArea = new JTextArea(20, 35);
		JScrollPane scrollPane = new JScrollPane(resultsArea);
		position.gridx = 0;
		position.gridy = 2;
		position.gridheight = 5;
		position.gridwidth = 5;
		position.insets = new Insets(10, 80, 0, 0);
		add(scrollPane, position);

		// sets label and text field for hundreds
		position = makeConstraints(1, 10, 1, 1, GridBagConstraints.LINE_END);
		position.insets = new Insets(1, 5, 2, 1);
		add(new JLabel("Hundreds:"), position);

		position = makeConstraints(1, 11, 1, 1, GridBagConstraints.LINE_END);
		position.insets = new Insets(1, 5, 2, 1);
		text1 = new JTextField(5);
		add(text1, position);
		// sets label and text field for fifties
		position = makeConstraints(2, 10, 1, 1, GridBagConstraints.CENTER);
		position.insets = new Insets(1, 5, 2, 1);
		add(new JLabel("Fifties:"), position);

		position = makeConstraints(2, 11, 1, 1, GridBagConstraints.CENTER);
		position.insets = new Insets(1, 5, 2, 1);
		text2 = new JTextField(3);
		add(text2, position);
		// sets label and text field for twenties
		position = makeConstraints(3, 10, 1, 1, GridBagConstraints.LINE_END);
		position.insets = new Insets(1, 5, 2, 40);
		add(new JLabel("Twenties:"), position);

		position = makeConstraints(3, 11, 1, 1, GridBagConstraints.LINE_END);
		position.insets = new Insets(1, 5, 2, 40);
		text3 = new JTextField(5);
		add(text3, position);

		// Adds Deposit button
		deposit = new JButton("Deposit");
		deposit.addActionListener(listener);
		position = makeConstraints(1, 1, 1, 1, GridBagConstraints.LINE_START);
		position.insets = new Insets(2, 30, 2, 1);
		add(deposit, position);

		// Adds Withdrawal Button
		withdrawal = new JButton("WithDrawal");
		withdrawal.addActionListener(new ATMListener());
		position = makeConstraints(2, 1, 1, 1, GridBagConstraints.LINE_START);
		position.insets = new Insets(2, 1, 2, 1);
		add(withdrawal, position);

		// Adds Suspend Button
		suspend = new JButton("Suspend");
		suspend.addActionListener(new ATMListener());
		position = makeConstraints(3, 1, 1, 1, GridBagConstraints.LINE_START);
		position.insets = new Insets(2, 1, 2, 1);
		add(suspend, position);
		// suspend.addActionListener(this);

		// Adds ATM1 button
		one = new JButton("ATM1");
		one.addActionListener(new ATMListener());
		position = makeConstraints(0, 3, 1, 1, GridBagConstraints.LINE_START);
		position.insets = new Insets(2, 0, 2, 0);
		add(one, position);

		// Adds ATM2 Button
		two = new JButton("ATM2");
		two.addActionListener(new ATMListener());
		position = makeConstraints(0, 4, 1, 1, GridBagConstraints.LINE_START);
		position.insets = new Insets(2, 0, 2, 0);
		add(two, position);

		// Adds ATM3 Buttom
		three = new JButton("ATM3");
		three.addActionListener(new ATMListener());
		position = makeConstraints(0, 5, 1, 1, GridBagConstraints.LINE_START);
		position.insets = new Insets(2, 0, 2, 0);
		add(three, position);

		if (current == null) {
			resultsArea.setText("Please select an ATM first!");
		}

	}

	/***************************************************************************************************************
	 * Sets up Jmenu with reset and quit button
	 ***************************************************************************************************************/
	private void setupMenus() {
		// Setup the file menu with a reset ATMs and quit option
		menus = new JMenuBar();
		add(menus);
		JMenu fileMenu = new JMenu("File");
		menus.add(fileMenu);
		// Sets up resetting the atm and quit button
		newGameItem = new JMenuItem("Reset ATMs");
		newGameItem.addActionListener(new ATMListener());
		quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(new ATMListener());

		fileMenu.add(newGameItem);
		fileMenu.add(quitItem);

	}

	/***************************************************************************************************************
	 * Create a custom gridbag constraint
	 ***************************************************************************************************************/
	private GridBagConstraints makeConstraints(int x, int y, int h, int w, int align) {
		GridBagConstraints rtn = new GridBagConstraints();
		rtn.gridx = x;
		rtn.gridy = y;
		rtn.gridheight = h;
		rtn.gridwidth = w;

		// set alignment: LINE_START, CENTER, LINE_END
		rtn.anchor = align;
		return rtn;
	}

	/***************************************************************************************************************
	 * Handles all button and menu selections
	 * 
	 * @parameter e the component that was pressed
	 ***************************************************************************************************************/
	private class ATMListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// displays how much is in the current atmm
			if (current == ATM1) {
				resultsArea.setText("ATM1 currently has: " + "\n" + ATM1.toString());
			} else if (current == ATM2) {
				resultsArea.setText("ATM2 currently has: " + "\n" + ATM2.toString());
			} else if (current == ATM3) {
				resultsArea.setText("ATM3 currently has: " + "\n" + ATM3.toString());
			}
			/***************************************************************************************************************
			 * If the user clicks on an ATM button, GUI displays how much is currently in that
			 * atm and disables the current button so user knows which ATM they're currently using
			 ***************************************************************************************************************/
			if (e.getSource() == one) {
				resultsArea.setText("ATM1 currently has: $" + ATM1.getAmount() + "\n" + ATM1.toString());
				current = ATM1;
				one.setEnabled(false);
				three.setEnabled(true);
				two.setEnabled(true);
			}
			if (e.getSource() == two) {
				resultsArea.setText("ATM2 currently has: $" + ATM2.getAmount() + "\n" + ATM2.toString());
				current = ATM2;
				two.setEnabled(false);
				one.setEnabled(true);
				three.setEnabled(true);
			}
			if (e.getSource() == three) {
				resultsArea.setText("ATM3 currently has: $" + ATM3.getAmount() + "\n" + ATM3.toString());
				current = ATM3;
				three.setEnabled(false);
				one.setEnabled(true);
				two.setEnabled(true);
			}
			
			/***************************************************************************************************************
			 * Method that adds the input to the ATM when the button is pressed
			 ***************************************************************************************************************/
			if (e.getSource() == deposit) {
				if (i == true) {
					resultsArea.setText("Sorry this atm is suspended");
					return;
				}
				int h = Integer.valueOf(text1.getText());
				int f = Integer.valueOf(text2.getText());
				int t = Integer.valueOf(text3.getText());
				if (current == new ATM()) {
					String errorMessage = "Did you forget to choose an ATM?";
					resultsArea.setText(errorMessage);
					return;
				}
				if (h < 0 || f < 0 || t < 0) {
					String errorMessage = "Did you forget to put in a positive integer?";
					resultsArea.setText(errorMessage);
					return;
				} else if (h >= 0 && f >= 0 && t >= 0) {
					if (current == ATM1) {
						ATM1.putIn(h, f, t);
						resultsArea.setText("ATM1 currently has: $" + ATM1.getAmount() + "\n" + ATM1.toString());
					} else if (current == ATM2) {
						ATM2.putIn(h, f, t);
						resultsArea.setText("ATM2 currently has: $" + ATM2.getAmount() + "\n" + ATM2.toString());
					} else if (current == ATM3) {
						ATM3.putIn(h, f, t);
						resultsArea.setText("ATM3 currently has: $" + ATM3.getAmount() + "\n" + ATM3.toString());
					}

				}
			}
			/***********************************************************************************
			 * If user clicks on suspend, the Atm is suspended. In order to
			 * un-suspend the atm, the user must click on the suspend button
			 * again.
			 **********************************************************************************/
			if (e.getSource() == suspend) {
				// checks alternating boolean value to suspend the atm.
				if (i == false) {
					resultsArea.setText("Sorry this atm is suspended");
					ATM.suspend(true);
					three.setEnabled(false);
					one.setEnabled(false);
					two.setEnabled(false);
					i = true;
					return;
				} else if (i == true) {
					ATM.toggleSuspend();
					resultsArea.setText("Please select an ATM");
					three.setEnabled(true);
					one.setEnabled(true);
					two.setEnabled(true);
					i = false;
					return;
				}

			}
			
			/***************************************************************************************************************
			 * Resets all ATMs with the original starting values
			 ***************************************************************************************************************/
			if (e.getSource() == newGameItem) {
				ATM1 = new ATM(0, 0, 0);
				ATM2 = new ATM(20, 20, 20);
				ATM3 = new ATM(1000, 1000, 1000);
				current = ATM1;
				resultsArea.setText("All ATM's have been reset. \n Please select an ATM");
			}
			
			/***************************************************************************************************************
			 * Exits the GUI is user selects the quit button
			 ***************************************************************************************************************/
			if (e.getSource() == quitItem) {
				System.exit(1);
			}
			
			/***************************************************************************************************************
			 * Method that takes the input from the ATM when the button is pressed
			 ***************************************************************************************************************/
			if (e.getSource() == withdrawal) {
				// checks boolean value for suspend so the text area wont change
				// if atm is suspended
				if (i == true) {
					resultsArea.setText("Sorry this atm is suspended");
					return;
				}
				// Gets the  value of the user input
				int h = Integer.valueOf(text1.getText());
				int f = Integer.valueOf(text2.getText());
				int t = Integer.valueOf(text3.getText());
				int H = 0;
				int F = 0;
				int T = 0;
				// checks last atm the user selected and gets how much there is
				// of each bill
				if (current == ATM1) {
					H = ATM1.getHundred();
					F = ATM1.getFifty();
					T = ATM1.getTwenty();
				} else if (current == ATM2) {
					H = ATM2.getHundred();
					F = ATM2.getFifty();
					T = ATM2.getTwenty();
				} else if (current == ATM3) {
					H = ATM3.getHundred();
					F = ATM3.getFifty();
					T = ATM3.getTwenty();
				}
				// Checks to make sure ATM has enough hundreds to withdrawal
				if (H - h < 0) {
					String in = "Sorry, this ATM has insufficicent hundred dollar bills.";
					resultsArea.setText(in);
					return;
				}
				// Checks to make sure the ATM has enough fifties to withdrawal
				if (F - f < 0) {
					String in = "Sorry, this ATM has insufficicent fifty dollar bills.";
					resultsArea.setText(in);
					return;
				}
				// Checks to make sure the ATM has enough twenties to withdrawal
				if (T - t < 0) {
					String in = "Sorry, this ATM has insufficicent twenty dollar bills.";
					resultsArea.setText(in);
					return;
				}
				// Checks to make sure user did not put in a negative number
				if (h < 0 || f < 0 || t < 0) {
					String errorMessage = "Did you forget to put in a positive integer?";
					resultsArea.setText(errorMessage);
					return;
				} else if (h >= 0 && f >= 0 && t >= 0) {
					// checks which atm the user last selected and takes out the
					// amount that the user input in from that atm
					if (current == ATM1) {
						ATM1.takeOut(h, f, t);
						resultsArea.setText("ATM1 currently has: $" + ATM1.getAmount() + "\n" + ATM1.toString());
					} else if (current == ATM2) {
						ATM2.takeOut(h, f, t);
						resultsArea.setText("ATM2 currently has: $" + ATM2.getAmount() + "\n" + ATM2.toString());
					} else if (current == ATM3) {
						ATM3.takeOut(h, f, t);
						resultsArea.setText("ATM3 currently has: $" + ATM3.getAmount() + "\n" + ATM3.toString());
					}
				}
			}
		}
	}
}