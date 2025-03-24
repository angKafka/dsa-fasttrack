public class FindIndFirstOccurrenceOpt {
    public static int strStr(String haystack, String needle)
    {
        int n = haystack.length();
        int m = needle.length();
        int[] lps = buildLPS(needle);
        int i = 0, j = 0;
        while (i < n) {
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }

            if(j == m){
                return i - j;
            }else if(i<n && haystack.charAt(i) != needle.charAt(j)){
                if(j != 0){
                    j = lps[j - 1];
                }else{
                    i++;
                }
            }
        }
        return -1;
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
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }
}
