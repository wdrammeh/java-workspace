package sololearn;

public class Word {
	private int length, numberOfSpaces, numberOfUpperCases, numberOfLowerCases, numberOfWholeNumbers;
	private String value, upperCaseLetters, lowerCaseLetters, wholeNumbers;
	
	public static void main(String[] args) {
		final Word myName = new Word("Muhammed W Drammeh 20");

		System.out.println(myName);
		System.out.println("Length: "+myName.getLength());
		System.out.println("How many lowercases? "+myName.getNumberOfLowercases());
		System.out.println("How many uppercases? "+myName.getNumberofUppercases());
		System.out.println("Number of whitespaces present: "+myName.getNumberOfSpaces());
		System.out.println("Constrained: "+Word.ridOfSpaces(myName.getValue()));
		System.out.println("Length of constrained: "+(Word.ridOfSpaces(myName.getValue()).length()));
		System.out.println("Whole numbers/digits present: "+myName.getNumberOfWholeNumbers());
		System.out.println("Uppercases: "+myName.getUpperCaseLetters());
		System.out.println("Lowercases: "+myName.getLowerCaseLetters());
		System.out.println("Digits present: "+myName.getWholeNumbers());
	}
	

	public Word() {
		//All return functions will return the default of their respective returns types
	}
	
	public Word(String value) {
		this.value = value;
		this.setLength(value.length());
		this.setNumberLowercases(howManyLowerCases(value));
		this.setNumberOfUppercases((howManyUpperCases(value)));
		this.setNumberOfSpaces(howManyWhiteSpaces(value));
		this.setNumberOfWholeNumbers(howManyWholeNumbers(value));
		this.setUpperCases(onlyUpperCases(value));
		this.setLowerCases(onlyLowerCases(value));
		this.setWholeNumbers(onlyWholeNumbers(value));
		
	}
	

	public static int howManyUpperCases(String string) {
		int counter = 0;
		
		for (int i = 0; i < string.length(); i++) {
			counter += Character.isUpperCase(string.charAt(i)) ? 1 : 0;
		}
		
		return counter;
	}
	
	public static int howManyLowerCases(String string) {
		int counter = 0;
		
		for (int i = 0; i < string.length(); i++) {
			counter += Character.isLowerCase(string.charAt(i)) ? 1 : 0;
		}
		return counter;
	}
	
	public static int howManyWhiteSpaces(String string) {
		int counter = 0;
		
		for (int i = 0; i < string.length(); i++) {
			counter += Character.isUpperCase(string.charAt(i)) ? 1 : 0;
		}
		return counter;
	}
	
	public static String ridOfSpaces(String string) {
		return string.replace(" ", "");
	}
	
	public static int howManyWholeNumbers(String string) {
		int counter = 0;
		
		for (int i = 0; i < string.length(); i++) {

			counter += Character.isDigit(string.charAt(i)) ? 1 : 0;
		}
		return counter;
	}
	
	public static String onlyUpperCases(String string) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < string.length(); i++) {
			builder.append(Character.isUpperCase(string.charAt(i)) ? string.charAt(i) : "");
		}
		return builder.toString();
	}
	
	public static String onlyLowerCases(String string) {
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < string.length(); i++) {

			builder.append(Character.isLowerCase(string.charAt(i)) ? string.charAt(i) : "");
		}
		return builder.toString();
	}
	
	public static String onlyWholeNumbers(String string) {
		StringBuilder build = new StringBuilder();
		
		for (int i = 0; i < string.length(); i++) {
			build.append(Character.isDigit(string.charAt(i)) ? string.charAt(i) : "");
		}

		return build.toString();
	}

	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getNumberOfSpaces() {
		return numberOfSpaces;
	}

	public void setNumberOfSpaces(int spaces) {
		this.numberOfSpaces = spaces;
	}

	public int getNumberofUppercases() {
		return numberOfUpperCases;
	}

	public void setNumberOfUppercases(int uppercases) {
		this.numberOfUpperCases = uppercases;
	}

	public int getNumberOfLowercases() {
		return numberOfLowerCases;
	}

	public void setNumberLowercases(int lowercases) {
		this.numberOfLowerCases = lowercases;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
	public int getNumberOfWholeNumbers() {
		return numberOfWholeNumbers;
	}

	public void setNumberOfWholeNumbers(int numberOfWholeNumbers) {
		this.numberOfWholeNumbers = numberOfWholeNumbers;
	}

	public String getUpperCaseLetters() {
		return upperCaseLetters;
	}

	public void setUpperCases(String upperCases) {
		this.upperCaseLetters = upperCases;
	}

	public String getLowerCaseLetters() {
		return lowerCaseLetters;
	}
	
	public void setLowerCases(String lowerCases) {
		this.lowerCaseLetters = lowerCases;
	}

	public String getWholeNumbers() {
		return wholeNumbers;
	}

	public void setWholeNumbers(String wholeNumbers) {
		this.wholeNumbers = wholeNumbers;
	}


}
