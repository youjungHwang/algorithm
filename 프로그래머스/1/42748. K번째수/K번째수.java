import java.util.*;
import java.io.*;

class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] answer = new int[size];
        
        for(int i=0; i<size; i++) {
            int x = commands[i][0];
            int y = commands[i][1];
            int k = commands[i][2];
            answer[i] = findNumber(array, x,y,k);
        }
              
        return answer;
    }
    
    private static int findNumber(int[] array, int x, int y, int k) {
        int[] arrB = new int[y-x+1];
                
        for(int i=0; i<arrB.length; i++) {
            arrB[i] = array[x - 1 + i];
        } 
        
        // 정렬
        Arrays.sort(arrB);
        
        System.out.print(Arrays.toString(arrB));
        
        return arrB[k-1];
        
    }
}