package com.ssafy.java.day1028;

import java.io.*;
import java.util.*;

public class Solution_4014_활주로건설_김동현 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output;
    static StringTokenizer tokens;
    static int T, N, X, Answer;
    static int[][] Map;
    
    public static void main(String[] args) throws Exception {
        tokens = new StringTokenizer(input.readLine());
        T = Integer.parseInt(tokens.nextToken());
        
        for(int t=1; t<=T; t++) {
            Answer=0;
            output = new StringBuilder();
            tokens = new StringTokenizer(input.readLine());
            N = Integer.parseInt(tokens.nextToken());
            X = Integer.parseInt(tokens.nextToken());
            
            Map = new int[N][N];
            
            for(int r=0; r<N; r++) {
                tokens = new StringTokenizer(input.readLine());
                for(int c=0; c<N; c++) {
                    Map[r][c] = Integer.parseInt(tokens.nextToken());
                }
            }
            
            //가로방향
            for(int r=0; r<N; r++) {
                int d=1;
                int s=Map[r][0];
                
                loop: for(int c=1; c<N; c++) {
                    if(Map[r][c] == s+1) {         //높아질 때
                        if(d >= X) {            //경사로보다 길면
                            s=Map[r][c];
                            d=1;
                        }
                        else                    //경사로보다 짧으면
                            break loop;
                    }
                    else if(Map[r][c] == s-1) {    //낮아질 때
                        for(int nc=c+1; nc<c+X; nc++) {
                            if(!isIn(r, nc) || Map[r][nc] != Map[r][c])  //경사로 충족 못하면
                                break loop;                           
                        }
                        s = Map[r][c]; 
                        c += X-1;
                        d = 0;
                    }
                    else if (Map[r][c] == s){                      //같을 때
                        d++;
                    }
                    else
                        break loop;
                    
                    if(c==N-1)
                        Answer += 1;
                }
            }   // end 가로방향
            
            //세로방향
            for(int c=0; c<N; c++) {
                int d=1;
                int s=Map[0][c];
            
                loop: for(int r=1; r<N; r++) {
                    if(Map[r][c] == s+1) {         //높아질 때
                        if(d >= X) {            //경사로보다 길면
                            s=Map[r][c];
                            d=1;
                        }
                        else                    //경사로보다 짧으면
                            break loop;
                    }
                    else if(Map[r][c] == s-1) {    //낮아질 때
                        for(int nr=r+1; nr<r+X; nr++) {
                            if(!isIn(nr, c) || Map[nr][c] != Map[r][c])  //경사로 충족 못하면
                                break loop;                           
                        }
                        s = Map[r][c]; 
                        r += X-1;
                        d = 0;
                    }
                    else if (Map[r][c] == s){                      //같을 때
                        d++;
                    }
                    else
                        break loop;
                    
                    if(r==N-1) {
                        Answer += 1;
                        //System.out.println("ㅊㅊ");
                    }
                }
            }// end 세로방향
            output.append("#").append(t).append(" ").append(Answer);
            System.out.println(output);
        } // end t
    } // end main
    
    
    static boolean isIn(int r, int c) {
        return r>=0 && r<N & c>=0 && c<N;
    }
}