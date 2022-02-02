//Solution2
//Java의 LinkedHashMap을 이용한 방법
//removeEldestEntry를 오버라이드 하여 재작성
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer val = super.get(key);
        return val == null ? -1 : val;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}

