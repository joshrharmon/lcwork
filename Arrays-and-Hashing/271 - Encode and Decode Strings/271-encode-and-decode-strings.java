public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s : strs) {
        	encoded.append(stringToByteChunk(s) + s);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList<String> decoded = new ArrayList<>();
        int i = 0, sLen = s.length();
        while(i < sLen) {
        	int chunkLen = byteChunkToString(s.substring(i, i + 4));
        	decoded.add(s.substring(i + 4, i + 4 + chunkLen));
        	i += (chunkLen + 4);
        }
        return decoded;
    }
    
    // Takes as input only the 4-byte part of the string and returns int
    public int byteChunkToString(String s) {
    	int sLen = 0;
		for(char c : s.toCharArray()) {
			sLen = (sLen << 8) + (int)c;
		}
		return sLen;
    }
    
    // Takes as input an element of the array containing the string
    public String stringToByteChunk(String s) {
    	int sLen = s.length();
    	char[] byteSize = new char[4];
    	for(int i = 3; i > -1; --i) {
    		byteSize[3 - i] = (char) (sLen >> (i * 8) & 0xff);
    	}
    	return new String(byteSize);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
