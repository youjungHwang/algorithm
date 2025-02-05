import java.util.*;

class Solution {
    public int solution(int[] nums) {      
        // nums를 set에 넣음
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        
        // set의 수를 확인 >= N/2 -> N/2
        if(set.size() >= (nums.length) / 2) {
            return (nums.length) / 2;
        }else {
            // set의 수를 확인 < N/2 -> set의 수
            return set.size();
        }
        
            
    }
}