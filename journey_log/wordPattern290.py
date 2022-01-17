class Solution:
    def wordPattern(pattern: str, s: str) -> bool:
        # My soln
        map = {}
        s_list = s.split(" ")
        size: int = len(pattern)

        if (size % 2 != 0 or len(s_list) % 2 != 0 or len(s_list) != size):
            return False

        if (len(set(pattern)) != len(set(s_list))):
            return False

        for i in range(size // 2):
            map[pattern[i]] = s_list[i]

        
        for j in range(size - 1, size // 2 - 1, -1):
            if (map[pattern[j]] != s_list[j]):
                return False

        return True
        

pattern1 = "abba"
s1 = "dog cat cat dog"
assert Solution.wordPattern(pattern1, s1) == True, "Fail test 1"

pattern2 = "abba"
s2 = "dog cat cat fish" 
assert Solution.wordPattern(pattern2, s2) == False, "Fail test 2"

pattern3 = "aaaa" 
s3 = "dog cat cat dog"
assert Solution.wordPattern(pattern3, s3) == False, "Fail test 3"

pattern4 = "abba"
s4 = "dog dog dog dog"
assert Solution.wordPattern(pattern4, s4) == False, "Fail test 4"

pattern5 = "a"
s5 = "a"
assert Solution.wordPattern(pattern5, s5) == True, "Fail test 5"
