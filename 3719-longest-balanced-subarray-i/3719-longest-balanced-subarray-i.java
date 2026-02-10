class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;
        
        int MAX = 100000;
        
        boolean[] seenEven = new boolean[MAX + 1];
        boolean[] seenOdd  = new boolean[MAX + 1];

        for (int i = 0; i < n; i++) {
            int evenCount = 0;
            int oddCount  = 0;

            int[] touched = new int[n];
            int touchedSize = 0;

            for (int j = i; j < n; j++) {
                int v = nums[j];
                if ((v % 2) == 0) {
                    if (!seenEven[v]) {
                        seenEven[v] = true;
                        evenCount++;
                        touched[touchedSize++] = v;
                    }
                } else {
                    if (!seenOdd[v]) {
                        seenOdd[v] = true;
                        oddCount++;
                        touched[touchedSize++] = -v; 
                    }
                }

                if (evenCount == oddCount) {
                    ans = Math.max(ans, j - i + 1);
                }
            }

            for (int k = 0; k < touchedSize; k++) {
                int x = touched[k];
                if (x >= 0) {
                    seenEven[x] = false;
                } else {
                    seenOdd[-x] = false;
                }
            }
        }
        
        return ans;
    }
}
