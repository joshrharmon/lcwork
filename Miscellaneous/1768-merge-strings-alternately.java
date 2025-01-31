class Solution {
    public String mergeAlternately(String word1, String word2) {
        String merged = "";
        int longestLen = Math.max(word1.length(), word2.length());

        for(int i = 0; i < longestLen; i++) {
            if(i < word1.length()) {
                merged += word1.substring(i, i + 1);
            }
            if(i < word2.length()) {
                merged += word2.substring(i, i + 1);
            }
        }
        return merged;
    }
}