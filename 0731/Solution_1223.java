package com.ssafy.java.day13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static int[] start = new int[2]; 
    static int T, N;
    static BufferedReader bf;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.setIn(new FileInputStream("input.txt"));
        bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        T = 10;
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(bf.readLine());
            char[] sub = new char[N];
            int idx = 0;
            String ops;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            ops = st.nextToken();
            
            for (int n=0; n<N; n++)
                sub[n] = ops.charAt(n);
            int r = 0;
            while (r < N) {
                if(r%2 == 0) {  //피연산자면
                    stack.add((int)(sub[r]-'0'));
                    //System.out.println(stack.peek());
                } else {    //연산자면
                    if (sub[r] == '*') {
                        stack.add(stack.pop()*(int)(sub[++r]-'0'));
                    }
                }
                r++;
            }
            int sum = 0;
            while(!stack.isEmpty())
                sum += stack.pop();
            System.out.println("#" + t + " " + sum);
        }
    }
}
