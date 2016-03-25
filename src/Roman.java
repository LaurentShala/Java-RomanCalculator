
public class Roman {
	// Instance Variables
	private  String romanNumeral;
	private  int number;
	
	// Default Constructor
	public Roman(){
		romanNumeral = "";
		number = 0;
	}
	
	// Setters
	public  void setRoman(String rn) { romanNumeral = rn.toUpperCase(); }
	public void setNumber (int n) { number = n; };
	
	// Getters
	public  String getRoman() { return romanNumeral; }
	
	// Methods
	// Converts a number to Roman numerals
	public String convertToRoman() {
		for (int x = 0; x <= number; x++){
			if (number - 1000 >= 0){
				number -= 1000;
				romanNumeral += "M";
			}else if (number - 500 >= 0){
				number -= 500;
				romanNumeral += "D";
			}else if (number - 100 >= 0){
				number -= 100;
				romanNumeral += "C";
			} else if (number - 50 >= 0){
				number -= 50;
				romanNumeral += "L";
			}else if (number - 10 >= 0){
				number -= 10;
				romanNumeral += "X";
			}else if (number - 5 >= 0){
				number -= 5;
				romanNumeral += "V";
			}else if (number - 1 >= 0){
				number -= 1;
				romanNumeral += "I";
			}
		}
		return romanNumeral;
	}
	
	// Converts the Roman numerals to an int
	public  int convertToInt() {
		for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
	        char toInt = romanNumeral.charAt(x);
	        switch (toInt) {
	            case 'M': number += 1000; break;
	            case 'D': number += 500; break;
	            case 'C': number +=100; break;
	            case 'L': number += 50; break;
	            case 'X': number += 10; break;
	            case 'V': number += 5; break;
	            case 'I': number += 1; break;
	            default: System.out.println("ERROR");
	        }
	    }
		return number;
	}
	
	// Displays Roman Numerals
	public void displayRoman() {
		System.out.println(romanNumeral);
	}
}
