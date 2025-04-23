class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        curr_num = 0
        curr_str = ""
        
        for char in s:
            if char.isdigit():
                curr_num = curr_num * 10 + int(char)
            elif char == '[':
                stack.append((curr_str, curr_num))
                curr_str = ""
                curr_num = 0
            elif char == ']':
                prev_str, num = stack.pop()
                curr_str = prev_str + num * curr_str
            else:
                curr_str += char
        
        return curr_str

# Example usage
sol = Solution()
print(sol.decodeString("3[a]2[bc]"))       # Output: "aaabcbc"
print(sol.decodeString("3[a2[c]]"))        # Output: "accaccacc"
print(sol.decodeString("2[abc]3[cd]ef"))   # Output: "abcabccdcdcdef"
