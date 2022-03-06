class Solution:
    def wordPattern(pattern: str, s: str) -> bool:
        words = s.split(' ')
        map = {}

        if (len(pattern) != len(words)):
            return False
        if (len(set(pattern)) != len(set(words))):
            return False

        for i in range(len(words)):
            if pattern[i] not in map:
                map[pattern[i]] = words[i]
            elif map[pattern[i]] != words[i]:
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
