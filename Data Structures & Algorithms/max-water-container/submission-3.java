// class Solution {
//     public int maxArea(int[] heights) {
//         int max = 0;
//         for (int i = 0; i < heights.length; i++) {
//             for (int j = i + 1; j < heights.length; j++) {
//                 int curAmt = 0;
//                 if (heights[i] <= heights[j]) {
//                     curAmt = heights[i] * (j - i);
//                 } else {
//                     curAmt = heights[j] * (j - i);
//                 }
//                 if (curAmt > max) {
//                     max = curAmt;
//                 }
//             }
//         }

//         return max;
//     }
// }

class Solution {
    public int maxArea(int[] heights) {
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int max = 0;
        while (true) {
            int curAmt = 0;
            if (heights[leftPointer] <= heights[rightPointer]) {
                curAmt = heights[leftPointer] * (rightPointer - leftPointer);
            } else {
                curAmt = heights[rightPointer] * (rightPointer - leftPointer);
            }

            if (curAmt > max) {
                max = curAmt;
            }

            if (rightPointer <= leftPointer) {
                break;
            } else {
                if (heights[leftPointer] <= heights[rightPointer]) {
                    leftPointer ++;
                } else {
                    rightPointer --;
                }
            }
        }

        return max;
    }
}
