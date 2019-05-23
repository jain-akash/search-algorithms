package personal.jain.akash.search.impl;

import personal.jain.akash.search.api.ISearch;

public class LinearSearch implements ISearch {

	private <G extends Comparable<? super G>> int getIndex(G[] arr, G item) {
		int returnValue = -1;
		for( int i = 0; i<arr.length; ++i) {
			if( arr[i].compareTo(item) == 0 ) {
				returnValue = i;
				break;
			}
		}
		return returnValue;
	}
	
	@Override
	public <G extends Comparable<? super G>> boolean isPresent(G[] arr, G item) {
		return (find(arr, item) != -1);
	}

	@Override
	public <G extends Comparable<? super G>> int find(G[] arr, G item) {
		if(arr == null)
			return -1;		
		return getIndex(arr, item);
	}

}
