class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res= new ArrayList<>();
        Deque<Integer> dq= new LinkedList<>();


        for(int i=0; i<nums.length; i++){
            while(!dq.isEmpty() && dq.getLast()<nums[i]){
                dq.pollLast();
            }
            dq.addLast(nums[i]);

            if(i>=k && nums[i-k] ==dq.getFirst()){
                dq.pollFirst();
            }

            if(i>=k -1){
                res.add(dq.getFirst());
            }

        }

        return res.stream().mapToInt(i->i).toArray();
    }
}