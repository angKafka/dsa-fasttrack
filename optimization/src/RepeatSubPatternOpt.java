public class RepeatSubPatternOpt {
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = buildLPS(s);
        int len = lps[n - 1];
        return len > 0 && (n % (n - len)) == 0;
    }


    /*build LPS*/
    private static int[] buildLPS(String s){
        int n = s.length();
        int[] lps = new int[n];
        int i = 0, len = 0;

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
}
