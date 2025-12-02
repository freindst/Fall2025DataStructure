package driver;

//this is the state of the data on the hash table using linear probing to resolve conflicts
public enum State {
	EMPTY_SINCE_START,
	EMPTY_AFTER_REMOVAL,
	FULL
}
