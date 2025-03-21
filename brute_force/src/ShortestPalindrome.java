public class ShortestPalindrome {
    public static String shortestPalindrome(String s){
        int n = s.length();
        StringBuilder prefix = new StringBuilder();

        for (int i = n-1; i >=0 ; i--) {
            if (isPalindrome(s.substring(0,i+1))) {
                break;
            }
            prefix.append(s.charAt(i));
        }

        return prefix+s;
    }

    private static boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aacecaaaa";
        System.out.println(shortestPalindrome(s));
    }
}
