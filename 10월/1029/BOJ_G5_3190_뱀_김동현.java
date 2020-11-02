package com.ssafy.java.day1029;

import java.io.*;
import java.util.*;

public class BOJ_G5_3190_뱀_김동현 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static int N, K, L, Answer=0, D=0;
	static int[][] Map;
	static Queue<Order> orders = new LinkedList<>();
	static List<Pos> s = new LinkedList<>();
	static int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static boolean end = false;

	public static void main(String[] args) throws Exception{
		input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		K = Integer.parseInt(input.readLine());
		
		Map = new int[N][N];
		
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			Map[r-1][c-1] = 1;
		}
		
		L = Integer.parseInt(input.readLine());
		for(int l=0; l<L; l++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			char c = tokens.nextToken().charAt(0);
			orders.add(new Order(x,c));
		}
		
		s.add(new Pos(0,0));
		Map[0][0] = 2;
		
		loop: while(!orders.isEmpty()) {
			Order o = orders.poll();
			int time = o.x - Answer;
			for(int i=0; i<time; i++) {					// 이동
				Answer++;
				int headR = s.get(s.size()-1).r;		// 이전 머리 위치
				int headC = s.get(s.size()-1).c;
				headR += dirs[D][0];					// 머리 위치 이동
				headC += dirs[D][1];
				if(isIn(headR, headC)) {				// 밖으로 안벗어났으면
					s.add(new Pos(headR, headC));		// 머리 위치 추가
					if(Map[headR][headC] == 0) {		// 사과가 없으면
						Pos tail = s.remove(0);			// 꼬리 위치 제거
						Map[tail.r][tail.c]= 0;			// 꼬리 제거
					}
					if(Map[headR][headC] == 2) {		// 몸을 물었으면 종료
						end = true;
						break loop;
					}
					else {
						Map[headR][headC] = 2;
					}
				}
				else {									// 밖으로 벗어나면 종료
					end = true;
					break loop;
				}
			}
			D = rotate(o.c);							// 방향 전환
		}// end while
		while(!end) {									// 남은거 진행
			Answer++;
			int headR = s.get(s.size()-1).r;			// 이전 머리 위치
			int headC = s.get(s.size()-1).c;
			headR += dirs[D][0];						// 머리 위치 이동
			headC += dirs[D][1];
			if(isIn(headR, headC)) {					// 밖으로 안벗어났으면
				s.add(new Pos(headR, headC));			// 머리 위치 추가
				if(Map[headR][headC] == 0) {			// 사과가 없으면
					Pos tail = s.remove(0);				// 꼬리 위치 제거
					Map[tail.r][tail.c]= 0;				// 꼬리 제거
				}
				if(Map[headR][headC] == 2) {			// 몸을 물었으면 종료
					break;
				}
				else {
					Map[headR][headC] = 2;
				}
			}
			else {										// 밖으로 벗어나면 종료
				break;
			}
		}
		
		
		System.out.println(Answer);
	}// end main
	static class Pos{
		int r, c;
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	static class Order{
		int x;
		char c;
		public Order(int x, char c) {
			super();
			this.x = x;
			this.c = c;
		}
	}
	
	static int rotate(char c) {
		if(c == 'L')
			return (((D-1)%4 + 4)%4);
		else
			return (D+1)%4; 
	}
}// end Main
