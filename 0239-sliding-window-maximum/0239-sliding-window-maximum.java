class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n= nums.length;
        int[] ans= new int[n-k+1];

        //dq has indexes of all the important elelments in the current windows
        //imp elelmnts are the ones that are the max in each window
        //Also the elements stored are  monotonic, i.e. Largest Element at front and Smallest Element at the back.

        Deque<Integer> dq= new ArrayDeque<>();

        int idx=0;

        for(int i=0; i<n; i++){
            //remove indices out of current window
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            //maintain the decreasing order
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);


            //add vales to ans array once window is formed
            if(i>=k-1){
                ans[idx++]= nums[dq.peekFirst()];
            }
        }

        return ans;

    }
}