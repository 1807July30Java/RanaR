package com.revature.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFS {
	
	public static int bfs(String start, String end, Map<String, Boolean> bank){
		
		Queue<FrontierNode> frontier = new LinkedList<FrontierNode>();
		frontier.add(new FrontierNode(start,0));
		//bank.put(start, true);
		
		while(!frontier.isEmpty()) {
			
			
			FrontierNode currNode = frontier.poll();
			String curr = currNode.key;
			int depth = currNode.depth;
			
			if (bank.get(curr)) continue;
			
				
			bank.put(curr,true);
			if (curr.equals(end)) {
				//Return output
				System.out.println(curr + " " + depth);
			}
			
			frontier.addAll(getNeighbors(curr, bank, depth));
			
		}
		
		
		return 0;
		
		
	}
	/**
	 * Finds all the unvisited neighbors of the current node.
	 * 
	 * @param curr
	 * @param bank
	 * @return
	 */
	public static ArrayList<FrontierNode> getNeighbors(String curr, Map<String,Boolean> bank, int depth){
		ArrayList<FrontierNode> neighbors = new ArrayList<FrontierNode>();
		String mutatedDNA = "";
 		Character[] letters = {'a', 'c', 'g', 't'};
		
		for (int  i = 0; i < curr.length(); i++) {
			for(int j = 0; j < letters.length; j++) {
				if(curr.charAt(i) != letters[j]) {
					String possibleNeighbor = curr.substring(0, i)+letters[j]+curr.substring(i+1);
					//Check whether key exists and is not visited
					
					if (bank.containsKey(possibleNeighbor) && !bank.get(possibleNeighbor)) {
						neighbors.add(new FrontierNode(possibleNeighbor,depth+1));
					}
					
				}
			}
		}
		
		return neighbors;
	}

}
