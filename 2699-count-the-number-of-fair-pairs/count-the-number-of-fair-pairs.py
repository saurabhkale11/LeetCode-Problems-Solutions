import bisect

class Solution:
    def countFairPairs(self, nums, lower, upper):
        nums.sort()
        n = len(nums)
        count = 0
        
        for i in range(n):
            # Find the lower bound of nums[j] such that nums[i] + nums[j] >= lower
            left = bisect.bisect_left(nums, lower - nums[i], i + 1, n)
            # Find the upper bound of nums[j] such that nums[i] + nums[j] <= upper
            right = bisect.bisect_right(nums, upper - nums[i], i + 1, n)
            
            count += (right - left)
        
        return count
