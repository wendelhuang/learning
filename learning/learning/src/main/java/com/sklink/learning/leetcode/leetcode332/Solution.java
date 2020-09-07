package com.sklink.learning.leetcode.leetcode332;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
	List<String> res = new ArrayList<>();
	Map<String, Integer> cityToSeq = new HashMap<>();
	Map<Integer, String> seqToCity = new HashMap<>();
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<Integer, Map<Integer, Integer>> edges = new HashMap<Integer, Map<Integer, Integer>>();
		
		Set<String> citySet = new TreeSet<>(); 
		
		for(List<String> e : tickets) {
			String from = e.get(0);
			String to = e.get(1);
			citySet.add(from);
			citySet.add(to);
		}
		Iterator<String> it = citySet.iterator();
		int seq = 0;
		while(it.hasNext()) {
			String city = it.next();
			cityToSeq.put(city, seq);
			seqToCity.put(seq, city);
			seq++;
		}
		
		for(List<String> e : tickets) {
			int fromIndex = cityToSeq.get(e.get(0));
			int toIndex = cityToSeq.get(e.get(1));
			
			/**
			 * init
			 */
			if (!edges.containsKey(fromIndex)) {
				edges.put(fromIndex, new TreeMap<>());
			}
			if (!edges.containsKey(toIndex)) {
				edges.put(toIndex, new TreeMap<>());
			}
			
			edges.get(fromIndex).put(toIndex, edges.get(fromIndex).getOrDefault(toIndex, 0) + 1);
		}
		
		List<Integer> currentList = new ArrayList<>();
		currentList.add(cityToSeq.get("JFK"));
		dfs(tickets, edges, cityToSeq.get("JFK"), currentList);
		return res;
    }
	
	public void dfs(List<List<String>> tickets, Map<Integer, Map<Integer, Integer>> edges, int current, List<Integer> currentList) {
		//System.out.println(current);
		if (res.size() > 0) {
			return;
		}
		if (currentList.size() == tickets.size() + 1) {
			for(int i = 0; i < currentList.size(); i++) {
				res.add(seqToCity.get(currentList.get(i)));
			}
			return;
		}
		
		Map<Integer, Integer> canGo = edges.get(current);
		for(Integer gotoCity : canGo.keySet()) {
			if (canGo.get(gotoCity) > 0) {
				//System.out.println("cango " + gotoCity);
				currentList.add(gotoCity);
				canGo.put(gotoCity, canGo.get(gotoCity)-1);
				dfs(tickets, edges, gotoCity, currentList);
				canGo.put(gotoCity, canGo.get(gotoCity)+1);
				currentList.remove(currentList.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<List<String>>();
		/*
		tickets.add(Arrays.asList("JFK","SFO"));
		tickets.add(Arrays.asList("JFK","ATL"));
		tickets.add(Arrays.asList("SFO","ATL"));
		tickets.add(Arrays.asList("ATL","JFK"));
		tickets.add(Arrays.asList("ATL","SFO"));
		*/
		
		tickets.add(Arrays.asList("JFK","SFO"));
		tickets.add(Arrays.asList("JFK","ATL"));
		tickets.add(Arrays.asList("SFO","ATL"));
		tickets.add(Arrays.asList("ATL","JFK"));
		tickets.add(Arrays.asList("ATL","SFO"));
		List<String> list = new Solution().findItinerary(tickets);
		
		System.out.println(Arrays.toString(list.toArray()));
	}
}