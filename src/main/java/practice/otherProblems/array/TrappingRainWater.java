package practice.otherProblems.array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

 Example:

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        if(height == null || height.length <=2) {
            return result;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = height[0];
        left[0] = height[0];

        // scan from left to right
        for(int i=1;i<height.length;i++) {
            if (height[i] < max) {
                left[i] = max;
            } else {
                max = height[i];
                left[i] = height[i];
            }
        }

        // scan from right to left
        max = height[height.length-1];
        right[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0;i--) {
            if (height[i] < max) {
                right[i] = max;
            } else {
                max = height[i];
                right[i] = height[i];
            }
        }

        // calculate total
        for(int i=0;i<height.length;i++) {
            result+= Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater.trap(height));
    }
}
