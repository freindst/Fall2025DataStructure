package driver;

public class HTChaining {
	public LinkedList[] table;
	public int size;
	
	public HTChaining(int size) {
		this.size = size;
		table = new LinkedList[size];
	}
	
	//Hashing function
	//convert the original value into the index
	public int Hashing(int value) {
		return value % size;
	}
	
	//Insert
	//first find the index? using hashing function
	//append
	public void Insert(int value) {
		int index = this.Hashing(value);
		this.table[index].Append(value);
	}
	
	//Search
	public boolean Search(int value) {
		int index = this.Hashing(value);
		return this.table[index].Search(value) != null;
	}
	
	//Delete
	//first locate the bucket by hashing
	//run the delete
	//after the delete, the hash table will not hold the value any more
	public void Delete(int value) {
		int index = this.Hashing(value);
		this.table[index].Delete(value);
	}
	
	//resize
	//how?
	public void Resize(int newSize) {
		//making a new array for the larger/resized hash table
		LinkedList[] newTable = new LinkedList[newSize];
		LinkedList[] oldTable = this.table;
		this.size = newSize;
		this.table = newTable;
		//get all the items insert into the new hash table
		for(int i = 0; i < oldTable.length; i++) {
			Node node = oldTable[i].Header;
			while(node != null) {
				//hash table insert will help us re-hash
				this.Insert(node.Payload);
				node = node.NextNode;
			}
		}
	}
}
