public class Solution {
    public String removeDuplicateLetters(String s) {
    if(s.length()==0)
        return "";
    int pos = 0;//the smallest s[i]
    int[] cnt = new int[26];
    for(int i = 0; i < s.length(); i++){
         cnt[s.charAt(i) - 'a']++;
    } 

    for(int j = 0; j<s.length();j++){
        if(s.charAt(j)<s.charAt(pos))
                pos = j;
        cnt[s.charAt(j) - 'a']--;
            if(cnt[s.charAt(j) - 'a'] == 0)
                break;
        }

           return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}