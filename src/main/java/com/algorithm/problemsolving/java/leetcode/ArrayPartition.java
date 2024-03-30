package com.algorithm.problemsolving.java.leetcode;

import java.util.*;

/**
 * 561. Array Partition
 *
 * 문제: https://leetcode.com/problems/array-partition/description/
 * 해설: https://lealea.tistory.com/305
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