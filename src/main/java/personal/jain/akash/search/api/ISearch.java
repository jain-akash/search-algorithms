package personal.jain.akash.search.api;

public interface ISearch {
	public <G extends Comparable<? super G>> boolean isPresent(G[] arr, G item);
	public <G extends Comparable<? super G>> int find(G[] arr, G item);
}
