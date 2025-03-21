public class RepeatSubPat {
    public static boolean repeatedSubstringPattern(String s){
        int n = s.length();
        for(int i = 1; i <= n/2; i++){
            if(n % i == 0){
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n/i; j++){
                    sb.append(sub);
                }
                if(sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }
}
