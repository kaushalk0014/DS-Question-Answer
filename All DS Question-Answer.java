75. Sort Colors

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1

class Solution {
    public void sortColors(int[] nums) {
       int low=0, mid=0;
       int high= nums.length-1; 

       while(mid<=high){
            if(nums[mid]==0){
                int temp= nums[low];
                nums[low]= nums[mid];
                nums[mid]=temp;
                low++; mid++;
            }else if(nums[mid]==1){
                    mid++;
            }else if(nums[mid]==2){
                int temp= nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--; 
            }
       }
    }
}
--------------------------------------------------------------------------

724. Find Pivot Index
Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum=0;
        for(int i=0; i< nums.length; i++){
            totalSum=totalSum+nums[i];
        }
        int leftSum=0;
        for(int i=0; i< nums.length; i++){
            if(leftSum== (totalSum-leftSum- nums[i])){
                return i;
            }
             leftSum=leftSum+nums[i];
        }
        return -1;
    }
}
--------------------------------------------------------------------------
LeetCode 4. Median of Two Sorted Arrays

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       	int m=nums1.length;
		int n=nums2.length;
		
		int i=0, j=0, k=0;
		//merge array
		
		int merged[]=new int[m+n];
		
		while(i < m && j < n) {
			if(nums1[i] < nums2[j]) {
				merged[k++]=nums1[i++];
			}else {
				merged[k++]=nums2[j++];
			}
		}
		//copy remaining array 1
		while(i<m) {
			merged[k++]=nums1[i++];
		}
		//copy remaining array 2
		while(j < n) {
			merged[k++] = nums2[j++];
		} 
        int mid= (m+n)/2;
        if((m+n)%2==0){
            return ((merged[mid-1] + merged[mid]) / 2.0);
        }else{
            return merged[mid];
        }
    }
}
--------------------------------------------------------------------------
367. Valid Perfect Square
Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

class Solution {
    public boolean isPerfectSquare(int num) {
        int low=1, high=num;
        int ans=0;
         if(num==0){
                return true;
            }
        while(low<=high){
            int mid=(low+high)/2;
           
            if(mid<=(num/mid)){
                ans=mid;
                low=mid+1;
            }else {
                high=mid-1;
            }
            if(ans*ans ==num){
				return true;
            }
        }
        return false;
    }
}
--------------------------------------------------------------------------
LeetCode 283. Move Zeroes

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

class Solution {
    public void moveZeroes(int[] nums) {
        int move =0;
        for(int i =0 ; i< nums.length; i++){
            if(nums[i] != 0){
                nums[move]= nums[i];
                move++;
            }
        }
        for(int i = move; i< nums.length; i++){
            nums[i]=0;
        }
    }
}
--------------------------------------------------------------------------
260. Single Number III
Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

class Solution {
    public int[] singleNumber(int[] nums) {
        int a=0, b =0, xor=0;
        for(int i=0;i<nums.length; i++){
            xor =xor^ nums[i];
        }
        int lastSetBit= xor & ~ (xor-1);
        for( int i =0; i < nums.length; i++){
            if((nums[i] & lastSetBit) != 0){
                a= a^ nums[i];
            } else{
                b = b^ nums[i];
            }
        }
        return new int[]{a,b};
    }
}
--------------------------------------------------------------------------
Leetcode 11. Container With Most Water
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

