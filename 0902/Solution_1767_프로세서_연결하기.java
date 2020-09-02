package com.ssafy.java.day0902;

import java.io.*;
import java.util.*;

public class Solution_1767_프로세서_연결하기 {
	static int coreCnt, N, coreMax, lineMin;
	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output;
	static int[][] map;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<Processor> core;
 
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("input.txt"));
        input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
 
        for (int t = 1; t <= T; t++) {
        	output = new StringBuilder();
            N = Integer.parseInt(input.readLine());
            map = new int[N][N];
            core = new ArrayList<>();
            coreCnt = 0;
            coreMax = Integer.MIN_VALUE;
            lineMin = Integer.MAX_VALUE;
            for (int r = 0; r < N; r++) {
                tokens = new StringTokenizer(input.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(tokens.nextToken());
                    if (map[r][c] == 1) {
                        if (r == 0 || r == N - 1 || c == 0 || c == N - 1)
                            continue;
 
                        coreCnt++;
                        core.add(new Processor(r, c));
                    }
                }
            } 
            setCore(0, 0, 0);
            output.append("#").append(t).append(" ").append(lineMin);
            System.out.println(output);
        } 
    }
 
    public static void setCore(int coreIdx, int sucCore, int lineLen) {
        if (coreIdx == coreCnt) {
            if (coreMax < sucCore) {
                coreMax = sucCore;
                lineMin = lineLen;
            } else if (coreMax == sucCore) {
                lineMin = lineMin > lineLen ? lineLen : lineMin;
            }
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            int ret = setLine(coreIdx, i);
            if (ret == -1) { 
                setCore(coreIdx + 1, sucCore, lineLen);
            } else { 
                setCore(coreIdx + 1, sucCore + 1, lineLen + ret);
                
                int nr = core.get(coreIdx).r;
                int nc = core.get(coreIdx).c;
                while (true) {
                    nr += dirs[i][0];
                    nc += dirs[i][1];
                    if (nc < 0 || nc > N - 1 || nr < 0 || nr > N - 1)
                        break; 
                    map[nc][nr] = 0; 
                }
 
            }
        }
    }
 
    public static int setLine(int coreIdx, int dir) {
        ArrayList<Processor> list = new ArrayList<>();
        Processor cp = core.get(coreIdx);
        int nr = cp.r;
        int nc = cp.c;
        int lineLen = 0;
        while (true) {
            nr += dirs[dir][0];
            nc += dirs[dir][1];
            if (nc < 0 || nc > N - 1 || nr < 0 || nr > N - 1)
                break; 
            if (map[nc][nr] != 0)
                return -1; 
            list.add(new Processor(nc, nr)); 
 
            lineLen++;
        }
 
        
        for (Processor p : list) {
            map[p.c][p.r] = 2;
        } 
 
        return lineLen;
    } 
    
    public static class Processor {
    	int r;
        int c;
 
        public Processor(int y, int x) {
            super();
            this.c = y;
            this.r = x;
        }
    }
}
