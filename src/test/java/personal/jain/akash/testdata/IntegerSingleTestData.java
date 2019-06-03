package personal.jain.akash.testdata;

public class IntegerSingleTestData implements ISingleTestData<Integer>{

	private Integer[] array;
	private Integer item;
	private long index;
	
	public IntegerSingleTestData(Integer[] array, Integer item, long index) {
		this.array = array;
		this.item = item;
		this.index = index;
	}
	
	public IntegerSingleTestData() {
		super();
	}
	
	@Override
	public Integer[] getArray() {
		return array;
	}

	@Override
	public Integer getItem() {
		return item;
	}

	@Override
	public long getIndex() {
		return index;
	}
	
	
}
