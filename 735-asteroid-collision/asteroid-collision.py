from typing import List

class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for asteroid in asteroids:
            while stack and asteroid < 0 < stack[-1]:
                if stack[-1] < -asteroid:
                    stack.pop()
                    continue
                elif stack[-1] == -asteroid:
                    stack.pop()
                break
            else:
                stack.append(asteroid)
        return stack

# Example usage:
sol = Solution()
print(sol.asteroidCollision([5, 10, -5]))   # Output: [5, 10]
print(sol.asteroidCollision([8, -8]))       # Output: []
print(sol.asteroidCollision([10, 2, -5]))   # Output: [10]
