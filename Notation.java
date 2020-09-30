
public class Notation {
	
	
	Notation(){
		
	}
	
	/**
	 * Convert an infix expression into a postfix expression
	 * @param postfixExpr
	 * @return the evaluation of the post fix expression
	 * @throws InvalidNotationFormatException
	 * @author oherr
	 */
	
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException
	{
		 NotationStack<Double> evaluate = new NotationStack<Double>();
		 double value1 = 0;
		 double value2 = 0;
		
		for (int i = 0; i < postfixExpr.length(); i++)
		{
			char c = postfixExpr.charAt(i);
			
			if (Character.isDigit(c))
			{
				try {
				evaluate.push((double) (c - '0')); }
				catch(StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
			
			
			if (isAnOperator(c))
			{
			try {
					value1 = evaluate.pop();
					value2 = evaluate.pop();  
				}
				
				catch(StackUnderflowException e)
				{
					throw new InvalidNotationFormatException();
				}
			try {
				switch(c) {
				case '+': evaluate.push(value2 + value1);
				break;
				case '-': evaluate.push(value2 - value1);
				break;
				case '*': evaluate.push (value2 * value1);
				break;
				case '/':evaluate.push(value2 / value1);
				break;    } } 
			catch(Exception e) {
				throw new InvalidNotationFormatException();
			}
			
			}
		}
			
		try {
			return evaluate.pop();
		}

			
		catch(StackUnderflowException e) {
			throw new InvalidNotationFormatException(); 
		}
			
		
	}
	
	/**
	 *Convert the Postfix expression to the Infix expression
	 * @param postfix
	 * @return result
	 * @throws InvalidNotationFormatException
	 * @author oherr
	 */
	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException
     {
		NotationStack<String> stack = new NotationStack<String>(50);
		StringBuilder sb = new StringBuilder();
		String string1 = "";
		String string2 = "";
		String infix = "";
		
		for (int i = 0; i < postfix.length(); i++)
		{
			char c = postfix.charAt(i);
			if(Character.isDigit(c))
			{
				stack.push(c+""); 
			}
			
			if (isAnOperator(c))
			{
					string1 = stack.pop();
					string2 = stack.pop();
					
				
			infix = "("+string2+c+string1+")";
			stack.push(infix);
			}
		}
			String result = stack.pop();
			
			return result;
	

     }
	
	/**
	 * Convert an infix expression into a postfix expression
	 * @param infix
	 * @return postfix equation
	 * @throws InvalidNotationFormatException
	 * @author oherr
	 */
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException
     {
		NotationQueue<Character> postfixQueue = new NotationQueue<Character>(50);
		NotationStack<Character> stack = new NotationStack<Character>(50);

		try { 
			
		for (int i = 0; i < infix.length(); i++)
		{
			char c = infix.charAt(i);
			if(Character.isDigit(c))
			{
				postfixQueue.enqueue(c);
			}
			
			if (c == '(' )
			{
				stack.push(c);
			}
			
			if (isAnOperator(c))
			{
				if (orderOfPrecedence(c) <= orderOfPrecedence(stack.top()) && isAnOperator(stack.top()))
				{
					postfixQueue.enqueue(stack.pop());
				}
				
				stack.push(c);
			}
			
			if (c == ')')
			{
				if(!stack.contains('('))
				{
					throw new InvalidNotationFormatException();
				}
				
				
				while(stack.top() != '(')
				{
					postfixQueue.enqueue(stack.pop());
				}
				
				stack.pop();
			}
		}
		}
		catch (Exception e)
		{
			throw new InvalidNotationFormatException();
		}
		
		try {
		while(!stack.isEmpty())
		{
			postfixQueue.enqueue(stack.pop());
		}
		
		}
		catch(Exception e)
		{
			throw new InvalidNotationFormatException();
		}
			
			return postfixQueue.toString();
     }

	/**
	 * Checks to see what the order of an operation is
	 * @param c
	 * @return the order of operation 
	 * @author oherr
	 */
	public static int orderOfPrecedence(char c) {
		switch(c){
		
		case '+': return 0;
		case '-': return 0;
		case '*': return 1;
		case '/': return 1;
		
		default : return 0;}
		}
	
	/**
	 * check to see if a character is an operator
	 * @param c
	 * @return true if character is an operator, false if not.
	 */
	public static boolean isAnOperator(char c){
		if (c == '+' || c == '-' || c == '*' || c == '/')
		
			return true;
		
		
		else return false; 
	

	}
}