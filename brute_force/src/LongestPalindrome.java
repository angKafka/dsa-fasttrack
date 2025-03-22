public class LongestPalindrome {
    //O(N^2)
    public static String longestPalindrome(String s) {
        if (s.isEmpty()) return s;

        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            for(int j = i ; j < s.length(); j++){
                String sub = s.substring(i, j + 1);
                if(isPalindrome(sub) && sub.length() > longestPalindrome.length()){
                    longestPalindrome = sub;
                }
            }
        }
        return longestPalindrome;
    }

    //O(N)
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "babad";

        //Total time complexity: O(N^3)
        System.out.println(longestPalindrome(s));
    }
}
