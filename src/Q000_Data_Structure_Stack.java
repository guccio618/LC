public class Q000_Data_Structure_Stack extends RuntimeException {
	
	/************   定义和生成   ************/
	public static final int CAPACITY = 1024; // 数组的默认容量
	protected int capacity;                  // 数组的实际容量
	protected Object[] S;
	protected int top = -1;
	
	public Q000_Data_Structure_Stack() {
		this(CAPACITY);
	}

	public Q000_Data_Structure_Stack(int cap) {
		capacity = cap;
		S = new Object[capacity];
	}

	
	/************   基本操作   ************/
	public int getSize() {
		return (top + 1);
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	public void push(Object obj) throws ExceptionStackFull {
		if (getSize() == capacity) {
			throw new ExceptionStackFull("error: overflow");
		}
		S[++top] = obj;
	}

	public Object top() throws ExceptionStackEmpty {
		if (isEmpty()) {
			throw new ExceptionStackEmpty("error: stack is empty");
		}
		return S[top];
	}

	public Object pop() throws ExceptionStackEmpty {
		Object elem;
		if (isEmpty()) {
			throw new ExceptionStackEmpty("error: stack is empty");
		}
		elem = S[top];
		S[top--] = null;
		return elem;
	}

	/************   应用   ************/
	// (1).翻转数组
	public static int[] ReverseArray(int[] a) {  
		int[] b = new int[a.length];
		Stack_Array sa = new Stack_Array(a.length);
		for (int i = 0; i < a.length; i++)
			sa.push(a[i]);
		for (int i = 0; i < a.length; i++)
			b[i] = (int) sa.pop();
		return b;
	}

	// (2). 匹配括号
	public static boolean ParenMatch(String str) {
		Stack_Array sa = new Stack_Array(str.length());
		for (int i = 0; i < str.length(); i++) {           //只要是左边的括号就入栈
			if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
				sa.push(str.charAt(i));
			} else if (str.charAt(i) == ')') {   //如果是右边的括号，则弹出栈顶的元素进行匹配
				if (sa.isEmpty())
					return false;
				if ((char) sa.pop() == '(')
					continue;
				else
					return false;
			} else if (str.charAt(i) == ']') {
				if (sa.isEmpty())
					return false;
				if ((char) sa.pop() == '[')
					continue;
				else
					return false;
			} else if (str.charAt(i) == '}') {
				if (sa.isEmpty())
					return false;
				if ((char) sa.pop() == '{')
					continue;
				else
					return false;
			}
		}
		if (sa.isEmpty())
			return true;
		else
			return false;
	}
}
