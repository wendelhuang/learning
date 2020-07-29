package com.sklink.learning.leetcode.lcp13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	int[] dx = {1, -1, 0, 0};
	int[] dy = {0, 0, 1, -1};
	int n, m;
	
	public int minimalSteps(String[] maze) {
		n = maze.length;
		m =  maze[0].length();
		
		List<int[]> buttons = new ArrayList<>();
		List<int[]> stones = new ArrayList<>();
		
		int sx = -1, sy = -1, tx = -1, ty = -1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if (maze[i].charAt(j) == 'M') {
					buttons.add(new int[] {i, j});
				}else if (maze[i].charAt(j) == 'O') {
					stones.add(new int[] {i, j});
				}else if (maze[i].charAt(j) == 'S') {
					sx = i;
					sy = j;
				}else if (maze[i].charAt(j) == 'T') {
					tx = i;
					ty = j;
				}
			}
		}
		
		int nb = buttons.size();
		int ns = stones.size();
		int [][] startDist = bfs(sx, sy, maze);
		
		if (nb == 0) {
			return startDist[tx][ty];
		}
		int[][] dist = new int[nb][nb+2];
		for(int i = 0; i < nb; i++) {
			Arrays.fill(dist[i], -1);
		}
		int[][][] dd = new int[nb][][];
		for(int i = 0; i < nb; i++) {
			int[][] d = bfs(buttons.get(i)[0], buttons.get(i)[1], maze);
			dd[i] = d;
			dist[i][nb+1] = d[tx][ty];
		}
		for(int i = 0; i < nb; i++) {
			int tmp = -1;
			for(int k = 0; k < ns; k++) {
				int midX = stones.get(k)[0];
				int midY = stones.get(k)[1];
				if (dd[i][midX][midY] != -1 && startDist[midX][midY] != -1) {
					if (tmp == -1 || tmp > dd[i][midX][midY] + startDist[midX][midY]) {
						tmp = dd[i][midX][midY] + startDist[midX][midY];
					}
				}
			}
			dist[i][nb] = tmp;
			
			for(int j = i+1; j < nb; j++) {
				int mn = -1;
				for(int k = 0; k < ns; k++) {
					int midX = stones.get(k)[0];
					int midY = stones.get(k)[1];
					if (dd[i][midX][midY] != -1 && dd[j][midX][midY] != -1) {
						if (mn == -1 || mn > dd[i][midX][midY] + dd[j][midX][midY]) {
							mn = dd[i][midX][midY] + dd[j][midX][midY];
						}
					}
				}
				dist[i][j] = mn;
				dist[j][i] = mn;
			}
		}
		
		for(int i = 0; i < nb; i++) {
			if (dist[i][nb] == -1 || dist[i][nb+1] == -1) {
				return -1;
			}
		}
		
		int[][] dp = new int[1 << nb][nb];
		for(int i = 0; i < 1<<nb; i++) {
			Arrays.fill(dp[i], -1);
		}
		for(int i = 0; i < nb; i++) {
			dp[1<<i][i] = dist[i][nb];
		}
		
		for(int mask = 0; mask < (1<<nb); mask++) {
			for(int i = 0; i < nb; i++) {
				if ((mask&(1<<i)) != 0) {
					for(int j = 0; j < nb; j++) {
						if ((mask & (1<<j)) == 0) {
							int next = mask | (1<<j);
							if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + dist[i][j]) {
								dp[next][j] = dp[mask][i] + dist[i][j];
							}
						}
					}
				}
			}
		}
		
		int ret = -1;
		for(int i = 0; i < nb; i++) {
			if (ret == -1 || ret > dp[(1<<nb)-1][i] + dist[i][nb+1]) {
				ret = dp[(1<<nb)-1][i] + dist[i][nb+1];
			}
		}
		return ret;
    }
	
	public int[][] bfs(int x, int y, String[] maze) {
		int[][] ret = new int[n][m];
		for(int i = 0; i < n; i++) {
			Arrays.fill(ret[i], -1);
		}
		ret[x][y] = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			int cx = p[0];
			int cy = p[1];
			for(int k = 0; k < 4; k++) {
				int rx = cx + dx[k];
				int ry = cy + dy[k];
				if (inBound(rx, ry) && maze[rx].charAt(ry) != '#' && ret[rx][ry] == -1) {
					ret[rx][ry] = ret[cx][cy] + 1;
					queue.offer(new int[] {rx, ry});
				}
			}
		}
		return ret;
	}
	
	public boolean inBound(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
	public static void main(String[] args) {
		String[] maze = new String[] {"S#O", "M..", "M.T"};
		System.out.println(new Solution().minimalSteps(maze));
	}
}
