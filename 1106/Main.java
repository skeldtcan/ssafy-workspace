package com.ssafy.java.day1106;

import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, Answer=0;
    static int[][] Dragon;
    static int[][] Map = new int[101][101];
    static int[][] Dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(input.readLine());
        Dragon = new int[N][4];
        
        for(int n=0; n<N; n++) {
            tokens = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(tokens.nextToken());
            int y = Integer.parseInt(tokens.nextToken());
            int d = Integer.parseInt(tokens.nextToken());
            int g = Integer.parseInt(tokens.nextToken());
            
            paint(x, y, d, g);
        }
        cal();
        System.out.println(Answer);
    }
    static void paint(int x, int y, int d, int g) {
        Map[y][x] = 1;
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(d);
        
        for(int i=1; i<=g; i++) {
            int size = list.size();
            
            for(int j=size-1; j>=0; j--) {
                list.add((list.get(j)+1)%4);
            }
        }
        for(int i=0; i<list.size(); i++) {
            x += Dirs[list.get(i)][1];
            y += Dirs[list.get(i)][0];
            Map[y][x] = 1;
        }
    }
    static void cal() {
        for(int y=0; y<100; y++) {
            for(int x=0; x<100; x++) {
                if(Map[y][x] == 1 && Map[y][x + 1] == 1 && Map[y + 1][x] == 1 && Map[y + 1][x + 1] == 1)
                Answer++;
            }
        }
    }
}
