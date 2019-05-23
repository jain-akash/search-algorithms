package personal.jain.akash.search;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import personal.jain.akash.search.impl.BinarySearch;

public class BinarySearchTest extends BaseSearchTest{
	
	@BeforeClass
	public static void setup() {
		BaseSearchTest.setup("search.binary.elements");
	}
	
	@Before
	public void beforeEach() {
		search = new BinarySearch();
		this.intArray = INT_ARRAY;
	}
		
	@Test
	public void findShouldReturnCorrectValueExtremeRightBoundary() {
		assertEquals(7, search.find(intArray, 55454));
	}
	
	@Test
	public void findShouldReturnCorrectValueExtremeLeftBoundary() {
		assertEquals(0, search.find(intArray, 10));
	}
	
	@Test
	public void findShouldReturnCorrectValueMiddle() {
		assertEquals(5, search.find(intArray, 634));
	}
}
