package string;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "sabcdcbad";
        System.out.println(lps(s,0,0));
    }
    private static String lps(String s, int start, int end){
        for(int i=0;i<s.length();i++){
            int len1=expand(s,i,i);
            int len2=expand(s,i,i+1);
            int len = Math.max(len1,len2);

            if(len > end-start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start,end+1);
        //return String.valueOf(end+1-start);
    }

    private static int expand(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
