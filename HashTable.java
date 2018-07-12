// ********************************************************
// Hash table implementation.
// Assumption: A table contains unique items(at most one 
//             item with a given search key at any time)
// *********************************************************

public class HashTable<K, V> implements HashTableInterface<K, V> 
{
	  private ChainNode[] table;     // hash table
	  private int size = 0;          // size of ADT table
	
	  public HashTable() {
	    table = new ChainNode[3];
	  }  // end default constructor
	
	// table operations
	  public boolean tableIsEmpty() {
	    return size==0;
	  }  // end tableIsEmpty
	
	  public int tableLength() {
	    return size;
	  }  // end tableLength


	//implement the following 4 methods
	public void tableInsert(K key, V value) throws HashException
	{
		//use Horner's rule to map the key (the String) to an integer, which will be the index of where the value will go in table
		int index = getIndex(key);
		//now that you have the index of where it will go, you add the value to beginning of chain node
		if(tableIsEmpty()) {
			ChainNode newNode = new ChainNode(key, value, null);
			table[index]= newNode;
		}
		else {
			ChainNode node = table[index];
			ChainNode newNode = new ChainNode(key, value, node);
		}
	}
	
	public boolean tableDelete(K searchKey)
	{
		int index = getIndex(searchKey);
		boolean found = false;
		ChainNode search = table[index];
		ChainNode delete = table[index];
		while(search != null && !found) {
			if(search.getKey().equals(searchKey)) {
				found = true;
				//found key, now delete
				delete.setNext(search.getNext());
			}
			delete = search;
			search = search.getNext();
		}
		return found;
	}
	
	public V tableRetrieve(K searchKey)
	{
		int index = getIndex(searchKey);
		boolean found = false;
		ChainNode search = table[index];
		V node = (V) table[index].getValue();
		while(search != null && !found) {
			if(search.getKey().equals(searchKey)) {
				found = true;
				node = (V) search.getValue();
			}
			search = search.getNext();
		}
		return node;
	}
	
	public int hashIndex(K key)
	{
		return getIndex(key);
	}
	
	private int getIndex(K key)
	{ 
		int r = 0;
		String theKey = (String) key;
		theKey = theKey.toLowerCase();
		for(int i = 0; i < theKey.length(); i++) {
		   	char c = theKey.charAt(i);
			int k = c - 'a' + 1;
			r = r + (k << (5*i));
		}
		return r % table.length;
	}
}
