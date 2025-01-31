import java.util.StringTokenizer;

class Solution {
    public String reverseWords(String s) {
		String reversed = "";
        ArrayList<String> tokens = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(s.trim(), " ");
		
		while(tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}
		
		for(int i = tokens.size() - 1; i >= 0; i--) {
			reversed += tokens.get(i) + " ";
		}
		
		return reversed.trim();
    }
}
