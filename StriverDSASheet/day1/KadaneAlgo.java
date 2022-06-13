package StriverDSASheet.day1;

public class KadaneAlgo {

    public static void main(String[] args) {
        int[] nums = {-2,-11,-3,-4,-1,-2,-1,-5,-4};
        System.out.println(maxSubArray(nums));
    }
    private static int maxSubArray(int[] nums) {
        boolean allNegative = true;
        int max = nums[0];

        int cur_sum = 0;
        int max_sum = Integer.MIN_VALUE;

        for (int num : nums) {

            max = Math.max(max, num);
            if (num > 0) {
                allNegative = false;
            }

            cur_sum += num;

            if (cur_sum < 0) cur_sum = 0;

            max_sum = Math.max(max_sum, cur_sum);

        }
        
        return allNegative?max:max_sum;
    }
}
