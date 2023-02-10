class Solution:
    def search(self, nums: List[int], target: int) -> int:
        '''
        Binary Search with certain condition

        General Binary Search :
         - if mid > target : r = m-1
         - else : l = m+1

        For this question :
         - if mid >= l :
            if l <= target < mid : r = mid-1  
            else l = mid+1
         - else :
            if mid < target <= r : l = mid+1
            else r = mid-1
        '''
        l, r = 0, len(nums)-1
        
        while l<=r :
            mid = int((r + l) / 2);
            if nums[mid] == target : return mid
            
            if nums[mid] >= nums[l] :
                if nums[l] <= target and target < nums[mid] :
                    r = mid-1
                else :  l = mid+1
            else :
                if nums[mid] < target and target <= nums[r] : 
                    l = mid+1
                else :
                    r = mid-1
        
        return -1
