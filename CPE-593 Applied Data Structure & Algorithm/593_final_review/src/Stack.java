
public class Stack {
	private int capacity;                  
	private Object[] S;
	private int top = -1;
	
	public Stack() {
		capacity = 1024;
		S = new Object[capacity];
	}

	public Stack(int cap) {
		capacity = cap;
		S = new Object[capacity];
	}

	public int getSize() {
		return (top + 1);
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	public void push(Object obj) {
		if (getSize() == capacity) {
			System.out.println("error: overflow");
			return;
		}
		S[++top] = obj;
	}

	public Object top() {
		if (isEmpty()) {
			System.out.println("error: stack is empty");
			return null;
		}
		return S[top];
	}

	public Object pop() {
		Object elem;
		if (isEmpty()) {
			System.out.println("error: stack is empty");
			return null;
		}
		elem = S[top];
		S[top--] = null;
		return elem;
	}
}
