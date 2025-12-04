import java.util.*;

// class Permutation {
//     static List<List<Integer>> result;
//     static Set<Integer> set;
//     public List<List<Integer>> permute(int[] nums) {
//         result = new ArrayList<>();
//         set = new HashSet<>();
//         ArrayList<Integer> temp = new ArrayList<>();
//         solve(nums, temp);
//         return result;
        
//     }
//     //backtracking approach
//     // private static void solve(int nums[], ArrayList<Integer> temp){
        
//     //     if(temp.size()==nums.length){
//     //         result.add(new ArrayList<>(temp));
//     //         return;
//     //     }
//     //     for(int i=0; i<nums.length;i++){
//     //         if(!set.contains(nums[i])){
//     //             set.add(nums[i]);
//     //             temp.add(nums[i]);
//     //             solve(nums, temp);
//     //             temp.remove(temp.size()-1);
//     //             set.remove(nums[i]);
//     //         }

//     //     }
//     // }

//     // swap approach
// }
class Permutation {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums,0);
        return res;
    }

    public void backtrack(int[] nums, int idx){
        if(idx==nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int num : nums){
                perm.add(num);
            }
            res.add(perm);
            return;
        }

        for(int i=idx; i<nums.length; i++){
            swap(nums,idx,i);
            backtrack(nums,idx+1);
            swap(nums,idx,i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}