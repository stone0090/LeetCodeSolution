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
    // 内存消耗:36.6 MB,击败了95.45% 的Java用户
    public static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int current_index = i;
            int previous = nums[i];
            do {
                int next_index = (k + count) % nums.length;
                int temp = nums[next_index];
                nums[next_index] = previous;
                previous = temp;
                current_index = next_index;
                count++;
            } while (i != current_index);
        }
    }

    // 解法五
    // 执行耗时:0 ms,击败了100.00% 的Java用户
    // 内存消耗:38.4 MB,击败了57.65% 的Java用户
    public static void rotate5(int[] nums, int k) {

    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate3(nums, k);
        System.out.println(Arrays.toString(nums));
        // System.out.println((6-0)%7);
    }

}
