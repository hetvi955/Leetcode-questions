class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int res=0;

        int buyVal=Integer.MAX_VALUE;
        int maxSoFar= 0;

        for(int i=0; i<n; i++){
        buyVal= Math.min(buyVal, prices[i]);

        maxSoFar= (prices[i]-buyVal);
        res= Math.max(res, maxSoFar);
        }


        return res;
    }

}