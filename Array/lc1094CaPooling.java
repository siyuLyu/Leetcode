import java.util.*;
class Solution {
    //method1:
    //time : O(m*n) m is the length of trips, n is the max length in between start location to end
    //space: O(n) n is the largest end location 
    public static boolean carPooling(int[][] trips, int capacity) {
        // sort by end location
        Arrays.sort(trips,(a,b)->(a[2]-b[2]));
        //create array with the length of largest endLocation
        int[] passengers = new int[trips[trips.length-1][2]];
       
        for (int i = 0; i < trips.length; i++) {
            int start = trips[i][1];
            int end = trips[i][2];
             // add passengers accordingly from start location to end location
            for (int j = start-1; j < end; j++) {
               passengers[j] += trips[i][0];
            }
            //remove passengers when they hop-off
            passengers[end-1] -= trips[i][0];
        }
        
        //iterate through to check weather exeed the capacity or not
        for (int n: passengers) {
            if (n > capacity){
                return false;
            }
        }
        return true;
    }
    // Method2:
    // Time O(n) n represent max(1001, trip.length);
    // Space O(n) n represent 1001
    public static boolean carPooling2(int[][] trips, int capacity) {
        //create array in the max length of possible end location 
        int[] endLoc = new int[1001];
        
        for (int[] t: trips) {
            int p = t[0];
            //plus when passenger hop in
            endLoc[t[1]] += p;
            //subtruct when customer hop off
            endLoc[t[2]] -= p;
            
        }
        
        int c = 0;
        //compare weather exceed mac capacity or not
        for(int n: endLoc) {
            c += n;
            if(c > capacity) {
                return false;
            }
        }
        
        return true;
        
    }
    public static void main(String[] argv) {
        int[][] arr = {{2,1,5},{3,3,7}};
        System.out.println(carPooling(arr, 4));
        System.out.println(carPooling2(arr, 4));
    }
}