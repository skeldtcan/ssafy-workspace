package com.ssafy.java.day1102;

import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output;
    static StringTokenizer tokens;
    static int T, C, R, B, Answer, Clear;
    static int[][] Map;
    static int[][] Dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(input.readLine());
        
        for(int t=1; t<=T; t++) {
            output = new StringBuilder();
            tokens = new StringTokenizer(input.readLine());
            Answer = 0;
            Clear = 0;
            B = Integer.parseInt(tokens.nextToken());
            C = Integer.parseInt(tokens.nextToken());
            R = Integer.parseInt(tokens.nextToken());
            Map = new int[R][C];
            
            for(int r=0; r<R; r++) {
            	tokens = new StringTokenizer(input.readLine());
            	for(int c=0; c<C; c++) {
            		Map[r][c] = Integer.parseInt(tokens.nextToken());
            		if(Map[r][c] != 0)
            			Answer++;
            	}
            }
            dfs(B, 0, Map);
            output.append("#").append(t).append(" ").append(Answer-Clear);
            System.out.println(output);
        }
	}
    static void dfs(int b, int cnt, int[][] map) {
    	if(cnt >= Answer) {
    		Clear = Answer;
    		return;
    	}
    	if(b == 0) {
    		Clear = Math.max(Clear, cnt);
    		return;
    	}
    	for(int c=0; c<C; c++) {					// 한곳씩 구슬 떨궈보기
    		int[][] tmpMap = new int[R][C];			// 새 맵 생성
    		for(int i=0; i<R; i++) {
    			tmpMap[i] = map[i].clone();
    		}
    		
    		for(int r=0; r<R; r++) {				// 구슬이 닿는 곳 찾기
    			if(tmpMap[r][c] == 1) {				// 닿은 벽돌이 1이면
    				tmpMap[r][c] = 0;
    				dfs(b-1, cnt+1, tmpMap);
    				break;
    			}
    			else if(tmpMap[r][c] > 1) {			// 닿은 벽돌이 1보다 크면
    				dfs(b-1, cnt + breakBlock(r, c, tmpMap), tmpMap);	// 제거하고 다음 dfs
    				break;
    			}
    		}
    	}
    }
    // 블럭 깨기
    static int breakBlock(int r, int c, int[][] tmpMap) {
    	int sum = 0;									// 없앤 블럭의 수
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {r, c, tmpMap[r][c]});			// 제거할 블럭 추가
    		while(!q.isEmpty()) {						// 제거할 블럭이 있는 동안
    			int[] removeBlock = q.poll();
    			
    			if(tmpMap[r][c] != 0) {					// 없앨 블럭자리가 0이 아니면 제거
    				tmpMap[r][c] = 0;
    				sum++;
    			}
    			
    			for(int i=0; i<4; i++) {
    				for(int j=1; j<removeBlock[2]; j++) {
    					int nr = removeBlock[0] + Dirs[i][0]*j;
    					int nc = removeBlock[1] + Dirs[i][1]*j;
    					
    					if(isIn(nr, nc)) {
    						if(tmpMap[nr][nc] == 1) {		// 1이면 그냥 제거			
	    						tmpMap[nr][nc] = 0;
	    						sum++;
    						}
    						else if(tmpMap[nr][nc] > 1) {	// 1보다 크면 제거하고 q에 추가
    							q.add(new int[] {nr, nc, tmpMap[nr][nc]});
    							tmpMap[nr][nc] = 0;
	    						sum++;
							}
						}
					}// for - j
				}// for - Dirs
			}// while - q
    	downBlock(tmpMap);		
    	return sum;
    }
    
    // 블럭 하강
    static int[][] downBlock(int[][] map) {
    	for(int c=0; c<C; c++) {
    		int bottom=R-1;
    		for(int r=R-1; r>=0; r--) {
    			if(map[bottom][c] != 0) {
    				bottom--;
    				continue;
    			}
    			else if(map[bottom][c] == 0 && map[r][c] == 0){
    				continue;
    			}
    			else if(map[bottom][c] == 0 && map[r][c] != 0) {
    				map[bottom][c] = map[r][c];
    				map[r][c] = 0;
    				bottom--;
    			}
    		}
    	}
    	return map;
    }
    
    // 맵을 벗어나는지 판단
    static boolean isIn(int r, int c) {
    	return r>=0 && r<R && c>=0 && c<C;
    }
}
