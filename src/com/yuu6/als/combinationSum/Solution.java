package com.yuu6.als.combinationSum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> candidate = Arrays.stream(candidates).boxed().collect(Collectors.toList());
        int min = Collections.min(candidate);
        for (int i = 1; i <= target / min; i++) {//几个数
//            System.out.println(String.format("===========num is %d============", i));
            Stack<Integer> stack = new Stack<Integer>();
            find(IntStream.of(candidates).boxed().toArray(Integer[]::new), target, i, stack);
        }
        return res;
    }

    public List<List<Integer>> getRes() {
        return res;
    }

    private void find(Integer[] candidates, int target, int num, Stack stack) {
        //递归函数的编写
        //把任何东西都当成是树
//        子问题是num-1个数
        if (target >= 0 && num >= 0) {
            if (num == 0 & target == 0) {
                getInts(stack, candidates);
                return;
            } else if (num == 0 & target > 0) {
                return;
            } else {
                for (int index = 0; index < candidates.length; index++) {
                    if (!stack.contains(index)) {
                        stack.add(index);
//                    System.out.println(String.format("target is %d num is %d ,size id %d", target,num, stack.size()));
                        find(candidates, target - candidates[index], num - 1, stack);
                        stack.pop();
                    }else{
                        continue;
                    }

                }
            }
        }
        return;

    }

    private void getInts(Stack stack, Integer[] candidates) {
//        System.out.println("=========================start===========================");

        Iterator it = stack.iterator();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        while (it.hasNext()) {
            int temp = candidates[(Integer) it.next()];
            tempList.add(temp);
        }
        tempList.sort(Comparator.naturalOrder());
//        System.out.println(tempList);
//        System.out.println("=========================over===========================");
        if (!res.contains(tempList))
            res.add(tempList);
    }

    private boolean myequal(Stack stack, Integer[] candidates, int target) {
        Iterator it = stack.iterator();
        int temp = 0;
        while (it.hasNext()) {
            temp = temp + candidates[(int) it.next()];

        }
        return true ? temp == target : false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[5];
        candidates[0] = 2;
        candidates[1] = 3;
        candidates[2] = 2;
        candidates[3] = 3;
        candidates[4] = 10;
        solution.combinationSum2(candidates, 10);
//        System.out.println(solution.res);
    }

}

