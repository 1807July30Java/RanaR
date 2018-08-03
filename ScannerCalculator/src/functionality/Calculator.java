package functionality;

import java.util.ArrayList;

public class Calculator {
	
	public static void performOperationByte(String operation, ArrayList<Byte> listOfNumbers) {
		
		byte temp = 0;
	
		if(operation.equals("add")) {
			for(Byte num: listOfNumbers) {
				temp += num;
			}
			System.out.println(temp);
		}
		
		else if(operation.equals("subtract")) {
			for(Byte num: listOfNumbers) {
				if(temp == 0) {
					temp = num;
				}
				else {
					temp -= num;
				}
			}
			System.out.println(temp);
		}
		
		else if(operation.equals("multiply")) {
			for(Byte num: listOfNumbers) {
				if(temp == 0) {
					temp = num;
				}
				else {
					temp *= num;
				}
			}
			System.out.println(temp);
		}
		
		else if(operation.equals("divide")) {
			for(Byte num: listOfNumbers) {
				if(temp == 0) {
					temp = num;
				}
				else {
					temp /= num;
				}
			}
			System.out.println(temp);
		}
		
	}
	
	public static void performOperationShort(String operation, ArrayList<Short> listOfNumbers) {
		
		short temp = 0;
	
		if(operation.equals("add")) {
			for(short num: listOfNumbers) {
				temp += num;
			}
			System.out.println(temp);
		}
		
		else if(operation.equals("subtract")) {
			for(short num: listOfNumbers) {
				if(temp == 0) {
					temp = num;
				}
				else {
					temp -= num;
				}
			}
			System.out.println(temp);
		}
		
		else if(operation.equals("multiply")) {
			for(short num: listOfNumbers) {
				if(temp == 0) {
					temp = num;
				}
				else {
					temp *= num;
				}
			}
			System.out.println(temp);
		}
		
		else if(operation.equals("divide")) {
			for(short num: listOfNumbers) {
				if(temp == 0) {
					temp = num;
				}
				else {
					temp /= num;
				}
			}
			System.out.println(temp);
		}
		
	}

	
	public static void performOperationInt(String operation, ArrayList<Integer> listOfNumbers) {
			
			int temp = 0;
		
			if(operation.equals("add")) {
				for(int num: listOfNumbers) {
					temp += num;
				}
				System.out.println(temp);
			}
			
			else if(operation.equals("subtract")) {
				for(int num: listOfNumbers) {
					if(temp == 0) {
						temp = num;
					}
					else {
						temp -= num;
					}
				}
				System.out.println(temp);
			}
			
			else if(operation.equals("multiply")) {
				for(int num: listOfNumbers) {
					if(temp == 0) {
						temp = num;
					}
					else {
						temp *= num;
					}
				}
				System.out.println(temp);
			}
			
			else if(operation.equals("divide")) {
				for(int num: listOfNumbers) {
					if(temp == 0) {
						temp = num;
					}
					else {
						temp /= num;
					}
				}
				System.out.println(temp);
			}
			
		}

public static void performOperationLong(String operation, ArrayList<Long> listOfNumbers) {
		
		long temp = 0;
	
		if(operation.equals("add")) {
			for(long num: listOfNumbers) {
				temp += num;
			}
			System.out.println(temp);
		}
		
		else if(operation.equals("subtract")) {
			for(long num: listOfNumbers) {
				if(temp == 0) {
					temp = num;
				}
				else {
					temp -= num;
				}
			}
			System.out.println(temp);
		}
		
		else if(operation.equals("multiply")) {
			for(long num: listOfNumbers) {
				if(temp == 0) {
					temp = num;
				}
				else {
					temp *= num;
				}
			}
			System.out.println(temp);
		}
		
		else if(operation.equals("divide")) {
			for(long num: listOfNumbers) {
				if(temp == 0) {
					temp = num;
				}
				else {
					temp /= num;
				}
			}
			System.out.println(temp);
		}
		
	}
	
public static void performOperationFloat(String operation, ArrayList<Float> listOfNumbers) {
	
	float temp = 0;

	if(operation.equals("add")) {
		for(float num: listOfNumbers) {
			temp += num;
		}
		System.out.println(temp);
	}
	
	else if(operation.equals("subtract")) {
		for(float num: listOfNumbers) {
			if(temp == 0) {
				temp = num;
			}
			else {
				temp -= num;
			}
		}
		System.out.println(temp);
	}
	
	else if(operation.equals("multiply")) {
		for(float num: listOfNumbers) {
			if(temp == 0) {
				temp = num;
			}
			else {
				temp *= num;
			}
		}
		System.out.println(temp);
	}
	
	else if(operation.equals("divide")) {
		for(float num: listOfNumbers) {
			if(temp == 0) {
				temp = num;
			}
			else {
				temp /= num;
			}
		}
		System.out.println(temp);
	}
	
}

public static void performOperationDouble(String operation, ArrayList<Double> listOfNumbers) {
	
	double temp = 0;

	if(operation.equals("add")) {
		for(double num: listOfNumbers) {
			temp += num;
		}
		System.out.println(temp);
	}
	
	else if(operation.equals("subtract")) {
		for(double num: listOfNumbers) {
			if(temp == 0) {
				temp = num;
			}
			else {
				temp -= num;
			}
		}
		System.out.println(temp);
	}
	
	else if(operation.equals("multiply")) {
		for(double num: listOfNumbers) {
			if(temp == 0) {
				temp = num;
			}
			else {
				temp *= num;
			}
		}
		System.out.println(temp);
	}
	
	else if(operation.equals("divide")) {
		for(double num: listOfNumbers) {
			if(temp == 0) {
				temp = num;
			}
			else {
				temp /= num;
			}
		}
		System.out.println(temp);
	}
	
}
	
}
