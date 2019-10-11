//This tells the compiler that the code is safe and won't cause unexpected exceptions.
@SuppressWarnings("unchecked")

public class ArrayStack<T> implements Stack<T>
{
	T[] a = (T[]) new Object[600];
	int top = 0;

	//push function
	public void push(T item)
	{
		//if array is full, grow the array
		if(top == a.length-1)
		{
			grow_Array();
		}
		//add item to top of the array
		a[++top] = item;

	}

	//pop function
	public T pop()
	{
		//checks if its empty and throws exception
		if(empty())
		{
			throw new RuntimeException("Stack is empty.");
		}
		return a[top--];

	}

	//peek function
	public T peek()
	{
		//checks if its empty and throws exception
		if(empty())
		{
			//throw new Exception("Empty Queue");
		}
		return a[top];

	}

	//empty function
	public boolean empty()
	{
		//returns true if first is 0, otherwise returns false
		return (top == 0);
	}

	//grow array function
	protected void grow_Array()
	{
		//creates temp array that has double the length of original array a
		//adds all elements in array a to array temp
		T[] temp = (T[]) new Object[a.length*2];
		for (int i = 0; i < a.length; i++)
		{
			temp[i] = a[i];
		}
	}
}