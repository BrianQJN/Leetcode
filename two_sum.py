"""
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]
"""
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        solution = []
        i = 0
        if not nums:
            return solution
        for num in nums:
            nums_remain = nums[(i+1):]
            if target-num in nums_remain:
                solution.append(nums.index(num))
                solution.append(nums_remain.index(target-num)+nums.index(num)+1)
            i += 1
        return solution

if __name__ == "__main__":
    test = Solution
    print(test.twoSum(test, [2,7,11,15], 9))
    print(test.twoSum(test, [3,2,4], 6))
    print(test.twoSum(test, [3,3], 6))