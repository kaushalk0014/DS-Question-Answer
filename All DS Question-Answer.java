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
----------------------------------------------------------------------------------------------------

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
-------------------------------------------------------------------------------------------------------
4. Median of Two Sorted Arrays

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
--------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------------
283. Move Zeroes

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
--------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------
11. Container With Most Water
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
//------------------------------------------------------------------------------------------------------
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
--------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------------------
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
--------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------------------
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
--------------------------------------------------------------------------------------------------------
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
-------------------------------------------------------------------------------------------------------
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
-----------------------------------------------------------------------------------------------------------
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
--------------------------------------------------------------------------------------------------------
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
-----------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------------------
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
------------------------------------------------------------------------------------------------------------
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


