package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/14267
 * - 트리
 */
import java.util.*;
import java.io.*;

// 트리
class CompanyTree {
    int value;
    List<CompanyTree> children;

    public CompanyTree(int value) {
        this.value = value;
        this.children =  new ArrayList<>();
    }
}
public class _14267 {
    private static CompanyTree[] tree;
    private static int root;
    private static int[] good;
    private static int[] totalGood;
    private static int n;

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        // 직원 수
        n = Integer.parseInt(info[0]);
        // 칭찬의 횟수
        int m = Integer.parseInt(info[1]);

        // 트리 초기화 (배열 크기를 n + 1로 설정)
        tree = new CompanyTree[n+1];
        for (int i = 1; i <= n; i++) { // 5
            tree[i] = new CompanyTree(i);
        }

        // 초기화
        good = new int[n + 1];
        totalGood = new int[n + 1];

        // 트리 생성
        String[] treeInfo = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            int person = Integer.parseInt(treeInfo[i - 1]);

            // 루트
            if (person == -1) {
                root = i;
            } else {
                tree[person].children.add(tree[i]);
            }
        }

        // 칭찬 받은 직원 번호, 칭찬의 수치
        for (int i = 1; i <= m; i++) {
            String[] countAboutPerson = br.readLine().split(" ");
            int person = Integer.parseInt(countAboutPerson[0]);
            int count = Integer.parseInt(countAboutPerson[1]);
            good[person] += count; // 누적하지 않으면 같은 person가 들어왔을 때 값이 덮어씌워짐
        }

        plusGood(root,0);

        for(int i=1; i<=n; i++) {
            bw.write(totalGood[i]+" ");
        }
        bw.flush();
        bw.close();
    }

    // [주의] 칭찬은 자식으로 가면서 + 된다 (누적 할 값이 plus)
    // O(N)
    private static void plusGood(int node, int plus) {
        totalGood[node] = good[node] + plus;

        for(CompanyTree child : tree[node].children) {
            plusGood(child.value, totalGood[node]);
        }
    }
}
