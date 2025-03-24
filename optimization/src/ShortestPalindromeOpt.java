public class ShortestPalindromeOpt {
    public static String shortestPalindrome(String s) {
        if(s.isEmpty()) return "";
        String rev = reverse(s);
        String combined = s + "#" + rev;
        int[] lps = buildLPS(combined);
        int palindromeLength = lps[combined.length()-1];
        String suffix = s.substring(palindromeLength);
        String prefix = reverse(suffix);
        return prefix+s;
    }


    //build LPS
    private static int[] buildLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1, len = 0;
        while(i < n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    //reverse
    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while(i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}
