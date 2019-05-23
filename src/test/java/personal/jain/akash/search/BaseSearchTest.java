package personal.jain.akash.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

import personal.jain.akash.search.api.ISearch;
import personal.jain.akash.testdata.TestDataReader;

public abstract class BaseSearchTest {

	static Integer[] INT_ARRAY = {}; 
	static void setup(String propertyName) {
		try {
			String dataString = (String)TestDataReader.getInstance().get(propertyName);		
			INT_ARRAY = Arrays.asList(dataString.split(","))
				.stream().map(item -> Integer.parseInt(item))
				.collect(Collectors.toList()).toArray(INT_ARRAY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected ISearch search;
	protected Integer[] intArray = null;
	@Test
    public void isPresentShouldReturnFalse()
    {
        assertFalse(search.isPresent(null, 12));

		assertFalse(search.isPresent(intArray, 458));
    }
	
	@Test
    public void isPresentShouldReturnTrue()
    {
        assertTrue(search.isPresent(intArray, 566));
    }
	
	@Test
    public void findShouldReturnMinusOne()
    {
        assertEquals(-1,search.find(null, 12));
        
		assertEquals(-1,search.find(intArray, 458));
    }
	
	@Test
    public void findShouldReturnCorrectValue()
    {
		assertEquals(3,search.find(intArray, 566));
    }
}
