class Solution {
    public boolean isValid(String s) {
        HashSet<Character> open = new HashSet<>() {{
            add('(');
            add('[');
            add('{');
        }};
        HashSet<Character> close = new HashSet<>() {{
            add(')');
            add(']');
            add('}');
        }};
        HashMap<Character, Character> lookup = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> pStack = new Stack<>();
        char[] parens = s.toCharArray();
        for(char c : parens)
        {
            if(open.contains(c))
            {
                pStack.push(c);
            }
            else if(close.contains(c))
            {
                if(!pStack.isEmpty())
                {
                    if(lookup.get(c) == pStack.peek())
                    {
                        pStack.pop();   
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
                
        }
        if(pStack.isEmpty())
            return true;
        return false;
    }
}
