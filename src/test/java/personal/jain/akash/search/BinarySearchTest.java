package personal.jain.akash.search;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import personal.jain.akash.search.impl.BinarySearch;
import personal.jain.akash.testdata.TestDataReader;

public class BinarySearchTest extends BaseSearchTest{
	
	private static TestDataReader testDataReader;
	
	@BeforeClass
	public static void setup() throws JsonParseException, JsonMappingException, IOException {
		testDataReader = new TestDataReader("tests-search-binary.json");
	}
	
	@Before
	public void beforeEach() {
		search = new BinarySearch();
		testsList = testDataReader.getTestsList();
	}
}
