class Solution:
    def countSubarrays(self, nums, minK, maxK):
        result = 0
        lastMin = -1
        lastMax = -1
        lastInvalid = -1
        
        for i in range(len(nums)):
            if nums[i] < minK or nums[i] > maxK:
                lastInvalid = i
            if nums[i] == minK:
                lastMin = i
            if nums[i] == maxK:
                lastMax = i
            
            if lastMin != -1 and lastMax != -1:
                result += max(0, min(lastMin, lastMax) - lastInvalid)
        
        return result
