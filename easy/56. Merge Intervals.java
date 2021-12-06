class Solution {
    public int[][] merge(int[][] intervals) {
        //invertals[i][0]기준으로 소팅되어 들어오는지?
        //[[1,3],[2,6],[8,10],[15,18]]
        //현재 구간의 end 값 > intervals[i+1][0] == 합쳐지는 구간
        //합쳐지는 구간이면 result에 추가하지 않고, 합쳐지는 구간이 아니면 result에 추가
        //**해당 구간 중 가장 앞쪽값고 뒷쪽 값 저장하고 있어야 함
        //Time Complexity : O(NlogN + N) => O(NlogN)
        //Space Compolexity : O(n)
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); //O(NlogN)
        ArrayList<int[]> result = new ArrayList<>();
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i=0;i<intervals.length-1; i++){  //O(N)
            if(end >= intervals[i+1][0]) {
                end = Math.max(intervals[i+1][1], end);
            } else {
                result.add(new int[] {start,end});
                start = intervals[i+1][0];
                end = intervals[i+1][1];
            }
        }
        result.add(new int[] {start,end});
        return result.toArray(new int[result.size()][]);
    } 
}
