class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>(
            (a,b) -> (b[0]*b[0] + b[1]*b[1]) -(a[0]*a[0] + a[1]*a[1])
        );


        for(int[] point:points){
            maxHeap.add(point);
            if(maxHeap.size()>k) maxHeap.poll();

        }

        return maxHeap.toArray(new int[k][]);
    }
}