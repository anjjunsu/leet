class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        match = { '(' : ')', '{' : '}', '[' : ']' }

        if len(s) % 2 != 0:
            return False

        for c in s:
            if (c in match.keys()):
                stack.append(c)
            else:
                if (not stack):
                    return False
                else:
                    if (match[stack.pop()] != c):
                        return False
        return stack == []        

sol = Solution()
print(sol.isValid("([)]"))