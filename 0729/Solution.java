package com.ssafy.java.day11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
        int[] small = new int[9];
        for(int i=0; i<9; i++)
            small[i] = sc.nextInt();
        int s1=0;
        int s2=0;
        Arrays.sort(small);
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                int sum = 0;
                for(int k=0; k<9; k++) {
                    if(k != i && k!= j)
                        sum += small[k];
                }
                if(sum == 100) {
                    s1 = i;
                    s2 = j;
                    break;
                }
            }
        }
        for(int i=0; i<9; i++) {
            if(i!=s1 && i!=s2)
                System.out.println(small[i]);
        }
	}
}
