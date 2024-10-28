package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 7                        -> 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)
 * A B C                    ->  각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드
 * B D .
 * C E F
 * E . .
 * F . G
 * D . .
 * G . .
 *
 * 출력 :
 * ABDCEFG
 * DBAECFG
 * DBEGFCA
 *
 * 문제 : https://www.acmicpc.net/problem/1991
 * - 트리 탐색
 */
import java.io.*;

public class 트리_순회 {
    // 트리 노드 생성
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 트리 노드 초기화
        tree = new Node[n];

        // 입력
        for(int i=0; i<n; i++) {
            String[] parts = br.readLine().split(" ");
            char parent = parts[0].charAt(0);
            char left = parts[1].charAt(0);
            char right = parts[2].charAt(0);

            // 부모 노드 생성
            if(tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new Node(parent);
            }

            // 왼쪽 자식 생성
            if(left != '.') {
                tree[left - 'A'] = new Node(left);
                // 부모노드와 연결
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            // 오른쪽 자식 생성
            if(right != '.') {
                tree[right - 'A'] = new Node(right);
                // 부모노드와 연결
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        // 전위 순회 호출
        preorder(tree[0]);
        System.out.println();

        // 중위 순회 호출
        inorder(tree[0]);
        System.out.println();

        // 후위 순회 호출
        postorder(tree[0]);
        System.out.println();
    }

    // Node 클래스
    private static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // preorder 메서드
    private static void preorder(Node node) {
        if(node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // inorder 메서드
    private static void inorder(Node node) {
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    // postorder 메서드
    private static void postorder(Node node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}