class Solution {
    public int maxArea(int[] height) {
        int start=0, end=height.length-1;
        int maxWater=0;
        while(start < end){
            int area = (end - start) * Math.min(height[start], height[end]);
            maxWater= Math.max(maxWater, area);
        
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
    return maxWater;

    }
}
--------------------------------------------------------------------------
Binary number to decimal number
Examples:

Input: b = 10001000
Output: 136

class Solution {
    public int binaryToDecimal(String b) {
       char ch[] = b.toCharArray();
       
       int power=1;
       int sum=0;
       for(int i= ch.length-1; i>=0; i--){
           if(ch[i]=='1'){
               sum= sum+power;
           }
           power=power*2;
       }
       return sum;
    }
}
--------------------------------------------------------------------------
Decimal to binary
Examples :

Input: n = 7
Output: 111

class Solution {
    static String decToBinary(int n) {
        StringBuffer b=new StringBuffer();
        while(n>0){
           b.append(n%2+"");
           n=n/2;
       }
       return b.reverse().toString();
    }
}
--------------------------------------------------------------------------
First and Second Smallests
Examples:

Input: arr[] = [2, 4, 3, 5, 6]
Output: 2 3 
Explanation: 2 and 3 are respectively the smallest and second smallest elements in the array.

class Solution {
    public int[] minAnd2ndMin(int arr[]) {
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        for(int i=0; i< arr.length; i++){
            if(arr[i] < first){
                second=first;
                first= arr[i];
                
            }else if(arr[i]<second && first!=arr[i]){
                
                second=arr[i];
            }
        }
        if(first==second || first==Integer.MAX_VALUE|| second==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }else{
            return new int[]{first, second};
        }
    }
}
--------------------------------------------------------------------------
Largest Element in Array
Examples:

Input: arr[] = [1, 8, 7, 56, 90]
Output: 90
Explanation: The largest element of the given array is 90.

int largest(int arr[], int n) {
   int max=-1; 
   
    for(int i=0; i<n; i++){
        if(arr[i] > max){
            max=arr[i];
        }
    }
    return max;
}
--------------------------------------------------------------------------
Min and Max in Array
Examples:

Input: arr[] = [3, 2, 1, 56, 10000, 167]
Output: 1 10000
Explanation: minimum and maximum elements of array are 1 and 10000

class Solution {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }
        int min=arr[0] ;
        int max=arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }
        Pair<Integer, Integer> result=new Pair<>(min, max); 
        return result;
    }
}
--------------------------------------------------------------------------
Reverse array in groups
Examples:

Input: arr[] = [1, 2, 3, 4, 5], k = 3
Output: [3, 2, 1, 5, 4]
Explanation: First group consists of elements 1, 2, 3. Second group consists of 4,5.

class Solution {
    // Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Long> arr, int k) {
        int n=arr.size()-1;
        for( int i=0; i<= n; i= i+k){
            int low= i;
            int high= i+k-1;
            if(high>n){
                high=n;
            }
            
            while(low<=high){
                Long temp=arr.get(low);
                arr.set(low, arr.get(high));
                arr.set(high, temp);
                low++;
                high--;
            }
        }
    }
}
--------------------------------------------------------------------------
Binary Search
Examples:

Input: arr[] = [1, 2, 3, 4, 5], k = 4
Output: 3
Explanation: 4 appears at index 3.
Input: arr[] = [11, 22, 33, 44, 55], k = 445
Output: -1
Explanation: 445 is not present.

class Solution {
    public int binarysearch(int[] arr, int k) {
        int low =0;
        int high=arr.length-1;
        int result =-1;
        if(arr.length==0){
            return -1;
        }
        while(low<=high){
            int mid =low+(low+high)/2;
            
            if(k== arr[mid]){
                high= mid -1;
                result= mid;
                
            }else if(arr[mid]> k){
                high= mid-1;
            }else{
                low= mid+1;
            }
        }
        return result;
    }
}
--------------------------------------------------------------------------
Find the Frequency
Examples :

Input: arr = [1, 1, 1, 1, 1], x = 1
Output: 5
Explanation: Frequency of 1 is 5.
Input: arr = [1, 2, 3, 3, 2, 1], x=2
Output: 2
Explanation: Frequency of 2 is 2.

class Solution {
    int findFrequency(int arr[], int x) {
         
         int count=0;
         for(int i=0; i< arr.length; i++){
             
             if(arr[i] == x ){
                 count++;
             }
         }
         
         return count;
    }
}
--------------------------------------------------------------------------
Number of occurrence
Examples :

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0


