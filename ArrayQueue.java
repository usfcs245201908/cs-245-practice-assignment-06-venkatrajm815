//This tells the compiler that the code is safe and won't cause unexpected exceptions.
@SuppressWarnings("unchecked")

public class ArrayQueue<T> implements Queue<T>
{
	T[] a = (T[]) new Object[600];
	int first = 0;
	
	//dequeue function
	public T dequeue() 
	{
		//checks if its empty and throws exception
		if(empty())
		{
			throw new RuntimeException("Queue is empty.");
		}
		//for loop to move values in array
		for(int i = 1; i <= first; i++)
		{
			a[i-1]=a[i];
		}
		first--;
		return a[0];

	}

	//enqueue function
	public void enqueue(T item)
	{
		//check if first is greater than or equal to a.length-1, if it is grow the array
		if(first >= a.length-1)
		{
			grow_Array();
		}
		a[++first]=item;

	}

	//empty function
	public boolean empty()
	{
		//returns true if first is 0, otherwise returns false
		return (first==0);
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