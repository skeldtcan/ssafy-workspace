package com.ssafy.java.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2667_단지번호붙이기 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int N;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        Stack<Top> stack = new Stack<Top>();
        for (int i = 0; i < N; i++) {
            int building = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().height <= building) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if(stack.isEmpty())
                output.append("0 ");
            else {
                output.append(stack.peek().idx + 1+ " ");
            }
            stack.push(new Top(building, i));
        }
        System.out.print(output);
    }
    
    static class Top {
        int height;
        int idx;
        
        public Top(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
        
        @Override
        public String toString() {
            return "[" + height + "," + idx + "]";
        }
    }
}