class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);

        int[] ar1= new int[nums.length-1];
        int[] ar2= new int[nums.length-1];

        for(int i=0; i<ar1.length; i++){
            if(i==0 || i==1) ar1[i]= nums[i];

            else if(i==2) ar1[i]= nums[i] +ar1[i-2];
            else ar1[i] = nums[i] + Math.max(ar1[i-2], ar1[i-3]);
        }

        for(int i=0; i<ar1.length; i++){
            if(i==0 || i==1) ar2[i]= nums[i+1];

            else if(i==2) ar2[i]= nums[i+1]+ ar2[i-2];
            else ar2[i] = nums[i+1] + Math.max(ar2[i-2], ar2[i-3]);
        }

        int i= Math.max(ar1[ar1.length-1], ar1[ar1.length-2]);
        int j= Math.max(ar2[ar1.length-1], ar2[ar1.length-2]);

        return Math.max(i,j);
        
    }

}