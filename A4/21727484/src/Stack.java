class Stack<T>  {
	private Stack<T> previous;
	private T value;
	private int capacity;

	Stack(int capacity) {
		this.capacity=capacity;
	}

	Stack(T value) {
		this.value = value;
	}

	Stack(Stack<T> previous, T value) {
		this.previous = previous;
		this.value = value;
	}

	public void push(T value) {
		this.previous = new Stack<T>(this.previous, this.value);
		this.value = value;
	}

	public T pop() {
		if (this.isEmpty())
			throw new IllegalArgumentException("Stack is empty");

		T top = this.value;
		this.value = this.previous.value;
		this.previous = this.previous.previous;

		return top;
	}


	public T top() {
		return this.value;
	}


	public boolean isEmpty() {
		return this.previous == null;
	}
	public boolean isFull() {
		return this.capacity== 1 + this.previous.size();
		
	}


	public int size() {
		return this.isEmpty() ? 0 : 1 + this.previous.size();
	}

	public int search(Object o) {
		int count = 1;

		for (Stack<T> stack = this; !stack.isEmpty(); stack = stack.previous) {
			if (stack.value.equals(o))
				return count;
			count++;
		}

		return -1;
	}
}
