package com.ssafy.java.day0827;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static int R, C, Cnt = 0, Answer = 0;
	static BufferedReader input;
	static StringTokenizer tokens;
	static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static char[][] map;
	static boolean[] visit = new boolean[26];


	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		input = new BufferedReader(new InputStreamReader(System.in));
		tokens = new StringTokenizer(input.readLine());

		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
		}

		
		find(0, 0);
		System.out.println(Answer);
	}

	static void find(int r, int c) {
		int idx = map[r][c];
		visit[idx - 'A'] = true;
		Cnt++;
		Answer = Math.max(Answer, Cnt);
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			if (isIn(nr, nc) && !visit[map[nr][nc] - 'A']) {
				find(nr, nc);
			}
		}
		visit[idx - 'A'] = false;
		Cnt--;
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}