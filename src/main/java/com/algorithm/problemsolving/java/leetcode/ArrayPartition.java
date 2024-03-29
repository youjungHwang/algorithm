package com.algorithm.problemsolving.java.leetcode;

import java.util.*;

/**
 * 561. Array Partition
 * https://lealea.tistory.com/305
 */
class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        int result = 0;

        Arrays.sort(nums);
        for(int i=0; i<nums.length; i+=2){
            result += nums[i];
        }

        return result;
    }

}