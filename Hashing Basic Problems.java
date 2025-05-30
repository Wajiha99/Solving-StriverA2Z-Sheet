3)Hashing :
1)Frequencies of limited range array : 
Brute Force Approach : TC : O(N) & SC : O(N)
    class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public List<Integer> frequencyCount(int[] arr) {
        // do modify in the given array
        int n = arr.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=1;i<=n;i++){
            hm.put(i,0);
        }
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                int f = hm.get(arr[i]);
                hm.put(arr[i],f+1);
            }
        }
      ArrayList<Integer> al = new ArrayList<>(hm.values());
      return al;
    }
}
                                 OR
class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // do modify in the given array\
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<N;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
             }
             else{
                 hm.put(arr[i],1);
             }
        }
    for(int i=0;i<arr.length;i++){
        arr[i] = 0;
    }
    for(Map.Entry<Integer,Integer> e : hm.entrySet()){
        if(e.getKey()<=N){
         arr[e.getKey()-1] = e.getValue();   
        }
    }
    }
}
Space Optimised Approach : TC : O(N) & SC : O(1)
To understand this problem even better do check it out at my medium account(https://medium.com/@wajiha25/problem-from-striver-a2z-sheet-topic-hashing-gfg-easy-level-bdf860a2c2ed)

class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // do modify in the given array
       
       P++;
        for(int i=0;i<N;i++){
            int idx = arr[i]%P-1;
            if(idx >= 0 && idx < N){
                arr[idx] = arr[idx] + P;
            }
        }
        for(int i=0;i<N;i++){
            arr[i] = arr[i] / P;
        }
    }
}
2)Highest/Lowest Frequency :
import java.util.*;
public class Solution {
    public static int[] getFrequencies(int []v) {
        // Write Your Code Here
        int[] ans = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = v.length;
        //Storing array elements into a hashmap
        for(int i=0;i<n;i++){
            if(hm.containsKey(v[i])){
                int f = hm.get(v[i]);
                hm.put(v[i],f+1);
            }
            else{
                hm.put(v[i],1);
            }
        }
        int maxEle = 0;
        int minEle = 0;
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> e : hm.entrySet()){
          int count = e.getValue();
           if (count > maxFreq) {
                maxEle = e.getKey();
                maxFreq = count;
            }
            if (count < minFreq) {
                minEle = e.getKey();
                minFreq = count;
            }
            if(count == minFreq){
                minEle = Math.min(e.getKey(),minEle);
            }
            if(count == maxFreq){
                maxEle =Math.min(e.getKey(),maxEle);
            }

        }
        ans[0] = maxEle;
        ans[1] = minEle;
        return ans;
    }
}
