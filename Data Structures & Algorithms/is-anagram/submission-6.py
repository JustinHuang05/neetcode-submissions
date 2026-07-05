class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):
            return False
        
        sHM, tHM = {}, {}
        for i in range(len(s)):
            sHM[s[i]] = 1 + sHM.get(s[i], 0)
            tHM[t[i]] = 1 + tHM.get(t[i], 0)
        
        for j in sHM:
            if sHM[j] != tHM.get(j, 0):
                return False

        return True