package com.ssafy.java.day1030;

import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output;
    static StringTokenizer tokens;
    static int T, Answer;
    static int[] Cost;
    static int[] Plan;
    static int[] Pay;
    
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(input.readLine());
        
        for(int t=1; t<=T; t++) {
            Cost = new int[4];
            Plan = new int[12];
            Pay = new int[12];
            
            tokens = new StringTokenizer(input.readLine());
            for(int i=0; i<4; i++) {
                Cost[i] = Integer.parseInt(tokens.nextToken());
            }
            tokens = new StringTokenizer(input.readLine());
            for(int i=0; i<12; i++) {
                Plan[i] = Integer.parseInt(tokens.nextToken());
            }
            
            d2m();
            
            System.out.println(Arrays.toString(Cost));
            System.out.println(Arrays.toString(Plan));
            
            //output.append("#").append(t).append(" ");
            //System.out.println(output);
        }
    }
    static void d2m() {
        for(int i=0; i<12; i++) {
            Pay[i] = Math.min(Plan[i] * Cost[0], Cost[1]);
        }
    }
    static void m2m3() {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            for(int i=tmp[0]; i<12; i++) {
                
            }
        }
    }
    static int m2y() {
        int s = 0;
        for(int i=0; i<12; i++) {
            s += Pay[i];
        }
        return Math.min(s, Cost[3]);
    }
}
