class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            mapS.put(ch,mapS.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            mapT.put(ch,mapT.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!mapS.get(ch).equals(mapT.get(ch))){
                return false;
            }else{
                continue;
            }
        }
        
        return true;
    }
}