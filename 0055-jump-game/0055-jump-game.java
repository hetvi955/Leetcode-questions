class Solution {
    // public boolean canJump(int[] nums) {
    //     int lgip=nums.length-1;

    //     for(int i=nums.length-1; i>=0; i--){
    //         if(i+nums[i]>=lgip){
    //             lgip=i;
    //         }
    //     }


    //     return lgip==0;

    // }

    public boolean canJump(int[] nums){
        int maxind=0;

        for(int i=0; i<nums.length; i++){
            if(i>maxind) return false;
            maxind=Math.max(i+nums[i], maxind);
        }

        return true;
    }
}