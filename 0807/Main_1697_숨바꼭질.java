package com.ssafy.java.day0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int N, K;
	static int visited[] = new int[100001];
	static BufferedReader input;
    static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception{
		input = new BufferedReader(new InputStreamReader(System.in));
        tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		bfs();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(N);
		visited[N] = 1;

		while(!q.isEmpty()) {
			N = q.poll();
			
			if (N==K)
				break;
			
			if(N+1 <= 100000 && visited[N+1] == 0) {
				q.add(N+1);
				visited[N+1] = visited[N]+1;
			}
			if(N-1 >= 0 && visited[N-1] == 0) {
				q.add(N-1);
				visited[N-1] = visited[N]+1;
			}
			if(N*2 <= 100000 && visited[N*2] == 0) {
				q.add(N*2);
				visited[N*2] = visited[N]+1;
			}
		}
		
		System.out.println(visited[K]-1);
	}
}