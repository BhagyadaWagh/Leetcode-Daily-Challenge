class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0;
        int right = 0;
        int n = fruits.length;
        int currMaxFruits = 0;
        int maxFruits = 0;

        while (right < n) {
            currMaxFruits += fruits[right][1];

            while (left <= right && !isReachable(fruits[left][0], fruits[right][0], startPos, k)) {
                currMaxFruits -= fruits[left][1];
                left += 1;
            }

            maxFruits = Math.max(currMaxFruits, maxFruits);
            right += 1;
        }

        return maxFruits;
    }

    private boolean isReachable(int left, int right, int startPos, int k) {
        int opt1 = Math.abs(startPos - left) + (right - left);
        int opt2 = Math.abs(startPos - right) + (right - left);

        return Math.min(opt1, opt2) <= k;
    }
}
