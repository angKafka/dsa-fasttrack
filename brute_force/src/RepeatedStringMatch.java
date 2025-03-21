public class RepeatedStringMatch {
    public static int repeatedStringMatch(String a, String b){
        StringBuilder sb = new StringBuilder();
        int minCount = 0;

        while(sb.length() < b.length()){
            sb.append(a);
            minCount++;
        }

        if(isSubstring(sb.toString(), b)){
            return minCount;
        }

        sb.append(a);
        minCount++;

        if(isSubstring(sb.toString(), b)){
            return minCount;
        }

        return -1;
    }

    private static boolean isSubstring(String a, String b){
        int n = a.length();
        int m = b.length();

        for(int i = 0; i <= n-m; i++){
            int j;
            for(j = 0; j < m; j++){
                if(a.charAt(i+j) != b.charAt(j)) break;
            }

            if(j == m) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String a = "abcd", b = "cdabcdab";
        System.out.println(repeatedStringMatch(a, b));
    }
}
