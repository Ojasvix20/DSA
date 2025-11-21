import java.util.*;
// ques: sort an array in O(nlogn) and least space complexity.

public class SortArray{
    public static int[] sort(int[] nums){
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    private static void mergeSort(int[] nums, int left, int right){
        if(left>=right) return;

        int mid= left + (right-left)/2;

        // sort left half:
        mergeSort(nums, left, mid);
        // sort R half:
        mergeSort(nums, mid+1, right);

        merge(nums, left, mid, right);
    }
    //fn to mrge
    private static void merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right-left +1];

        int i=left;         //pointer for left half
        int j=mid+1;        //pointer for right half
        int k=0;            //pointer for temp array

        //merge while no half is empty:
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp[k++]= nums[i++];
            }else{
                temp[k++]= nums[j++];
            }
        }

        //if elements remaining in left array:
        while(i<=mid){
            temp[k++]=nums[i++];
        }
        //if elements remaining in right array:
        while(j<=right){
            temp[k++]=nums[j++];
        }

         // Copy merged temp array back into nums
        for (int x = 0; x < temp.length; x++) {
            nums[left + x] = temp[x];
        }
    }

    public static void main(String[] args){
        int[] arr ={2,1,5,88,7,4,669,8,54,2,33};
        System.out.println(Arrays.toString(sort(arr)));
    }
}