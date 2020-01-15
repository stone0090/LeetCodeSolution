import java.util.Arrays;

/**
 * @author stone
 * @date 2020/01/08
 */
public class _189_Solution {

    // 解法一，嵌套循环
    // 执行耗时:104 ms,击败了27.61% 的Java用户
    // 内存消耗:37.3 MB,击败了95.41% 的Java用户
    public static void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    // 解法二，使用额外数组，两次循环
    // 执行耗时:1 ms,击败了81.21% 的Java用户
    // 内存消耗:37.4 MB,击败了95.41% 的Java用户
    public static void rotate2(int[] nums, int k) {
        int[] temps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int index = (k + i) % nums.length;
            temps[index] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temps[i];
        }
    }

    // 解法四
    // 执行耗时:1 ms,击败了81.21% 的Java用户
    // 内存消耗:38.2 MB,击败了74.66% 的Java用户
    public static void rotate3(int[] nums, int k) {
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int previous_index = i;
            int previous_value = nums[i];
            do {
                int next_index = (k + previous_index) % nums.length;
                int temp = nums[next_index];
                nums[next_index] = previous_value;
                previous_value = temp;
                previous_index = next_index;
                count++;
            } while (i != previous_index);
        }
    }

    // 解法四
    // 执行耗时:0 ms,击败了100.00% 的Java用户
    // 内存消耗:38.4 MB,击败了57.65% 的Java用户
    public static void rotate4(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        rotate4(nums, k);
        // reverse(nums, 5, 9);
        System.out.println(Arrays.toString(nums));
        // System.out.println((6-0)%7);

    }

}
