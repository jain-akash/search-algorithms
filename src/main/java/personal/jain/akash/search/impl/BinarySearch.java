package personal.jain.akash.search.impl;

import personal.jain.akash.search.api.ISearch;

public class BinarySearch implements ISearch {

	private <G extends Comparable<? super G>> int recursiveFind(G[] arr, G item, int start, int end) {
		if(start > end )
			return -1;
		int mid = start + (end - start)/2;
		if( mid >= arr.length)
			return -1;
		int compareResult = arr[mid].compareTo(item);
		if(compareResult == 0)
			return mid;
		else if(compareResult == 1)
			return recursiveFind(arr, item, start, mid - 1);
		else
			return recursiveFind(arr, item, mid + 1, end);
	}
	
	private <G extends Comparable<? super G>> int getIndex(G[] arr, G item) {		
		return recursiveFind(arr, item, 0, arr.length - 1);
	}
	
	@Override
	public <G extends Comparable<? super G>> boolean isPresent(G[] arr, G item) {
		return find(arr, item) != -1; 
	}

	@Override
	public <G extends Comparable<? super G>> int find(G[] arr, G item) {
		if(arr == null)
			return -1;
 		return getIndex(arr, item);
	}

}
