package driver;

public class MyArrayList<T> implements List<T> {
	private T[] List;
	private int length;	//this is the size of the existed items
	private int size; //this is the list.length;
	
	//we must ensure that the size is larger than 0
	public MyArrayList(int size){
		this.List = (T[]) new Object[size]; 
		this.size = size;
		this.length = 0;
		this.Resize();
	}
	
	//if length >= 70% size, resize will double the size
	//if length <= 30% size, resize will reduce the size to be 50%
	public void Resize() {
		if (this.size < 10) {
			this.size = 10;
			T[] newList = (T[]) new Object[this.size];
			for(int i = 0; i < length; i++) {
				newList[i] = List[i];
			}
		} else if (this.length >= this.size * 10 / 7) {
			this.size = this.size * 2;
			T[] newList = (T[]) new Object[this.size];
			for(int i = 0; i < length; i++) {
				newList[i] = List[i];
			}
			this.List = newList;
		} else if (this.length <= this.size * 10 / 3) {
			this.size = this.size / 2;
			T[] newList = (T[]) new Object[this.size];
			for(int i = 0; i < this.length; i++) {
				newList[i] = this.List[i];
			}
			this.List = newList;
		}
	}

	@Override
	public int GetLength() {
		
		return this.length;
	}

	@Override
	public T Get(int index) {
		if (index < 0 || index > this.length) {
			return null;
		} else {
			return List[index];
		}
	}

	@Override
	public void Prepend(T data) {
		for(int i = this.GetLength(); i > 0; i--) {
			this.List[i] = this.List[i - 1];
		}
		this.List[0] = data;
		this.length++;
		this.Resize();
	}

	@Override
	public void Append(T data) {
		// TODO Auto-generated method stub
		//we do not need to move any times here
		this.List[this.GetLength()] = data;
		this.length++;
		this.Resize();
	}

	@Override
	public boolean InsertAt(int index, T data) {
		// if the index is out of bound, it is false
		if (index < 0 || index > this.length) {
			return false;
		} else if (index == this.length) {
			this.Append(data);
		} else if (index == 0) {
			this.Prepend(data);
		} else {
			for(int i = this.GetLength(); i > index; i--) {
				this.List[i] = this.List[i - 1];
			}
			this.List[index] = data;
			this.length++;
			this.Resize();
		}
		return true;
	}

	@Override
	public boolean RemoveAt(int index) {
		// if the index is out of bound, it is false
		if (index < 0 || index > this.length) {
			return false;
		} else {
			for(int i = index; i < this.length; i++) {
				this.List[i] = this.List[i++];
			}
			this.length--;
			this.Resize();
		}
		// otherwise, we move the item backwards
		return false;
	}

	@Override
	public int Search(T data) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//sort
}
