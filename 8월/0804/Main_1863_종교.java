package com.ssafy.java.day15;

import java.io.*;
import java.util.*;

public class Main_1863_종교 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    
    static int N;
    static int M;
    static int[] repres;
    
	public static void main(String[] args) throws Exception {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        HashSet<Integer> set = new HashSet<Integer>();
        
        repres = new int[N + 1];
        for (int i = 1; i < repres.length; i++)
        	repres[i] = i;
        	
        for (int m = 0; m < M; m++) {
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            union(a, b);
        }
        for(int i=1; i<N+1; i++) {
        	repres[i] = findSet(i);
        }
        for(int a: repres)
        	set.add(a);
        System.out.println(set.size()-1);
            
	}
	static void union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if (a < b) {
            repres[b] = a;
        } else {
            repres[a] = b;
        }
    }
	
    static int findSet(int v) {
        if (repres[v] == v) {
            return v;
        }
        else {
            return repres[v] = findSet(repres[v]);
        }
    }
    
}
