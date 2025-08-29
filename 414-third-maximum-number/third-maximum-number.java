class Solution {
    public int thirdMax(int[] nums) {
        // Track the top 3 distinct max values
        Integer first = null, second = null, third = null;

        for (int num : nums) {
            // Skip duplicates
            if ((first != null && num == first) || 
                (second != null && num == second) || 
                (third != null && num == third)) {
                continue;
            }

            // Update top 3 maximums
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }

        // If third max doesn't exist, return the maximum
        return (third == null) ? first : third;
    }
}
