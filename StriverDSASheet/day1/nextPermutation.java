package StriverDSASheet.day1;

public class nextPermutation {

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        nextPermutation(nums);
        for(int x : nums) {
            System.out.print(x+" ");
        }
    }
    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-1;
        for(; i > 0 ; i--) {

            if(nums[i-1] < nums[i]) {
                int index = i-1;
                for(int j = n-1; j >i-1 ; j--) {
                    if(nums[j] > nums[index]) {
                        int temp = nums[index];
                        nums[index] = nums[j];
                        nums[j] = temp;
                        break;

                    }
                }


                for(int k = index+1,j = n-1; k < j ; k++ ,j--) {
                    int temp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = temp;
                }

                break;
            }
        }

        if(i == 0) {
            for(int k = 0,j = n-1; k < j ; k++ ,j--) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
