package com.ssafy.java.day0817;

import java.io.*;
import java.util.*;

public class Main {
	static int N, Answer=0;
	static int[] Tmp, P, S, Origin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = new int[N];
		S = new int[N];
		Origin = new int[N];
		Tmp = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Origin[i] = P[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(findSortCount());
	}

	private static int findSortCount() {
		while (!chk()) {
			Answer++;
			shuffle();
			if (isCycle()) {
				return -1;
			}
		}
		return Answer;
	}

	private static void shuffle() {
		for (int i = 0; i < N; i++) {
			Tmp[i] = P[i];
		}
		for (int i = 0; i < N; i++) {
			P[S[i]] = Tmp[i];
		}
	}

	private static boolean isCycle() {
		for (int i = 0; i < N; i++) {
			if (Origin[i] != P[i]) {
				return false;
			}
		}
		return true;
	}

	private static boolean chk() {
		for (int i = 0; i < N; i++) {
			if (P[i] != (i % 3)) {
				return false;
			}
		}
		return true;
	}

}

