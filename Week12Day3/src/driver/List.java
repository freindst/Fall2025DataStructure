package driver;

//signature
//definition
//interface only declare the definition of the class methods without the implementation. you will have to implement on your own
//inheritance, you can only inherit from one parent class, but you can have multiple interface
public interface List<T> {
	
	public int GetLength();
	
	public T Get(int index);
	
	public void Prepend(T data);
	
	public void Append(T data);
	
	public boolean InsertAt(int index, T data);
	
	public boolean RemoveAt(int index);
	
	public int Search(T data);
	
	public void Sort(boolean Assending);

}
