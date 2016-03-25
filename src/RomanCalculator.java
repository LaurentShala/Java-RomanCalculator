import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RomanCalculator extends JPanel implements ActionListener {
	// Instance Variables
	// Final values for rows, columns, and frame size
	private final int width = 300;
	private final int height = 400;
	private final int centerRows = 4;
	private final int centerCols = 4;
	private final int NorthRows = 3;
	private final int NorthCols = 2;

	// Variables for calculations
	private int firstInt = 0;
	private int secondInt = 0;
	private int resultInt = 0;
	private String resultRoman = "";
	private char operator = ' ';
	private boolean isOperatorPressed = false;
	private boolean isFirstDone = false;

	// Declaring 3 Roman Objects
	private Roman r1 = null;
	private Roman r2 = null;
	private Roman r3 = null;

	// Declaring the panels
	private JPanel jpButtons = null;
	private JPanel jpTextFields = null;

	// Arrays for the text fields and their titles
	private JTextField[] textFields = null;
	private String[] textFieldTitles = { "Roman1", "Integer1", "Roman2", 
										 "Integer2", "Result", "Integer3" };
	
	// Arrays for the buttons and their titles
	private JButton[] buttons = null;
	private String[] buttonTitles = { "I", "V", "X", "L", "C", "D", "M", 
									  "CE", "-", "+", "/", "%", "*", "=" };

	// Default Constructor
	public RomanCalculator() {
		// Calling the super
		// Must be first thing in the constructor
		super();

		// Creating the panels and setting the layout
		jpButtons = new JPanel();
		jpTextFields = new JPanel();
		jpButtons.setLayout(new GridLayout(centerRows, centerCols));
		jpTextFields.setLayout(new GridLayout(NorthRows, NorthCols));

		// Setting 'this' layout and preferred size
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(width, height));

		// Adding the elements to the panels
		this.add(jpTextFields, BorderLayout.NORTH);
		this.add(jpButtons, BorderLayout.CENTER);

		// Creating an array of text fields and assigning their titles
		textFields = new JTextField[textFieldTitles.length];
		for (int i = 0; i < textFields.length; i++) {
			textFields[i] = new JTextField(textFieldTitles[i]);
			if (i > 2) {
				textFields[i].setEditable(false);
			}
			jpTextFields.add(textFields[i]);
		}

		// Creating an array of buttons and assigning their titles
		buttons = new JButton[buttonTitles.length];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonTitles[i]);
			buttons[i].addActionListener(this);
			jpButtons.add(buttons[i]);
		}
	}

	// Action Listener Method
	public void actionPerformed(ActionEvent e) {
		// List of Roman Objects
		r1 = new Roman();
		r2 = new Roman();
		r3 = new Roman();

		// What happens with the user presses CE button
		if (e.getActionCommand().equals("CE")) {
			for (int x = 0; x < textFields.length; x++) {
				textFields[x].setText(textFieldTitles[x]);
			}
			firstInt = 0;
			secondInt = 0;
			resultInt = 0;
			isOperatorPressed = false;
			isFirstDone = false;
			textFields[0].setText(textFields[0].getText());
		} else if (e.getActionCommand().equals("*")) {
			// What happens when * is pressed
			operator = e.getActionCommand().charAt(0);
			isOperatorPressed = true;
		} else if (e.getActionCommand().equals("+")) {
			// What happens when + is pressed
			operator = e.getActionCommand().charAt(0);
			isOperatorPressed = true;
		} else if (e.getActionCommand().equals("-")) {
			// What happens when - is pressed
			operator = e.getActionCommand().charAt(0);
			isOperatorPressed = true;
		} else if (e.getActionCommand().equals("/")) {
			// What happens when - is pressed
			operator = e.getActionCommand().charAt(0);
			isOperatorPressed = true;
		} else if (e.getActionCommand().equals("%")) {
			// What happens when % is pressed
			operator = e.getActionCommand().charAt(0);
			isOperatorPressed = true;
		} else if (e.getActionCommand().equals("=")) {
			// What happens when = is pressed
			r1.setRoman(textFields[0].getText());
			r2.setRoman(textFields[2].getText());

			firstInt = r1.convertToInt();
			secondInt = r2.convertToInt();
			textFields[1].setText("" + firstInt);
			textFields[3].setText("" + secondInt);

			switch (operator) {
			case '+':
				resultInt = firstInt + secondInt;
				break;
			case '-':
				resultInt = firstInt - secondInt;
				break;
			case '*':
				resultInt = firstInt * secondInt;
				break;
			case '/':
				resultInt = firstInt / secondInt;
				break;
			case '%':
				resultInt = firstInt % secondInt;
				break;
			}

			r3.setNumber(resultInt);
			resultRoman = r3.convertToRoman();
			textFields[4].setText(resultRoman);
			textFields[5].setText("" + resultInt);
			isOperatorPressed = false;
		} else {
			if (isOperatorPressed) {
				// When operator is pressed, moves on to next textField
				if (textFields[2].getText().equals(textFieldTitles[2])) {
					textFields[2].setText("");
				}
				textFields[2].setText(textFields[2].getText() + e.getActionCommand());
				isOperatorPressed = false;
				isFirstDone = true;
			} else if (isFirstDone) {
				// Boolean to determine which text box to be in
				if (textFields[2].getText().equals(textFieldTitles[2])) {
					textFields[2].setText("");
				}
				textFields[2].setText(textFields[2].getText() + e.getActionCommand());
			} else {
				// Checking if title is there, and if it is.. change it to
				// buttons pressed
				if (textFields[0].getText().equals(textFieldTitles[0])) {
					textFields[0].setText("");
				}
				textFields[0].setText(textFields[0].getText() + e.getActionCommand());
			}
		}
	}
}
