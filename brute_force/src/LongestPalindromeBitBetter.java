public class LongestPalindromeBitBetter {

    //O(N)
    public static String longestPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1) return s;

        String longestPalindrome = "";
        for(int i = 0; i < s.length(); i++) {
            String oddLength = expandFromCenter(s,i,i);

            if(oddLength.length() > longestPalindrome.length()) {
                longestPalindrome = oddLength;
            }

            String evenLength = expandFromCenter(s,i,i+1);
            if(evenLength.length() > longestPalindrome.length()) {
                longestPalindrome = evenLength;
            }
        }

        return longestPalindrome;
    }

    //O(N)
    private static String expandFromCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left+1, right);
    }

    public static void main(String[] args) {
        String s = "babad";

        //Total time complexity: O(N^2)
        System.out.println(longestPalindrome(s));
    }
}
