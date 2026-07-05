class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        #result = {}
        result = defaultdict(list)

        for string in strs:
            count = [0] * 26 #a-z

            for c in string:
                count[ord(c) - ord("a")] += 1

            # if tuple(count) not in result:
            #     result[tuple(count)] = []
            #     result[tuple(count)].append(string)
            # else:
            #     result[tuple(count)].append(string)
            result[tuple(count)].append(string)  
        
        return result.values()
