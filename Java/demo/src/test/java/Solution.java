class Solution {
    public String toLowerCase(String s) {
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z'){
                s.charAt( i) -=32 ;
            }
        }
    }
}