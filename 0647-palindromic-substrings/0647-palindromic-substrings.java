class Solution {

    public int countSubstrings(String s){
        int n=s.length();
        if(n==0|| n==1) return n;


        int cnt=0;

        for(int i=0; i<n; i++){
            int j=i, k=i;
            while(j>=0 && k<n && s.charAt(j)==s.charAt(k)){
                j--;
                k++;
                cnt++;
            }
            j=i;
            k=i+1;

            while(j>=0 && k<n && s.charAt(j)== s.charAt(k)){
                j--;
                k++;
                cnt++;
            }
        }

        return cnt;

    }
   
}