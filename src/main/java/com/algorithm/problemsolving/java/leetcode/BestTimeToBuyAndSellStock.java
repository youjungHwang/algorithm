package com.algorithm.problemsolving.java.leetcode;

/**
 * 121. 주식을 사고팔기 가장 좋은 시점
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 *
 * https://lealea.tistory.com/307
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
