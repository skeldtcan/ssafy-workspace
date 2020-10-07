import java.util.Scanner;
import java.io.FileInputStream;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++) {
            int N = sc.nextInt();
            int map[][] = new int[N][N];
            int cnt = 1;
            for (int i=0; i<N; i++) {
                map[0][i] = cnt++;
            }
            int r = 0;
            int c = N-1;
            int direct = 1;
             
            for(int i=N-1; i>0; i--) {          
                for(int j=0; j<i; j++) {
                    r = r + 1*direct;
                    //System.out.println(r+" "+c+" "+cnt);
                    map[r][c] = cnt++;
                }
                for(int j=0; j<i; j++) {
                    c = c + -1*direct;
                    //System.out.println(r+" "+c+" "+cnt);
                    map[r][c] = cnt++;
                }
                direct *= -1;
            }
            System.out.printf("#%d\n", test_case);
            for(int[] i: map) {
                for(int j: i) 
                    System.out.print(j+" ");
                System.out.println();
            }
        }
    }
}