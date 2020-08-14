package com.ssafy.java.day0814.work4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1024_수열의_합 {
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int N, L;
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        input = new BufferedReader(new InputStreamReader(System.in));
        tokens = new StringTokenizer(input.readLine());
        
        N = Integer.parseInt(tokens.nextToken());
        L = Integer.parseInt(tokens.nextToken());
        
        int l = L;
        while(l <= 100) {
            int start = N/l - (l-1)/2;
            if (start < 0)
                break;
            if (N == (start*2 + l -1)*l/2) {
                for(int i=start; i < start+l; i++)
                    output.append(i).append(" ");
                break;
            }
            l++;
        }
        if (output.length() == 0)
            output.append(-1);
        
        System.out.println(output);
    }
}