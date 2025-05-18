import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<Integer> states = new ArrayList<>();
        Map<Integer, List<Integer>> neighbors = new HashMap<>();

        generateStates(m, 0, 0, states);

        for (int s1 : states) {
            neighbors.put(s1, new ArrayList<>());
            for (int s2 : states) {
                if (isCompatible(s1, s2, m)) {
                    neighbors.get(s1).add(s2);
                }
            }
        }

        Map<Integer, Integer> dp = new HashMap<>();
        for (int state : states) {
            dp.put(state, 1);
        }

        for (int col = 1; col < n; col++) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for (int curr : states) {
                int count = 0;
                for (int prev : neighbors.get(curr)) {
                    count = (count + dp.get(prev)) % MOD;
                }
                newDp.put(curr, count);
            }
            dp = newDp;
        }

        int result = 0;
        for (int val : dp.values()) {
            result = (result + val) % MOD;
        }

        return result;
    }

    private void generateStates(int m, int pos, int curr, List<Integer> states) {
        if (pos == m) {
            states.add(curr);
            return;
        }

        for (int color = 1; color <= 3; color++) {
            if (pos > 0 && ((curr >> (2 * (pos - 1))) & 3) == color) continue;
            generateStates(m, pos + 1, curr | (color << (2 * pos)), states);
        }
    }

    private boolean isCompatible(int a, int b, int m) {
        for (int i = 0; i < m; i++) {
            int colorA = (a >> (2 * i)) & 3;
            int colorB = (b >> (2 * i)) & 3;
            if (colorA == colorB) return false;
        }
        return true;
    }
}
