class Solution:
    def numberOfArrays(self, differences, lower, upper):
        prefix = [0]
        for diff in differences:
            prefix.append(prefix[-1] + diff)
        
        max_x = min(upper - p for p in prefix)
        min_x = max(lower - p for p in prefix)
        
        return max(0, max_x - min_x + 1)
