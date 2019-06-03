package personal.jain.akash.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import personal.jain.akash.search.api.ISearch;
import personal.jain.akash.testdata.ISingleTestData;

public abstract class BaseSearchTest {
	
	protected ISearch search;
	protected List<ISingleTestData<Integer>> testsList;
	
	@Test
	public void runIsPresentTests() {
		assertNotNull("tests list is null", testsList);
		assertTrue("tests list is empty" ,testsList.size() > 0);
		
		testsList.forEach(item -> { BaseSearchTest.runIsPresentTest(search, item);});
	}
	
	@Test
	public void runFindTests() {
		assertNotNull("tests list is null", testsList);
		assertTrue("tests list is empty" ,testsList.size() > 0);
		
		testsList.forEach(item -> { BaseSearchTest.runFindTest(search, item);});
	}
	
	private static void runIsPresentTest(ISearch search, ISingleTestData<Integer> testData) {
		if(testData.getIndex() > -1) {
			assertTrue(search.isPresent(testData.getArray(), testData.getItem()));
		} else {
			assertFalse(search.isPresent(testData.getArray(), testData.getItem()));
		}
	}
	
	private static void runFindTest(ISearch search, ISingleTestData<Integer> testData) {
		assertEquals(testData.getIndex(), search.find(testData.getArray(), testData.getItem()));			
	}
	
	@Test
    public void isPresentShouldReturnFalseForNullArray()
    {
        assertFalse(search.isPresent(null, 12));
    }
	
	@Test
    public void findShouldReturnMinusOneForNullArray()
    {
        assertEquals(-1,search.find(null, 12));
    }
}
