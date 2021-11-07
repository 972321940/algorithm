package com.wuz11.shuzhu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuzheng
 */
public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (first + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                }
            }
        }
        return a;
    }

    // 优解
    private static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("没有");
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 16};
        int target1 = 18;
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] nums3 = {3, 3};
        int target3 = 7;

        System.err.println(Arrays.toString(twoSum(nums1,target1)));
        System.err.println(Arrays.toString(twoSum(nums2,target2)));
        System.err.println(Arrays.toString(twoSum(nums3,target3)));

        System.err.println(Arrays.toString(twoSum1(nums1,target1)));
        System.err.println(Arrays.toString(twoSum1(nums2,target2)));
        System.err.println(Arrays.toString(twoSum1(nums3,target3)));
    }
}
