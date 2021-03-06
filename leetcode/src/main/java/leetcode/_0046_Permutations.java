package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @No          46
 * @problem     Permutations
 * @level       Medium
 * @desc        全排列
 * @author      liyazhou1
 * @date        2019/09/17 08:09 371公交
 *
 * <pre>
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * </pre>
 */
public class _0046_Permutations {


    /**
     * Note
     *
     * Thought
     *      回溯法
     *          递归 + 重置状态 + 剪枝
     *              execute
     *              backtrack
     *              reset
     *
     *          递归回溯的过程，是一棵树
     *
     *          全排列是一个基础算法，可以解决"括号生成"、"电话号码的字母组合"等问题
     *
     * Challenge
     *
     * Algorithm
     *      全排列
     *          固定前i个元素
     *          使i+2~n索引对应的元素分别于i+1交换位置，后固定i+1个元素
     *
     * Complexity
     *      Time,
     *      Space,
     */
    private static class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }

            // List<Integer> seq = Arrays.asList(nums);
            List<Integer> seq = new ArrayList<>();
            for (int num : nums) {
                seq.add(num);
            }

            permute(result, seq, 0);
            return result;
        }

        private void permute(List<List<Integer>> result, List<Integer> seq, Integer depth) {
            if (depth == seq.size()) {
                result.add(new ArrayList(seq));
                return;
            }

            for (int i = depth; i < seq.size(); i ++) {
                Collections.swap(seq, i, depth);
                permute(result, seq, depth+1);
                Collections.swap(seq, i, depth);
            }
        }
    }
}
