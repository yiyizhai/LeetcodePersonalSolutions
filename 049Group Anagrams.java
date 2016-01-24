public class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rlst = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0)
            return rlst;
        
        Arrays.sort(strs);
        int len = strs.length;
       
        HashMap<String,ArrayList<String>> htable = new HashMap<String,ArrayList<String>>();
       
        for(int i = 0; i<len; i++){
           // System.out.println(strs[i]);
            String ss = sorted(strs[i]);
            ArrayList<String> al = htable.get(ss);
            if(al == null){
                al = new ArrayList<String>();
                al.add(strs[i]);
                htable.put(ss,al);
            }
            else
                al.add(strs[i]);
        }
        
        Set<String> keys = htable.keySet();
        String[] ks = keys.toArray(new String[0]);
        
        for(int i = ks.length-1; i >= 0; i--)
            rlst.add(htable.get(ks[i]));
        return rlst;
    }
    
    public String sorted(String s){
        if(s==null) return null;
        char[] sn = s.toCharArray();
        Arrays.sort(sn);
        return new String(sn);
    }
    
}