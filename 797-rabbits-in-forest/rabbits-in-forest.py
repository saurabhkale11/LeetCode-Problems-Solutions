from collections import Counter

class Solution:
    def numRabbits(self, answers):
        count = Counter(answers)
        total = 0
        for key, value in count.items():
            group_size = key + 1
            groups = (value + group_size - 1) // group_size
            total += groups * group_size
        return total
