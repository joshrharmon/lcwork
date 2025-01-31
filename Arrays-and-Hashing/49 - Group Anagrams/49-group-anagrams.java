class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<ArrayList<String>> anagrams = new ArrayList<ArrayList<String>>();
        if(strs.length > 0)
        {
        	if(strs.length == 1)
        	{
        		ArrayList<String> temp = new ArrayList<>();
        		temp.add(strs[0]);
        		anagrams.add(temp);
        	}
        	else
        	{
        		HashMap<String, ArrayList<String>> wordLoc = new HashMap<>();
        		for(String s : strs)
        		{
        			char[] ca = s.toCharArray();
        			StringBuilder sb = new StringBuilder();
        			Arrays.sort(ca);
        			sb.append(ca);
					if(wordLoc.containsKey(sb.toString()))
					{
                        ArrayList<String> temp = wordLoc.get(sb.toString());
                        temp.add(s);
						wordLoc.put(sb.toString(), temp);
					}
					else
					{
						wordLoc.put(sb.toString(), new ArrayList<>(Arrays.asList(s)));
					}
        		}
        		
        		for(ArrayList<String> arr : wordLoc.values())
        		{
        			anagrams.add(arr);
        		}
        	}
        }
        return anagrams;
    }
}
