public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int len = s.length();
        if(len == 0 || len == 1){
            return len;
        }
        
        int[] alphNum = new int[65536];
        int begin = 0;
        int end = 1;
        int maxLen = end - begin;
        alphNum[s.charAt(begin)] = 1;
        
        for(;begin < s.length(); begin++){
            while(end < s.length() && alphNum[s.charAt(end)] == 0){
                alphNum[s.charAt(end)] = 1;
                end++;
            }
            maxLen = Math.max(maxLen, end - begin);
            if(end >= s.length())
                break;
            alphNum[s.charAt(begin)] = 0;
        }
        return maxLen;
       
    }
}