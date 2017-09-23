
import java.io.*;
import java.util.*;

public class Kpartition{
    public static boolean backtrack(List<Integer> list, int target, boolean[] used, int[] subset, int k, int sz, int sid){

        if (subset[sid] == target){
            System.out.println("sid:  "+sid);
            ++sid;
            if(sid == k-1)
                return true;
            return backtrack(list, target, used, subset, k, sz, sid);
            }

        for(int i=0; i < sz; ++i){
            if(used[i])
                continue;
            used[i] = true;
            subset[sid] += list.get(i);
            if (backtrack(list,target,used, subset, k, sz, sid))
                return true;
            used[i] = false;
            subset[sid] -= list.get(i);
            }


            return false;
    }


    public static boolean separate(List<Integer> list, int k){
       // Your resolution: For this I am using bactracking algorithm to try to fit each element into a subset and see if results into k subset or not. I am not making any assumption whether numbers are positive or not.
       // Time complexity:  O(2^n) as I am checking for each number within list as it is a part of any subset or not. So, For every number it is binary case as it is present or not. 
       // O(n) For this I am using linear space complexity as I am using boolean array of size n, integer array of size k. So, overall space complexity is linear. 

        int sz = list.size();

        if (k == 1)   // For K =1, it is always true
            return true;
     
        
        if (sz < k)  // It is not feasible to make more than list.size() class
            return false;
     
        
        int sum = 0;
        for (Integer val: list)
            sum += val;
       
       System.out.println("sum:  "+sum);
        if (sum % k != 0)  // if sum is not divisible by k, then it is not possible
            return false;

        boolean[] used = new boolean[sz];
        int target = sum/k ;

        System.out.println("target:  "+target);
        int[] subset = new int[k];

        for (int i = 0; i < k; i++)
            subset[i] = 0;
     
        //  mark all elements as not taken
        for (int i = 0; i < sz; i++)
            used[i] = false;
     
        // initialize first subsubset sum as last element of
        // array and mark that as taken
        subset[0] = list.get(0);
        used[0] = true;

        return backtrack(list, target, used, subset, k, sz, 0);
     
    }

 public static void main(String[] args){
    List<Integer> list = new ArrayList<Integer>();
    list.add(3);
    list.add(6);
    list.add(5);
    list.add(8);
    list.add(8);

    System.out.println("possible:  "+separate(list,3));
 }

}

class KpartitionTest { 
    @Test 
    public void testKpartition(){
       List<Integer> list = new ArrayList<Integer>();
       boolean flag = Kpartition.separate(list,1);
       assertEquals(flag,false);
       list.add(4);
       
       flag = Kpartition.separate(list,1);
       assertEquals(true,flag);

        list.add(5);
        list.add(6);
        list.add(5);
        list.add(10);

        flag = Kpartition.separate(list,3);
        assertEquals(true,flag);
        
        list.add(2);
        flag = Kpartition.separate(list,4);
        assertEquals(false,flag);
        }
     }
