class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    //TC : O(1) -> 모든 문제 해결을 위해서는 O(n)
    //SC : O(1) -> 모든 문제 해결을 위해서는 O(n)
    public int next(int price) {
        //price가 주어지면 앞의 일 중 price 보다 금액이 같거나 작은 일수 반환
        //앞의 일에 대한 배열은 주어지지 않음 -> 누적하고 있어야 함
        //monotinic stack 이용 -> 스택을 오름차순/내림차순으로 정렬
        //스택을 넣을떄 이전 값과 비교해서 더 작은 경우에만 push
        //더 큰 경우에는 더 작은 값들을 빼준 후 stack으로 push
        //이때 count 값도 같이 저장해줌 (count 값의 의미는 이전 원소 중 현재 값보다 작은 것들의 갯수)
        
        int count = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            count += stack.pop()[1];
        }
        stack.push(new int[]{price, count});
        
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
