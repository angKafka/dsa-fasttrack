public class RepeatedStringMatchOpt {
    public static int repeatedStringMatch(String a, String b) {
        if(a.isEmpty() || b.isEmpty()) return 0;
        StringBuilder sb  = new StringBuilder();
        int count = 0;
        while(sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if(isSubstring(sb.toString(), b)){
            return count;
        }

        sb.append(a);
        count++;

        if(isSubstring(sb.toString(), b)){
            return count;
        }

        return -1;
    }

    //KMP
    private static boolean isSubstring(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[] lps = buildLPS(b);
        int i = 0, j = 0;
        while(i < n){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
                if(j == m) return true;
            }else{
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }

        return false;
    }


    /**
     * @buildLPS Constructs the Longest Prefix Suffix (LPS) array.
     *
     * @param s The input string for which the LPS array is built.
     * @return The LPS array where each index represents the length
     *         of the longest prefix which is also a suffix.
     */
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

    public static void main(String[] args) {
        String a = "a", b = "aa";
        System.out.println(repeatedStringMatch(a, b));
    }

}
