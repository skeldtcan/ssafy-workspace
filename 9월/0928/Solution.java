package com.ssafy.java.day0928;

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, N, R, mod=1234567891;
	static long[] f;

	public static void main(String[] args) throws Exception {
		input = new BufferedReader(new InputStreamReader(System.in));
		f = new long[1000000+1];
		f[0] = 1;
		for(int i=1; i<1000000+1; i++) {
			f[i] = (f[i-1]*i) % mod;
		}
		
		T = Integer.parseInt(input.readLine());
		for (int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			
			N = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			
			System.out.println(N + ", " + R);
			long top = f[N];
			long bottom = (f[R] * f[N-R]) % mod;
			
			long rebot = bot(bottom, mod-2);
			
			System.out.println("#" + t +" " + (top*rebot)%mod);
			
		}
	}
	static long bot(long n, int p) {
		if(p==0)
			return 1;
		long half = bot(n, p/2);
		
		if(p%2==0)
			return (half*half)%mod;
		else
			return (((half*n)%mod)*half)%mod;
	}
}
