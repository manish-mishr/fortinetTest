class MultiDimensionArray {
    // This is a provided function, Assume it works
    public static Long getValue(int... indexOfDimension) {
        //... 
        return value;
    }
    // lengthOfDeminsion: each dimension's length, assume it is valid: lengthOfDeminsion[i]>0.
    public static Long sum(MultiDimensionArray mArray, int[] lengthOfDeminsion) { 
   // Initialize sum to 0 and Iterate through each array within larger array and sum those values together to return the result value
   // O(mn)  As I am accessing all the element once. So, overall time complexity would be O(mn) where m is length of larger array and average length of contain array is n.
   // Space complexity: O(1) as I am using only constant space.

      long sumVal = 0;
      for(int i=0; i<mArray.length; ++i){
        for(int j=0; j<mArray[i].length; ++j){
          sumVal += getValue(mArray,i,j).longValue();
        }
      }

    
    return new Long(sumVal);
    }

}