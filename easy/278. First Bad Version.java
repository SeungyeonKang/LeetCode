/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    //TC : O(logN)
    //SC : O(1)
    public int firstBadVersion(int n) {
        int start=1, end = n, result=n;
        
        while(start<=end) {
            int mid = start + (end-start)/2; // to avoid overflow => maximun n is 2^31 -1
            boolean isBad = isBadVersion(mid);
        
            if(isBad) {
                result = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return result;
    }
}

