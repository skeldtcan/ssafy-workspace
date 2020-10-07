package com.ssafy.java.day0922;
import java.io.*;
import java.util.*;

public class Main_2193_이친수 {
	static BufferedReader input;
	static StringTokenizer tokens;
    static int N;
    static long Answer=1;
    
	public static void main(String[] args) throws Exception{
		input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
        
		if(N==1) {
			System.out.println(Answer);
		}
		else if(N==2) {
			
			System.out.println(Answer);
		}
		else {
			long a=1;
			long b=1;
			Answer = 1;
			for(int i=3; i<=N; i++) {
				Answer += a;
				a=b;
				b=Answer;
			}
			System.out.println(Answer);
		}
        
	}
}