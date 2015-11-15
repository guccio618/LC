public class Q000_Data_Structure_Queue implements Queue {
	
	/************   定义和生成   ************/
	public static final int CAPACITY = 1000; // 数组的默认容量
	protected int capacity;                  // 数组的实际容量
	protected Object[] Q;                    // 对象数组
	protected int front = 0;                 // 对首
	protected int back = 0;                  // 对尾

	public Q000_Data_Structure_Queue() {
		this(CAPACITY);
	}

	public Q000_Data_Structure_Queue(int cap) {
		capacity = cap;
		Q = new Object[capacity];
	}

	/************   基本操作   ************/
	public int getSize() {
		return (capacity - front + back) % capacity;  // 注意要mod
	}

	public boolean isEmpty() {
		return (front == back);
	}

	public void enqueue(Object obj) throws ExceptionQueueFull {
		if (getSize() == capacity - 1)
			throw new ExceptionQueueFull("Queue overflow");
		Q[back] = obj;
		back = (back + 1) % capacity;      //注意mod
	}

	public Object dequeue() {
		Object elem;
		if (isEmpty())
			throw new ExceptionQueueEmpty("error:empty queue");
		elem = Q[front];
		Q[front] = null;
		front = (front + 1) % capacity;   //注意mod
		return elem;
	}

	// 取(并不删除)队首元素
	public Object front() throws ExceptionQueueEmpty {
		if (isEmpty())
			throw new ExceptionQueueEmpty("error:empty queue");
		return Q[front];
	}

	// 遍历(不属于ADT)
	public void Traversal() {
		for (int i = front; i < back; i++)
			System.out.print(Q[i] + " ");
		System.out.println();
	}
}
