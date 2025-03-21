public class FindIndFirstOccurrence {
    public static int strStr(String haystack, String needle)
    {
        int n = haystack.length();
        int m = needle.length();

        for(int i = 0 ; i <= n - m ; i++){
            int j;
            for(j = 0; j < m ; j++){
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if(j == m) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";

        System.out.println(strStr(haystack, needle));
    }
}
