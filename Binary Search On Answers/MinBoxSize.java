// ques: you have n items with weights and want to pack them into k boxes. each box can hold upto some weight limit find the min of max weight limit so that all items fit.
// you can item sequentially only.

public class MinBoxSize{
    static int sum;
    public static void main(String[] args){
        int[] weight = {2,3,5,4};
        int k=2;
        System.out.println(minCapacity(weight, k)); // O/p: 9

    }
    public static int minCapacity(int[] nums, int k){
        int maxWeight=0;
        int sum=0;
        for(int w: nums){
            maxWeight=Math.max(w, maxWeight);
            sum+=w;
        }
        int low=maxWeight;
        int high = sum;
        int ans = sum;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(canPack(nums, k , mid)){
                ans=mid;            //wehave a possible answer, look for smaller now
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        
        return ans;
    }
    private static boolean canPack(int[] nums, int k, int capacity){
        int boxes=1;
        int currSum=0;

        for(int w: nums){
            if(currSum+w<=capacity){
                currSum+=w;
            }else{
                boxes++;
                currSum=w;
                if(boxes>k) return false;
            }
        }
        return true;
    }
    
}


