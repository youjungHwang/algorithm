package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 9                        -> 노드의 개수 N
 * -1 0 0 2 2 4 4 6 6       -> 0번 노드부터 N-1번 노드까지, 각 노드의 부모 (만약 부모가 없다면 (루트) -1)
 * 4                        -> 지울 노드의 번호
 *
 * 출력 : 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수
 *  2
 *
 * 문제 : https://www.acmicpc.net/problem/1068
 * - 트리
 */
import java.util.*;
import java.io.*;

class TreeNodes {
    int value;
    List<TreeNodes> children;

    public TreeNodes(int value) {
        this.value = value;
        children = new ArrayList<>();
    }
}

public class _1068_트리 {
    // 트리
    static TreeNodes[] tree;
    static int root;

    // 방문처리를 통해 삭제할 서브 트리 확인
    static boolean[] deletedSub;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 트리 초기화
        tree = new TreeNodes[n];
        for(int i=0; i<n; i++) {
            tree[i] = new TreeNodes(i);
        }

        // [주의] 방문 배열 초기화
        deletedSub = new boolean[n];

        String[] data = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            int parent = Integer.parseInt(data[i]);

            // -1번은 루트
            if(parent == -1) {
                // 루트 노드 설정
                root = i;
            }else {
                tree[parent].children.add(tree[i]);
            }
        }

        // 루트를 지우면 다 삭제
        int deleteIndex = Integer.parseInt(br.readLine());
        if(deleteIndex == root)  {
            System.out.println(0);
            return;
        }

        deleteSubTree(deleteIndex);

        findLeafNodes();
    }

    private static void deleteSubTree(int deleteIndex) {
        // 삭제할 서브트리 부분 방문 처리함
        deletedSub[deleteIndex] = true;
        for (TreeNodes child : tree[deleteIndex].children) {
            deleteSubTree(child.value);
        }
    }

    private static void findLeafNodes() {
        int leafCount = findLeafNodesByDfs(root);
        System.out.print(leafCount);
    }

    private static int findLeafNodesByDfs(int node) {
        int leafCount = 0;

        // 이미 삭제된(방문처리된) 노드면 0
        if(deletedSub[node]) {
            return 0;
        }

        int validChildren = 0;
        for (TreeNodes child : tree[node].children) {
            if (!deletedSub[child.value]) {
                validChildren++;
                leafCount += findLeafNodesByDfs(child.value);
            }
        }

        // 삭제되지 않았고, 유효한 자식이 없는 경우
        if (validChildren == 0) {
            return 1;
        }

        return leafCount;
    }
}
