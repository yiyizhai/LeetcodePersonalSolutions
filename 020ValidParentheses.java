public class Solution {
    public boolean isValid(String s) {
        if(s==null) return false;
        char[] sc = s.toCharArray();
        int len = sc.length;
        if(len == 0 || len%2 !=0) return false;
        
        Stack<Character> st = new Stack<Character>();
         if(sc[0]==')' || sc[0]==']' || sc[0]=='}')
            return false;
        st.push(new Character(sc[0]));
        int i=1;
        int flag = 0;
        while(i<len){
            
            if(sc[i]=='(' || sc[i]=='[' || sc[i]=='{')
                st.push(new Character(sc[i]));
            else if(sc[i]==')') {
                char c = st.pop().charValue();
                flag = 1;
                if(c!='(') return false;
            }
            else if(sc[i]==']'){
                char c = st.pop().charValue();
                flag = 1;
                if(c!='[') return false;
            }
            else if(sc[i]=='}'){
                char c = st.pop().charValue();
                flag = 1;
                if(c!='{') return false;
            }
            else{
                return false;
            }
            i++;
        }
        if(flag == 0) return false;
        return true;
    }
}