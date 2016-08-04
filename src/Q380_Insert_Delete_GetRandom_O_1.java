import java.util.ArrayList;
import java.util.HashMap;


public class Q380_Insert_Delete_GetRandom_O_1 {
	// by other
	private ArrayList<Integer> positions;
    private HashMap<Integer, Integer> numbers;
    private java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public Q380_Insert_Delete_GetRandom_O_1() {
        positions = new ArrayList<Integer>();
        numbers = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(numbers.containsKey(val)){
            return false;   
        } 
        
        numbers.put(val, positions.size());
        positions.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!numbers.containsKey(val)){ 
            return false;
        }
        
        int pos = numbers.get(val);
        
        if (pos < positions.size() - 1) { // not the last one than swap the last one with this val
            int lastElement = positions.get(positions.size() - 1 );
            positions.set(pos, lastElement);
            numbers.put(lastElement, pos);
        }
        
        numbers.remove(val);
        positions.remove(positions.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return positions.get(rand.nextInt(positions.size()));
    }
}
