package com.saffy.java.day0807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬_디펜스 {
    static int N, M, D, Answer=0;
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    
    static int[][] map;
    static int[] Castle;
    static Queue<Integer[]> q = new LinkedList<Integer[]>();
    
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("input.txt"));
        input = new BufferedReader(new InputStreamReader(System.in));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());   //행
        M = Integer.parseInt(
                tokens.nextToken());   //열
        D = Integer.parseInt(tokens.nextToken()) - 1;   //사거리
        map = new int[N][M];
        Castle = new int[M];
        for(int i=0; i<M; i++)
            Castle[i] = i;
        
        for(int n=0; n<N; n++) {
            tokens = new StringTokenizer(input.readLine());
            for (int m=0; m<M; m++) {
                map[n][m] = Integer.parseInt(tokens.nextToken());
            }
        }
        
        comb(3, 0, new int[3]);
        System.out.println(Answer);

    }
    
    //궁수 배치 조합
    static void comb(int r, int start, int[] bow) {
        if(r==0) {  //조합 완성
            //System.out.println(Arrays.toString(bow));
            int[][] map2 = new int[N][M];
            for(int n=0; n<N; n++)
                for(int m=0; m<M; m++)
                    map2[n][m] = map[n][m];
            kill(N-1, bow, 0, new Map(map2));
            
        } else {
            
            for(int i=start; i<M; i++) {
                bow[3-r] = Castle[i];
                comb(r-1, i+1, bow);
            }
        }
    }
    
    //거리 측정
    static int distance(int x1, int x2, int y1, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
    
    //죽이는거
    static void kill(int line, int[] bow, int cnt, Map m) {
        if (line==-1) {     //정답이랑 누가 더 큰지 비교
            if (cnt > Answer)
                Answer = cnt;
            return;
        } else {
            for(int i=0; i<3; i++) {    //궁수별로 죽이는 애들 지정
                int delR = 16, delC = 16;
                int minD = 16;
                for(int r=line; line-r<=D && r>=0; r--) {
                    for(int c=0; c<M; c++) {
                        int d = distance(c, bow[i], r, line);
                        if(d > D) {
                            continue;
                        }
                        if(m.getEnemy(r, c) == 1) {
                            if(minD > d) {
                                minD = d;
                                delR = r;
                                delC = c;
                            } else if (minD == d && c < delC) {
                                minD = d;
                                delR = r;
                                delC = c;
                            }
                        }
                    }
                }
                if(delR != 16)
                    q.add(new Integer[] {delR, delC});
            
            }
            while(!q.isEmpty()) {
                int r = q.peek()[0];
                int c = q.peek()[1];
                q.poll();
                if(m.getEnemy(r, c) == 1) {
                    m.setEnemy(r, c);
                    cnt++;
                }
            }
            //System.out.println(line-1 + " " + Arrays.toString(bow) + " " + cnt);
            //System.out.println(m);
            kill(--line, bow, cnt, m);
        }
    }
    
    //조합별 맵 생성
    static class Map{
        int[][] map;

        public Map(int[][] map) {
            super();
            this.map = map;
        }

        public int getEnemy(int r, int c) {
            return map[r][c];
        }
        public void setEnemy(int r, int c) {
            map[r][c] = 0;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for(int[] a: map)
                builder.append(Arrays.toString(a)).append("\n");
            return builder.toString();
        }
    }
}
