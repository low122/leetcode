class Solution {
    public int maxProfit(int[] prices) {
        
        int sum = 0;
        int current_day = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > current_day) {
                sum += (prices[i]-current_day);
            }
            current_day = prices[i];
        }

        return sum;
    }
}