package functionality;

import java.util.Scanner;
import java.util.ArrayList;
import functionality.Calculator;

public class Driver {

	public static void main(String[] args) {
		
		Scanner readInput = new Scanner(System.in);
		
		String operation = "";
		String typeOfNumber = "";
		boolean isNumericInput;
		
		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		ArrayList<Short> shortArray = new ArrayList<Short>();
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		ArrayList<Long> longArray = new ArrayList<Long>();
		ArrayList<Float> floatArray = new ArrayList<Float>();
		ArrayList<Double> doubleArray = new ArrayList<Double>();
		
		System.out.println("Please enter, in the following order, the operation, "
							+ "the type of number, and the operands without any commas in between them"
							+ " and no more than 2 numbers.");
		
		String userInput = readInput.nextLine();
		
		String[] userInputWords = userInput.split(" ");
		
		operation = userInputWords[0];
		isNumericInput = isNumeric(operation);
		if(isNumericInput) {
			throw new IllegalArgumentException("Incorrect operation input.");
		}
		
		typeOfNumber = userInputWords[1];
		isNumericInput = isNumeric(typeOfNumber);
		if(isNumericInput) {
			throw new IllegalArgumentException("Incorrect number type input.");
		}
		
		operation.toLowerCase();
		typeOfNumber.toLowerCase();
		
		if(typeOfNumber.equals("byte")) {
			for(int i = 2; i < userInputWords.length; i++) {
				Integer temp = Integer.parseInt(userInputWords[i]);
				byteArray.add(temp.byteValue());
			}
			Calculator newCalc = new Calculator(); 
			newCalc.performOperationByte(operation, byteArray);
		}
		
		else if(typeOfNumber.equals("short")) {
			for(int i = 2; i < userInputWords.length; i++) {
				Integer temp = Integer.parseInt(userInputWords[i]);
				shortArray.add(temp.shortValue());
			}
			Calculator newCalc = new Calculator(); 
			newCalc.performOperationShort(operation, shortArray);
		}
		
		else if(typeOfNumber.equals("int")) {
			for(int i = 2; i < userInputWords.length; i++) {
				Integer temp = Integer.parseInt(userInputWords[i]);
				intArray.add(temp.intValue());
			}
			Calculator newCalc = new Calculator(); 
			newCalc.performOperationInt(operation, intArray);
		}
		
		else if(typeOfNumber.equals("long")) {
			for(int i = 2; i < userInputWords.length; i++) {
				Integer temp = Integer.parseInt(userInputWords[i]);
				longArray.add(temp.longValue());
			}
			Calculator newCalc = new Calculator(); 
			newCalc.performOperationLong(operation, longArray);
		}
		
		else if(typeOfNumber.equals("float")) {
			for(int i = 2; i < userInputWords.length; i++) {
				Double temp = Double.parseDouble(userInputWords[i]);
				floatArray.add(temp.floatValue());
			}
			Calculator newCalc = new Calculator(); 
			newCalc.performOperationFloat(operation,floatArray);
		}
		
		else if(typeOfNumber.equals("double")) {
			for(int i = 2; i < userInputWords.length; i++) {
				Double temp = Double.parseDouble(userInputWords[i]);
				doubleArray.add(temp.doubleValue());
			}
			Calculator newCalc = new Calculator(); 
			newCalc.performOperationDouble(operation, doubleArray);
		}
		
	}

	public static boolean isNumeric(String userInputString) {
		boolean returnAnswer = false;
		boolean isNumericInputF;
		
		isNumericInputF = userInputString.chars().allMatch( Character::isDigit );
		
		if(isNumericInputF) {
			returnAnswer = true;
		}
		
		return returnAnswer;
	}

	
}
