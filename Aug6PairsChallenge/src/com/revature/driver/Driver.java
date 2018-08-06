package com.revature.driver;

import com.revature.fileIO.DataSet;
import com.revature.fileIO.ReadInputs;
import com.revature.traversal.BFS;

public class Driver {
	public static void main(String[] args) {
		DataSet dataSet = ReadInputs.readInputs("test_data0");
		System.out.println(dataSet);
		
		BFS.bfs(dataSet.start, dataSet.end, dataSet.bank);
		
		//System.out.println(BFS.getNeighbors(dataSet.start, dataSet.bank,0));
		
		
	}

}
