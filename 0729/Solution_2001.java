package com.ssafy.java.day11;

import java.util.Scanner;

public class Solution {
    static int N, M, T, answer;
    
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    T = sc.nextInt();
	    
	    for(int t=1; t<=T; t++) {
	        N = sc.nextInt();
	        M = sc.nextInt();
	        int[][] map = new int[N][N];
	        
	        
	        for(int i=0; i<N; i++) {
	            for(int j=0; j<N; j++) {
	                map[i][j] = sc.nextInt();
	            }
	        }
	        answer = 0;
	        for(int i=0; i<N-M+1; i++) {
	            for(int j=0; j<N-M+1; j++) {
	                int sum = 0;
	                for(int l=i; l<M+i; l++) {
	                   for(int m=j; m<M+j; m++) {
	                       sum += map[l][m];
	                   }
	                }
	                if (sum > answer)
	                    answer = sum;
	            }
	        }
	        System.out.printf("#%d %d\n",t , answer);
	        
	    }
        
	}
}
