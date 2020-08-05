package com.ssafy.java.day0805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2667_단지번호붙이기 {
    static int N, Group, Cnt, Answer=0;
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int[][] map;
    static int[][] group;
    static int[] row = {-1, 1, 0, 0};
    static int[] col = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        input = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(input.readLine());
        List<Integer> list = new ArrayList<Integer>();
        Group = 1;

        map = new int [N+2][N+2];
        for(int[] a : map)
            Arrays.fill(a, -1);
        group = new int [N+2][N+2];
        for(int r=1; r<=N; r++) {
            String line = (input.readLine());
            for(int c=1; c<=N; c++) {
               map[r][c] = (int)(line.charAt(c-1)-'0'); 
            }
        }
        

        for(int r=1; r<=N; r++) {
            for(int c=1; c<=N; c++) {
               if(map[r][c] == 1 && group[r][c] == 0) {
                   Cnt = 0;
                   findLand(r, c);
                   Group++;
                   list.add(Cnt);
               }
            }
        }
        
        list.sort(null);
        System.out.println(Group-1);
        for(Integer i: list)
            System.out.println(i);
    }
    static void findLand(int r, int c) {
        if (group[r][c] != 0)
            return;
        Cnt++;
        group[r][c] = Group;
        for(int i=0; i<4; i++) {
            int r2 = r+row[i];
            int c2 = c+col[i];
            if(map[r2][c2] == 1 && group[r2][c2] == 0)
                findLand(r2, c2);
        }
    }
    
}
