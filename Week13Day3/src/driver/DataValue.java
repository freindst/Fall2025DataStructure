package driver;

public class DataValue {
	public enum State{
		EMPTY_SINCE_START,
		EMPTY_AFTER_REMOAL,
		FULL
	}
	
	public int Value;
	public State state;
	
	public DataValue() {
		this.Value = 0;
		this.state = State.EMPTY_SINCE_START;
	}
}
