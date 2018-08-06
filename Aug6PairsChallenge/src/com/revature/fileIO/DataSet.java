package com.revature.fileIO;

import java.util.HashMap;
import java.util.Map;

public class DataSet {
	
	public String start;
	public String end;
	public Map<String, Boolean> bank = new HashMap<String, Boolean>();
	
	@Override
	public String toString() {
		return "Start: " + start+" End: "+end; 
		
	}
}
