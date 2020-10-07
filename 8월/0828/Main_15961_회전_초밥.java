package com.ssafy.java.day0828;

import java.io.*;
import java.util.*;


public class Main_15961_회전_초밥 {
	static int N, D, K, C, Answer=0;
    static BufferedReader input;
    static StringTokenizer tokens;
    static int[] arr;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new InputStreamReader(System.in));
        tokens = new StringTokenizer(input.readLine());
      
        N = Integer.parseInt(tokens.nextToken());
        D = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        arr = new int[N+K];
        int cnt = 0;
        
        for(int n=0; n<N; n++) {
        	arr[n] = Integer.parseInt(input.readLine());
        }
        //System.out.println(Arrays.toString(arr));
        
        for(int i=0; i<K; i++) {
        	if(map.containsKey(arr[i])) {
        		map.put(arr[i], map.get(arr[i])+1);
        	} else {
        		map.put(arr[i], 1);
        	}
        }
        // 보너스 초밥
        if (!map.containsKey(C))
        	cnt = map.size() + 1;
        else
        	cnt = map.size();
        
        //System.out.println(cnt+", " + map.keySet());
        Answer = Math.max(Answer, cnt);
        
        for(int i=K; i<N+K; i++) {
        	if (Answer == K + 1)
        		break;
        	int re = i-K;
        	int idx = i%N;
        	cnt = 0;
        	
    		// 초밥 제거
    		if (map.get(arr[re]) == 1)
    			map.remove(arr[re]);
    		else
    			map.put(arr[re], map.get(arr[re])-1);
    		
    		// 초밥 추가
    		if (map.containsKey(arr[idx]))
    			map.put(arr[idx], map.get(arr[idx])+1);
    		else
    			map.put(arr[idx], 1);
    		
    		// 보너스 초밥
    		if (!map.containsKey(C))
            	cnt = map.size() + 1;
            else
            	cnt = map.size();
    		
        	//System.out.println(cnt+", " + map.keySet());
        	Answer = Math.max(Answer, cnt);
        }
        System.out.println(Answer);
    }
}