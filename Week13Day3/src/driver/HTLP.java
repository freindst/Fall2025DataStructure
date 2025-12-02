package driver;

public class HTLP {
	public DataValue[] table;
	public int size;
	
	public HTLP(int size) {
		this.table = new DataValue[size];
		for(int i = 0; i < size; i++) {
			this.table[i] = new DataValue();	//we ensure that all the default states are empty-since-start
		}
	}
	
	public int Hashing(int data) {
		return data % this.size;
	}
	
	public void Insert(int data) {
		int index = this.Hashing(data);
		if (this.table[index].state == DataValue.State.FULL) {
			if (this.table[index].Value == data) {
				//pass
			} else {
				//find the next non-empty spot
			}
		} else if (this.table[index].state == DataValue.State.EMPTY_AFTER_REMOAL || this.table[index].state == DataValue.State.EMPTY_SINCE_START) {
			this.table[index].Value = data;
		}
	}
	
	public void Delete(int data) {
		
		
	}
	
	public boolean Search(int data) {
		return false;
	}
	

}