class Solution {
    int countFreq(int[] arr, int target) {
         
        //  int count=0;
         
        //  for(int i =0; i< arr.length; i++){
        //      if(arr[i]==target){
        //          count++;
        //      }
        //  }
        //  return count;
        
        
        //other solution below
        
        if(arr!=null && arr.length ==0){
            return 0;
        }
        int first=countFreqFirst(arr, target);
		int last = countFreqLast(arr, target);
		
		if(first == -1){
		    return 0;
		}
		int count= last-first+1;
		
		
		return count;
    }
    
    private static int countFreqFirst(int[] arr, int target) {
		
		int low=0; int high=arr.length-1;
		int first= -1;
		while(low<=high) {
			int mid=  (low+high)/2;
			if(arr[mid]==target) {
				first =mid;
				high=mid-1;
			} else if (arr[mid] > target ) {
				high= mid-1;
			}else {
				low =mid+1;
			}
		}
		return first;
	}

	private static int countFreqLast(int[] arr, int target) {
		int last =-1;;
		int low=0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = (low+high)/2;	
			if(arr[mid]== target) {
				last=mid;
				low= mid+1;
			}else if(arr[mid]>target) {
				high =mid-1;
			}else {
				low = mid +1;
			}
		}
		return last;
	}
}
--------------------------------------------------------------------------
Reverse an Array
Examples:

Input: arr = [1, 4, 3, 2, 6, 5]
Output: [5, 6, 2, 3, 4, 1]
Explanation: The elements of the array are 1 4 3 2 6 5. After reversing the array, the first element goes to the last position, the second element goes to the second last position and so on. Hence, the answer is 5 6 2 3 4 1.
Input: arr = [4, 5, 2]
Output: [2, 5, 4]
Explanation: The elements of the array are 4 5 2. The reversed array will be 2 5 4.

