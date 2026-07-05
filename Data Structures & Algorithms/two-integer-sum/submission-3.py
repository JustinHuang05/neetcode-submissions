class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # for i in range(len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i,j]
        value_index_HM = {}
        for i in range(len(nums)):
            difference = target - nums[i]
            if difference in value_index_HM:
                return [value_index_HM[difference], i]
            value_index_HM[nums[i]] = i
        return


         