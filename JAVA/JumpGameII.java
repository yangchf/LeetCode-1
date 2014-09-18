// O(n^2) time
public class Solution {
    public int jump(int[] A) {
        if (A.length < 2) return 0;
        int target = A.length;
        int count = 0;
        while (target > 1) {
            int temp = jumpHelper(A, target);
            if (temp == target) return 0;
            target = temp;
            count++;
        }
        return count;
    }
    
    private int jumpHelper(int[] A, int target) {
        int step = A[0];
        if (step >= target) return 0;
        for (int i = 1; step > 0; i++) {
            if (i + step >= target) {
                target = i;
                break;
            }
            step = Math.max(step - 1, A[i]);
        }
        return target;
    }
}

// O(n) time and O(n) space
public class Solution {
    public int jump(int[] A) {
        int n = A.length;
        if (n == 1) return 0;
        int[] res = new int[n];
        int step = A[0], index = Math.min(A[0], n - 1);
        if (index == n - 1) return 1;
        res[index] = 1;
        for (int i = 1; step > 0; i++) {
            if (i < index)
                res[i] = res[index];
            step = Math.max(step - 1, A[i]);
            if (i == index) {
                index = Math.min(i + step, n - 1);
                res[index] = res[i] + 1;
                if (index == n - 1) break;
            }
        }
        return res[n - 1];
    }
}