class Solution {
    public void reverseArray(int arr[]) {
        
        int low=0;
        int high=arr.length-1;
        
        while(low<=high){
            
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }
}
--------------------------------------------------------------------------
Second Largest
Examples:

Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second largest element is 5.

class Solution {
    public int getSecondLargest(int[] arr) {
        int first=-1;
        int second=-1;
        
        for(int i=0;i < arr.length; i++){
            
            if(arr[i]>first){
                second=first;
                first=arr[i];
            }else if(arr[i]>second && arr[i]!=first){
                second=arr[i];
            }
        }
        
        if(second==-1){
            return -1;
        }
        
        return second;
    }
}
--------------------------------------------------------------------------
Selection Sort
Examples :

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: Maintain sorted (in bold) and unsorted subarrays. Select 1. Array becomes 1 4 3 9 7. Select 3. Array becomes 1 3 4 9 7. Select 4. Array becomes 1 3 4 9 7. Select 7. Array becomes 1 3 4 7 9. Select 9. Array becomes 1 3 4 7 9.
Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

class Solution {
    void selectionSort(int[] arr) {
        int n= arr.length;
        for(int i=0; i<n-1; i++){
            int minIndex=i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
             if (minIndex != i){
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
             }
        }
    }
}
--------------------------------------------------------------------------
Single Among Doubles
Examples :

Input: n = 5, arr[] = {1, 1, 2, 5, 5}
Output: 2
Explanation: Since 2 occurs once, while other numbers occur twice, 2 is the answer.
Input: n = 7, arr[] = {2, 2, 5, 5, 20, 30, 30}
Output: 20
Explanation: Since 20 occurs once, while other numbers occur twice, 20 is the answer.

class Sol {
    public static int search(int n, int arr[]) {
        int num=0;
        for(int i=0; i<n ; i++){
            num= num ^ arr[i];
        }
        return num;
    }
}
--------------------------------------------------------------------------
Array Subset
Examples:

Input: a[] = [11, 7, 1, 13, 21, 3, 7, 3], b[] = [11, 3, 7, 1, 7]
Output: true
Explanation: b[] is a subset of a[]
 
Input: a[] = [10, 5, 2, 23, 19], b[] = [19, 5, 3]
Output: false
Explanation: b[] is not a subset of a[]

class Solution {
    public boolean isSubset(int a[], int b[]) {
       Map<Integer, Integer> map=new HashMap<Integer, Integer>();
       for(int num : a){
           map.put(num, map.getOrDefault(num, 0)+1);
       }
       for(int num : b){
           if(!map.containsKey(num) || map.get(num) ==0 ){
              return false;
           }else{
               map.put(num, map.get(num)-1);
           }
       }
       return true;
    }
}
--------------------------------------------------------------------------
LeetCode 1. Two Sum

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i <nums.length; i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
--------------------------------------------------------------------------
LeetCode 242. Valid Anagram

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()){
            return false;
        }
        Map<Character, Integer> map=new HashMap<>();
        for(char ch: s.toCharArray()){
           map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(char ch: t.toCharArray()){
            if(map.containsKey(ch)){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        if(map.size()>0){
            return false;
        }
        return true;
    }
}
--------------------------------------------------------------------------
GFG Largest subarray with 0 sum
Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.

class Solution {
    int maxLen(int arr[]) {
        Map<Integer, Integer> map= new HashMap<Integer, Integer>();
        int sum=0;
        int ans=0;
        for(int i=0;i< arr.length; i++){
            sum=sum+(arr[i]);
            if(map.containsKey(sum)){
                ans = Math.max(ans,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
            if(map.size()>0 && sum==0){
                ans= Math.max(ans,i+1);
            }
        }
        return ans;
    }
}
--------------------------------------------------------------------------
GFG Longest Subarray with Sum K
Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int ans=0;       int sum=0;
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0; i < arr.length; i++){
            sum=sum+arr[i];
            if(sum== k){
                ans=Math.max(ans,i+1);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            if(map.containsKey(sum-k)){
                ans=Math.max(ans, i-map.get(sum-k));
            }
        }
        return ans;
    }
}
--------------------------------------------------------------------------
LeetCode 560. Subarray Sum Equals K
Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans=0;       int sum=0;
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        map.put(0,1);
        for(int i=0;i < nums.length; i++){
            sum=sum+nums[i]; 
            if(map.containsKey(sum-k)){
                ans= ans+ map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum ,0)+1);
        }
        return ans;
    }
}
--------------------------------------------------------------------------
LeetCode 704. Binary Search

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

