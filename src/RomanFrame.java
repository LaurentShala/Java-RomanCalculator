import javax.swing.JFrame;

public class RomanFrame extends JFrame{
	// Instance Variables
	private RomanCalculator cal = null;
	
	// Default Constructor
	public RomanFrame(){
		super();
		cal = new RomanCalculator();

		// Setting title, making it visible, and making it close correctly
		this.add(cal);
		this.setTitle("Roman Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// .Pack makes the frame to size
		this.pack();
		this.setVisible(true);
	}
}

