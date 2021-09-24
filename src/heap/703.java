class KthLargest{
    // 堆排序解法：维护一个大小为k的小根堆，若当前要插入的数小于等于堆顶元素，则丢弃；否则插入，可以直接插入到堆顶，再进行调整，堆顶元素保存了第K大元素
    // 创建一个小根堆
    int[] heap;
    int size = 0;
    int count = 0;
    public KthLargest(int k, int[] nums){
        heap = new int[k];
        count = k;

        // 初始化一个大小为k的小根堆
        for(int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
    }

    public int add(int val){
        if (size < count){
            heap[size] = val;
            up(size);
            size++;
        } else if(heap[0] < val){
            heap[0] = val;
            down(0)
        }
        return heap[0];
    }
    //自上而下调整队
    public void down(int u){
        int t = u;
        if (2 * u + 1 < size && heap[2 * u + 1] < heap[t])
            t = 2 * u + 1;
        if (2 * u + 2 < size && heap[2 * u + 2] < heap[t])
            t = 2 * u + 2;
        if (t != u){
            int temp = heap[u];
            heap[u] = heap[t];
            heap[t] = temp;
            down(t);
        }
    }

    //自下而上调整堆
    public void up (int u){
        // 存在父节点，并且父节点的值大于当前值，则进行交换
        while ((int)(Math.ceil(u / 2.0) - 1) >= 0 && heap[(int)Math.ceil(u / 2.0) - 1] > heap[u]){
            int p = (int)(Math.ceil(u / 2.0) - 1);
            int temp = heap[u];
            heap[u] = heap[p];
            heap[p] = temp;
            u = p;
        }
    }
}