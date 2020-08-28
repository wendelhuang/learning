package com.sklink.learning.leetcode.leetcode657;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public boolean judgeCircle(String moves) {
		if (moves == null || moves.equals("")) {
			return true;
		}
		int[] xy =  new int[] {0, 0};
		Map<Character, Integer> axisMap = new HashMap<Character, Integer>();
		axisMap.put('U', 1);
		axisMap.put('D', 1);
		axisMap.put('L', 0);
		axisMap.put('R', 0);
		Map<Character, Integer> adderMap = new HashMap<Character, Integer>();
		adderMap.put('U', 1);
		adderMap.put('D', -1);
		adderMap.put('L', -1);
		adderMap.put('R', 1);
		
		for(int i = 0; i < moves.length(); i++) {
			Character ch = moves.charAt(i);
			xy[axisMap.get(ch)] += adderMap.get(ch);
		}
		System.out.println(Arrays.toString(xy));
		return xy[0] == 0 && xy[1] == 0;
    }
	
    public static void main(String[] args) {
		System.out.println(new Solution().judgeCircle("RRDD"));
	}
}