class Solution {
    public int search(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid= (low+high)/2;
            if(nums[mid]== target){
                return mid;
            }
            if(nums[mid]< target){
                    low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
--------------------------------------------------------------------------
GFG Binary Search

Examples:

Input: arr[] = [1, 2, 3, 4, 5], k = 4
Output: 3
Explanation: 4 appears at index 3.
Input: arr[] = [11, 22, 33, 44, 55], k = 445
Output: -1
Explanation: 445 is not present.
Input: arr[] = [1, 1, 1, 1, 2], k = 1
Output: 0
Explanation: 1 appears at index 0.

class Solution {
    public int binarysearch(int[] arr, int k) {
        int low =0;
        int high=arr.length-1;
        int result =-1;
        if(arr.length==0){
            return -1;
        }
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(k== arr[mid]){
                high= mid -1;
                result= mid;
            }else if(arr[mid]> k){
                high= mid-1;
            }else{
                low= mid+1;
            }
        }
        return result;
    }
}
--------------------------------------------------------------------------
LeetCode 33. Search in Rotated Sorted Array

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

class Solution {
    public int search(int[] nums, int target) {
        int low=0;  
        int high = nums.length-1; 
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low] <= target && target <=nums[mid]){
                    high=mid-1;
                }else{
                    low= mid+1;
                }
            }else{
                if(nums[mid]<=target && target<= nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
--------------------------------------------------------------------------
LeetCode 153. Find Minimum in Rotated Sorted Array

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 

class Solution {
    public int findMin(int[] nums) {
        int low=0; int high=nums.length-1;
        while(low<high){
            int mid= (low+high)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }else{
                high=mid;
			}	
        }
        return nums[low];
    }
}
--------------------------------------------------------------------------
LeetCode 14. Longest Common Prefix

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
 
class Solution {
    public String longestCommonPrefix(String[] strs) {
         if(strs == null || strs.length == 0) return "";
        //here first array value storing in prefix
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(prefix) != 0) {
            	//here every time removing one character and comparing in while loop
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
--------------------------------------------------------------------------
LeetCode 35. Search Insert Position

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

class Solution {
    public int searchInsert(int[] nums, int target) {
      int low= 0;
      int high= nums.length-1;
      int ans = nums.length;
      while(low<=high){
        int mid= (low+high)/2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid] > target){
            high =mid-1;
            ans= mid;
        }else{
            low= mid+1;
        }
      }
      return ans;
    }
}
--------------------------------------------------------------------------
LeetCode 34. Find First and Last Position of Element in Sorted Array

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int firtPosition=-1;
        int lastPosition=-1;
        while(low<=high){
            int mid =(low+high)/2;

            if(nums[mid] == target){
                firtPosition = mid;
                high= mid-1;
            }else if( target >nums[mid] ){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        low=0;
        high=nums.length-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(nums[mid] ==target){
                lastPosition=mid;
                low=mid+1;
            }else if(nums[mid]< target){
                low=mid+1;
            }else{
                high= mid-1;
            }
        }

        return new int[]{firtPosition, lastPosition};
    }
}
--------------------------------------------------------------------------
LeetCode 69. Sqrt(x)

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

class Solution {
    public int mySqrt(int x) {
        if( x==0 || x ==1){
            return x;
        }
        int result=1;
        int low=0; int high =x;
        while(low<= high){
            int mid = (low + high )/2;
            if(mid <=  (x/mid)){
                result = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return result;
    }
}
--------------------------------------------------------------------------
LeetCode 367. Valid Perfect Square

Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
Example 2:

Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.

class Solution {
    public boolean isPerfectSquare(int num) {
        int low=1, high=num;
        int ans=0;
         if(num==0){
                return true;
            }
        while(low<=high){
            int mid=(low+high)/2;
            if(mid<=(num/mid)){
                ans=mid;
                low=mid+1;
            }else {
                high=mid-1;
            }
            if(ans*ans ==num){
				return true;
            }
        }
        return false;
    }
}
--------------------------------------------------------------------------
LeetCode 162. Find Peak Element

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums!=null && nums.length==1){
            return 0;
        }
        int n=nums.length;
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[n-1]> nums[n-2]){
            return n-1;
        }
        int  low=1; int high =n-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] > nums[mid+1] && nums[mid]> nums[mid-1]){
                return mid;
            }
            if(nums[mid]> nums[mid-1]){
                low = mid+1;
            }else {
                high= mid-1;
            }
        }
    return -1;
    }
}
--------------------------------------------------------------------------
LeetCode 3. Longest Substring Without Repeating Characters
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
 class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map= new HashMap<Character, Integer>();
        int end =0;
        int result =0;
        for(int i=0; i< s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                end = Math.max(end, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            result=Math.max(result, i-end+1);
        }
        return result;
    }
}
--------------------------------------------------------------------------
LeetCode 49. Group Anagrams
Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            map.putIfAbsent(sortedWord, new ArrayList<>());
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
--------------------------------------------------------------------------
Leetcode 26. Remove Duplicates from Sorted Array

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums!=null & nums.length==0){
            return 0;
        }
        int k=0;
        for(int i=1; i< nums.length; i++){
            if(nums[i] != nums[k]){
                k++;
                nums[k]=nums[i];
            }
        }
        return k+1;
    }
}
--------------------------------------------------------------------------
LeetCode 20. Valid Parentheses
Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

