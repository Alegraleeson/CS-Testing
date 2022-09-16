import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {

    public static int missingNumber(int[] nums, int max) {
        int[] countArray = new int[max];
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i] - 1] = 0;
            countArray[nums[i] - 1]++;
        }

//        int i = 0;
//        while (i < max){
//            if(countArray[i] != 0){
//                i++;
//            } else if(countArray[i] == 0){
//                result= nums[i];
//                return result;
//
//            }
//        }

        for (int i = 1; i < max; i++) {
            if (countArray[i] == 0) {
                result = nums[i];
                return result;
//                System.out.println(nums[i]);
            } else if (countArray[i] != 0) {
                result = 0;
            }
        }
        return result;
    }

    public static int missingNumberStream(int[] nums, int maxNum) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= maxNum; i += 1) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    public static int missingNumberSort(int[] nums, int maxNum) {
        Arrays.sort(nums);

        for (int i = 1; i < maxNum; i += 1) {
            if (i != nums[i - 1]) {
                return i;
            }
        }

        if (nums.length == maxNum && nums[maxNum - 1] == maxNum) {
            return 0;
        }

        return maxNum;
    }

    public static int missingNumberSum(int[] nums, int maxNum) {

        int expectedSum = 0;
        for (int i = 1; i <= maxNum; i += 1) {
            expectedSum += i;
        }

        int actualSum = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }

}


