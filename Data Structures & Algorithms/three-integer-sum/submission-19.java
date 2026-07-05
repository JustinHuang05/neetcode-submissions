class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            int target = nums[i] * (-1);

            int leftPointer = 0;
            int rightPointer = nums.length - 1;

            while (true) {
                int twoSum = nums[leftPointer] + nums[rightPointer];

                if (rightPointer == i) {
                    rightPointer--;
                } else if (leftPointer == i) {
                    leftPointer ++;
                } else {
                    if (twoSum == target) {
                        result.add(List.of(nums[leftPointer], nums[i], nums[rightPointer]));
                        System.out.print(List.of(nums[leftPointer], nums[i], nums[rightPointer]));
                        leftPointer ++;
                    } else if (twoSum < target) {
                        leftPointer ++;
                    } else {
                        rightPointer --;
                    }
                }

                if (rightPointer <= leftPointer) {
                    break;
                }
            }
        }

        for (int k = 0; k < result.size(); k++) {
            for (int h = 0; h < result.size(); h++) {
                if (h != k) {
                    if (result.get(k).contains(result.get(h).get(0)) && result.get(k).contains(result.get(h).get(1)) && result.get(k).contains(result.get(h).get(2))) {
                        result.remove(h);
                        h--;
                    }
                }
            }
        }

        return result;
    }
}
