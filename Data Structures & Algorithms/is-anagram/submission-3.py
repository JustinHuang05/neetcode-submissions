class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        storeList1 = []
        storeList2 = []
        for i in s:
            storeList1.append(i)
        for i in s:
            storeList2.append(i)
        for i in t:
            if i in storeList1:
                storeList1.remove(i)
                storeList2.remove(i)
            else:
                return False
        if len(storeList1)==0 and len(storeList2)==0:
            return True
        return False