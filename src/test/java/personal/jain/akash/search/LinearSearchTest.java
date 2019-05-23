package personal.jain.akash.search;

import org.junit.Before;
import org.junit.BeforeClass;

import personal.jain.akash.search.impl.LinearSearch;


public class LinearSearchTest extends BaseSearchTest{

	@BeforeClass
	public static void setup() {
		BaseSearchTest.setup("search.linear.elements");
	}
	
	@Before
	public void beforeEach() {
		search = new LinearSearch();
		this.intArray = INT_ARRAY;
	}
}
