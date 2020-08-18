package com.ssafy.java.day0817;

import java.io.*;
import java.util.*;

public class Main {
	static int N, Answer = 0;
	static int[] P, S, Tmp, Origin;
	static BufferedReader input;
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception {
		input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		// 초기화
		P = new int[N];
		S = new int[N];
		Tmp = new int[N];
		boolean chk;
		
		
		tokens = new StringTokenizer(input.readLine());
		for (int n=0; n<N; n++) {
			P[n] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		for (int n=0; n<N; n++) {
			S[n] = Integer.parseInt(tokens.nextToken());
		}
		
		Origin = P.clone();
		
		while (!chked()) {
            boolean c = true;
			
			for(int i=0; i<N; i++) {
				Tmp[S[i]] = P[i];
			}
			
			P = Tmp.clone();
			Answer++;
			
			for (int i = 0; i < N; i++) {
			    if (Origin[i] != P[i]) {
                    c = false;
				    break;
			    }
		    }
            if(c) {
                Answer = -1;
                break;
            }
		    
		}
		System.out.println(Answer);

	}
	static boolean chked() {
		for(int i=0; i<N; i++) {
			if(P[i] != i%3) {
				return false;
			}
		}
		return true;
	}
}

