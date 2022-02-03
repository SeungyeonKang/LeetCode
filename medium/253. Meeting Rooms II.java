class Solution {
    public int minMeetingRooms(int[][] intervals) {
        /*
        구해야 하는 것. 앞의 회의가 끝나기 전에 시작하는 회의의 수
        starts, ends 를 정렬해서, ends의 회의보다 빨리시작하는 회의의 수를 세주면 된다.
        */
        
        int meetingCounts = intervals.length;
        int[] starts = new int[meetingCounts];
        int[] ends = new int[meetingCounts];
        
        for(int i=0;i<meetingCounts; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms=0;
        int endsIdx = 0;
        for(int i=0;i<meetingCounts;i++){
            //starts[i]<ends[endIdx] 라는 것은 이전의 회의 중 하나가 끝나기 전에 다음 회의가 시작한다는 것을 의미
            if(starts[i]<ends[endsIdx]) rooms++;
            //이전 회의 이후에 시작하는 회의라면 endsIdx++ 
            else endsIdx++;
        }
        return rooms;
    }
}
