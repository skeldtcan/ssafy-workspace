package com.ssafy.java.day1104;

import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output;
    static StringTokenizer tokens;
    static int T, N, M, Answer;
    static Node[] Nodes;
    
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(input.readLine());
        
        for(int t=1; t<=T; t++) {
            Answer = 0;
            output = new StringBuilder();
            N = Integer.parseInt(input.readLine());
            M = Integer.parseInt(input.readLine());
         
            Nodes = new Node[N+1];
            for(int n=1; n<N+1; n++)
                Nodes[n] = new Node(n);
            
            for(int m=0; m<M; m++) {
                tokens = new StringTokenizer(input.readLine());
                int s = Integer.parseInt(tokens.nextToken());
                int d = Integer.parseInt(tokens.nextToken());
                
            }
            
            
            output.append("#").append(t).append(" ").append(Answer);
            System.out.println(output);
        }
    }
    
    static class Node{
        int no, score=0;
        ArrayList<Node> list = null;
        public Node(int no) {
            super();
            this.no = no;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[no=").append(no).append(", score=").append(score)
                    .append(", list=").append(list).append("]");
            return builder.toString();
        }
    }
}
