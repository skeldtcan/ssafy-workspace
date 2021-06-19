package com.ssafy.java.day12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


class Top {
	int height, idx;

	public Top(int height, int idx) {
		this.height = height;
		this.idx = idx;
	}
}

public class Main {
	static int[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Stack<Top> stack = new Stack<Top>();
		int N = Integer.parseInt( bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		answer = new int[N];

		for (int i = 0; i < N; i++) {
			int building = Integer.parseInt(st.nextToken());
			if (!stack.isEmpty()) {
				if (stack.peek().height < building) {
					while (!stack.isEmpty() && stack.peek().height < building) {
						stack.pop();
					}

					if(!stack.isEmpty()) {
						answer[i] = stack.peek().idx + 1;
					}

					stack.push(new Top(building, i));
				} else {
					answer[i] = stack.peek().idx + 1;
					stack.push(new Top(building, i));
				}
			} else {
				stack.push(new Top(building, i));
			}
		}
        for (int a: answer)
            System.out.print(a +" ");
		
	}
}
