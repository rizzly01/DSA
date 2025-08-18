import java.util.*;

public class Solution {
    private static final double EPSILON = 1e-6; // tolerance for floating-point comparison
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) nums.add((double) c);
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        // Base case: only 1 number left, check if it's 24
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }

        // Try every pair of numbers
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;

                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                double a = nums.get(i), b = nums.get(j);

                // Try all possible results of combining a and b
                for (double val : compute(a, b)) {
                    next.add(val);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1); // backtrack
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPSILON) res.add(a / b);
        if (Math.abs(a) > EPSILON) res.add(b / a);
        return res;
    }
}
