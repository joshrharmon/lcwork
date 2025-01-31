/*
 * ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 10, 6, 9, 3, + => 10, 6, 12
 * 10, 6, 12, -11, * => 10, 6, -132
 * 10, 6, -132, / => 10, 0
 * 10, 0, * => 0
 * 0, 17, + => 17
 * 17, 5, + => 22
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> sequence = new ArrayDeque<>();
        int op1, op2;
        for(String s : tokens)
        {
        	switch(s)
        	{
        		case "+":
        			op2 = sequence.pop();
        			op1 = sequence.pop();
        			sequence.push(op1 + op2);
        			break;
        		case "-":
					op2 = sequence.pop();
        			op1 = sequence.pop();
        			sequence.push(op1 - op2);
        			break;
        		case "*":
        			op2 = sequence.pop();
        			op1 = sequence.pop();
        			sequence.push(op1 * op2);
        			break;
        		case "/":
        			op2 = sequence.pop();
        			op1 = sequence.pop();
        			sequence.push(op1 / op2);
        			break;
        		default:
        			sequence.push(Integer.valueOf(s));
        			break;
        	}
        }
        return sequence.peek();
    }
}
