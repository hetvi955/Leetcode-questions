class Solution {

    public boolean wordBreak(String s, List<String> dict){
        int n=s.length();

        boolean[] dp= new boolean[n+1];
        dp[0]= true;
        int maxl=0;

        for(String word: dict){
            maxl=Math.max(maxl, word.length());
        }

        for(int i=0; i<=n; i++){
            for(int j=i-1; j>=Math.max(i-maxl-1, 0); j--){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
