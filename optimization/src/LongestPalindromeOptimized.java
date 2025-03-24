public class LongestPalindromeOptimized {

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) return "";

        // Step 1: Transform the string
        String transformed = transform(s);
        int n = transformed.length();
        int[] P = new int[n]; // Array to store palindrome radii
        int C = 0, R = 0;     // Center and right boundary
        int maxLen = 0, centerIndex = 0;

        // Step 2: Process the transformed string
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * C - i;  // Mirror index of i

            // Step 3: Use previous values if within bounds
            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }

            // Step 4: Try expanding the palindrome
            while (i + P[i] + 1 < n && i - P[i] - 1 >= 0 && transformed.charAt(i + P[i] + 1) == transformed.charAt(i - P[i] - 1)) {
                P[i]++;
            }

            // Step 5: Update Center and Right if we expand beyond R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

            // Step 6: Keep track of the longest palindrome
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        // Step 7: Extract the original substring
        int start = (centerIndex - maxLen) / 2;  // Remove '#' effect
        return s.substring(start, start + maxLen);
    }

    private static String transform(String s) {
        StringBuilder sb = new StringBuilder("#");
        for(char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        return sb.toString();
    }




    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