class Solution {
    public boolean isValid(String str) {
        Stack<Character> stack=new Stack<Character>();

        for(char ch: str.toCharArray()){
            if(ch=='(' || ch =='{' || ch== '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char open= stack.pop();
                if(!isMatch(open, ch)){
                    return false;
                }
            }
        }
         // Stack should be empty if valid parentheses
        return stack.isEmpty();
    }

    private boolean isMatch(char open, char close){
        return (open=='(' && close==')') || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }
}
--------------------------------------------------------------------------
LeetCode 13. Roman to Integer
Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

class Solution {
    public int romanToInt(String str) {
        Map<Character, Integer> map=new HashMap<Character, Integer>();
        map.put('I', 1);         map.put('V', 5);
        map.put('X', 10);        map.put('L', 50);
        map.put('C', 100);       map.put('D', 500);
        map.put('M', 1000);
        
        int result=0;
        int prevValue=0;

        for(int i= str.length()-1;  i>=0; i--){
            int currectValue= map.get(str.charAt(i));
            if(currectValue < prevValue){
                result= result- currectValue;
            }else{
                result = result+ currectValue;
            }
            prevValue=currectValue;
        }
        return result;
    }
}
--------------------------------------------------------------------------
Leetcode 28. Find the Index of the First Occurrence in a String
Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

class Solution {
    public int strStr(String haystack, String needle) {
        int m= haystack.length();
        int n= needle.length();

        for(int i =0; i<=m-n; i++){
            if(haystack.substring(i, i+n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
--------------------------------------------------------------------------
LeetCode 58. Length of Last Word
Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

class Solution {
    public int lengthOfLastWord(String s) {
        String arr[]= s.split(" ");
        String result =arr[arr.length-1];
        return result.length();
    }
}


==========================================================================
			LinkedList 
==========================================================================

Print Linked List
Input: LinkedList : 1 -> 2
Output: 1 2
Explanation: The linked list contains two elements 1 and 2.The elements are printed in a single line.

/* Node is defined as
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}*/
/*
    Print elements of a linked list on console
    Head pointer input could be NULL as well for empty list
*/

class Solution {
    // Function to display the elements of a linked list in same line
    void printList(Node head) {
        Node current = head;
        
        while(current != null){
            System.out.print(current.data+" ");
            current= current.next;
        }
    }
}
--------------------------------------------------------------------------
Count Linked List Nodes
Input: LinkedList : 1->2->3->4->5
Output: 5
Explanation: Count of nodes in the linked list is 5, which is its length.

class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        int count=0;
        
        Node current=head;
        
        while(current!=null){
            count++;
            current= current.next;
        }
        return count;
    }
}		
--------------------------------------------------------------------------
https://www.geeksforgeeks.org/problems/linked-list-length-even-or-odd/0

Is Linked List Length Even?

Input: Linked list: 12->52->10->47->95->0
Output: true
Explanation: The length of the linked list is 6 which is even, hence returned true.

Input: Linked list: 9->4->3
Output: false
Explanation: The length of the linked list is 3 which is odd, hence returned false.

class Solution {
    public boolean isLengthEven(Node head) {
         
         Node current= head;
         int count = 0;
         while(current != null){
             count++;
             current=current.next;
         }
         
         return count%2==0? true: false;
    }
}
--------------------------------------------------------------------------
https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card


class Solution {
    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
      
      Node temp=new Node(x);
      if(head==null){
          return temp;
      }
       
       Node current= head;
       
       while(current.next != null){
           current = current.next;
       }
       
       current.next=temp;
       
       return head;
        
    }
}