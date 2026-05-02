class Solution {
        public int[][] merge(int[][] intervals) {

        if(intervals.length<=1) return intervals;
        List<int[]> res= new ArrayList<>();

        Arrays.sort(intervals, (arr1, arr2)-> Integer.compare(arr1[0], arr2[0]));

        int[] curr=intervals[0];
        res.add(curr);

        for(int [] i: intervals){
            int curr_beg=curr[0];
            int curr_end=curr[1];
            int next_end=i[1];
            int next_beg=i[0];


            if(curr_end>=next_beg){
                curr[1]= Math.max(curr_end, next_end);
            }else{
                curr=i;
                res.add(curr);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}