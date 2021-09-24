class KthLargest{
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums){
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for(int x : nums){
            add(x);
        }
    }
    public int add(int val){
        pq.pffer(val);
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}