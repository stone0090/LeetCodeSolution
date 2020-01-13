import java.util.Arrays;
import java.util.HashMap;

/**
 * @author stone
 * @date 2020/01/08
 */
public class _189_Solution {

    // 解法一，嵌套循环
    // 执行耗时:106 ms,击败了22.63% 的Java用户
    // 内存消耗:37.8 MB,击败了90.37% 的Java用户
    public static void rotate1(int[] nums, int k) {

    }

    // 解法二，使用额外HashMap，一次循环
    // 执行耗时:8 ms,击败了38.72% 的Java用户
    // 内存消耗:38.7 MB,击败了41.36% 的Java用户
    public static void rotate2(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % nums.length;
            if (!hm.containsKey(index)) {
                hm.put(index, nums[index]);
            }
            if (hm.containsKey(i)) {
                nums[index] = hm.get(i);
            } else {
                hm.put(i, nums[i]);
                nums[index] = nums[i];

            }
        }
    }

    // 解法三，使用额外数组，两次循环
    // 执行耗时:1 ms,击败了81.21% 的Java用户
    // 内存消耗:37.4 MB,击败了95.41% 的Java用户
    public static void rotate3(int[] nums, int k) {

    }

    // 解法四
    // 执行耗时:1 ms,击败了81.21% 的Java用户
    // 内存消耗:36.6 MB,击败了95.45% 的Java用户
    public static void rotate4(int[] nums, int k) {

    }

    // 解法五
    // 执行耗时:0 ms,击败了100.00% 的Java用户
    // 内存消耗:38.4 MB,击败了57.65% 的Java用户
    public static void rotate5(int[] nums, int k) {

    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate2(nums, k);
        System.out.println(Arrays.toString(nums));
        // System.out.println((6-0)%7);
    }

}
