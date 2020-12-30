/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// Putcall helper function in constructor
public class NestedIterator implements Iterator<Integer> {
    List<Integer> res;
    List<NestedInteger> nestedList;
    int index;
    //Constructor: Time O(N+L) -> Number of listes + Number of Integers
    // Space: O(N+D)
    public NestedIterator(List<NestedInteger> nestedList) {
        res = new ArrayList<>();
        nestedList = nestedList;
        index = 0;
        flattern(nestedList);
        
    }
    
    public void flattern(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                res.add(nestedInteger.getInteger());
            } else {
                List<NestedInteger> tmp = nestedInteger.getList();
                flattern(tmp);
            }  
        }
         
    }

    @Override
    //Time: O(1)
    public Integer next() {
        
        if (!hasNext()) return null;
        return res.get(index++);
        
    }

    @Override
    //Time: O(1)
    public boolean hasNext() {
        return res.size() > index;
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */