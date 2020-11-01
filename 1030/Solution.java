import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output;
    static StringTokenizer tokens;
    static int T, Answer;
    static int[] Cost;
    static int[] Plan;
    static int[] Pay;
    
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(input.readLine());
        
        for(int t=1; t<=T; t++) {
            Cost = new int[4];
            Plan = new int[12];
            Pay = new int[12];
            Answer = Integer.MAX_VALUE;
            output = new StringBuilder();
            
            tokens = new StringTokenizer(input.readLine());
            for(int i=0; i<4; i++) {
                Cost[i] = Integer.parseInt(tokens.nextToken());
            }
            tokens = new StringTokenizer(input.readLine());
            for(int i=0; i<12; i++) {
                Plan[i] = Integer.parseInt(tokens.nextToken());
            }
            
            d2m();
            m2m3();
            m2y();
            
            output.append("#").append(t).append(" ").append(Answer);
            System.out.println(output);
        }
    }
    static void d2m() {
        for(int i=0; i<12; i++) {
            Pay[i] = Math.min(Plan[i] * Cost[0], Cost[1]);
        }
    }
    static void m2m3() {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int sum=tmp[1];
            //System.out.println("시작 " + tmp[0] + " ------ " + tmp[1]);
            for(int i=tmp[0]; i<12; i++) {
            	int s = Pay[i];
                if(i+1<12)
                	s += Pay[i+1];
                if(i+2<12)
                	s += Pay[i+2];
                if(s>Cost[2] && i+2<12) {
                	//System.out.println(i + " - 3개월 : " + sum + " + " + s);
                	q.add(new int[] {i+3, sum + Cost[2]});
                }
            	//System.out.println(i + " - 1개월 : " + sum);
            	sum += Pay[i];
            }
            //System.out.println(Answer + " - " + sum);
            Answer = Math.min(Answer, sum);
        }
    }
    static void m2y() {
        Answer = Math.min(Answer, Cost[3]);
    }
}