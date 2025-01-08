package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/1068
 * - 트리
 */
import java.util.*;
import java.io.*;

class Tree {
    int value;
    List<Tree> children;

    public Tree(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}
public class _1068 {
    private static Tree[] tree;
    private static int n;
    private static int root;
    private static boolean[] visited;


    public static void main(String[] arg) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 트리 초기화
        tree = new Tree[n];
        for(int i=0; i<n; i++) {
            tree[i] = new Tree(i);
        }

        // 방문 확인 배열
        visited = new boolean[n];

        // 트리 만들기
        String[] info = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            int parent = Integer.parseInt(info[i]);

            // 루트
            if(parent == -1) {
                root = i;
            }else {
                tree[parent].children.add(tree[i]);
            }
        }

        // 지울 노드
        int soonDeleteNodeIndex = Integer.parseInt(br.readLine());
        // 만약 루트라면 다 삭제
        if(soonDeleteNodeIndex == root){
            System.out.print(0);
            return;
        }

        deleteNode(soonDeleteNodeIndex);

       int leafCount = findLeafNodesDfs(root);
       System.out.print(leafCount);
    }

    // 지울 노드와 연결된 모든 자식 노듣 방문 처리
    private static void deleteNode(int node) { // 2
        // 트리에서 주어진 node에 연결된 자손 노드 전부 삭제한다
        visited[node] = true;
        for(Tree child : tree[node].children) {
            deleteNode(child.value);
        }
    }

    private static int findLeafNodesDfs(int node)  {
        if(visited[node]) {
            return 0;
        }

        int validChild = 0;
        // root에 이어진 자식 노드 찾기
        for(Tree child : tree[node].children) {
            if(!visited[child.value]) {
                // 살아남은 노드
                validChild += findLeafNodesDfs(child.value);
            }
        }

        // [주의] 삭제되지 않았고, 유효한 자식이 없는 경우
        if (validChild == 0) {
            return 1;
        }

        return validChild;
    }
}
