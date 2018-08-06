package com.revature.fileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadInputs {
	
	
	
	public static DataSet readInputs(String fileName) {
		DataSet dataSet = new DataSet();
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
	        Iterator<String> iter = stream.iterator();
			dataSet.start = iter.next();
			dataSet.end = iter.next();
			dataSet.bank.put(dataSet.start, false);
			dataSet.bank.put(dataSet.end, false);
			while (iter.hasNext()) {
				dataSet.bank.put(iter.next(),false);
				
				
			}
	        //stream.forEach(System.out::println);
	        stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return dataSet;
	}
	
	
	
	
	
}
