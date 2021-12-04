class Solution {
    
    /*
        truckSize만큼의 box를 각각의 트럭에 담을 때 가능한 최대의 units
        boxTypes[박스의 갯수][해당 박스의 Unit]
        
        Time Complexity : O(nlogn) + O(n)  = O(nlogn)
        Space Complexity : O(n)
    */
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Arrays.sort(boxTypes, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] a, int[] b) {
        //         return b[1]-a[1];
        //     }
        // });
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1])); //O(nlogn)
        
        int units = 0;
        for(int i=0; i<boxTypes.length; i++){ //O(n)
            int currBoxCnt = Math.min(boxTypes[i][0], truckSize);
            units += currBoxCnt * boxTypes[i][1];
            truckSize-=currBoxCnt;
            if(truckSize==0) break;
        }
        
        return units;
    }
}

