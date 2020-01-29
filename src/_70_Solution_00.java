import java.util.HashMap;

/**
 * @author stone
 * @date 2020/01/08
 */
public class _70_Solution_00 {

    // fibonacci 数列

    // 解法一：带缓存的递归
    public int climbStairs1(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return climb_stairs(n, cache);
    }

    public static int climb_stairs(int n, HashMap<Integer, Integer> cache) {
        if (n < 1) { return 0; }
        if (n < 3) { return n; }
        int result;
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            result = climb_stairs(n - 1, cache) + climb_stairs(n - 2, cache);
            cache.put(n, result);
        }
        return result;
    }

    // 解法儿：循环平推
    public int climbStairs2(int n) {
        if (n < 1) { return 0; }
        if (n < 3) { return n; }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

}
