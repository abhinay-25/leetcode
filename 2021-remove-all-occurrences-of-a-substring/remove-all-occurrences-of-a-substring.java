class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder result = new StringBuilder(s);

        int idx = result.indexOf(part);

        while(idx != -1){
            result.delete(idx, idx + part.length());
            idx = result.indexOf(part);
        }

        return result.toString();
    }
}