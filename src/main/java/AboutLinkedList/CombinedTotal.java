package com.jdbc.AboutLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CombinedTotal {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int i = 0;

        for (; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            // 头尾大于target也要排除。
        }

        if (i < 2) return null;

        int[] conditionData = Arrays.copyOfRange(candidates, 0, i);

        int head = 0;
        int tail = i-1;
        List<List<Integer>> condition = new ArrayList();

        while (head != tail) {
            int result = conditionData[head] + conditionData[tail];

            if (result < target) {
                head++;
                continue;
            }
            else if (result > target) {
                tail--;
                continue;
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(conditionData[head]);
                list.add(conditionData[tail]);
                condition.add(list);
                head++;
                --tail;
                continue;
            }
        }
        return condition;
    }

    public static void main(String[] args) {
        int[] test = {10,1,2,7,6,1,5};

//        Arrays.sort(test);
//        System.out.println(Arrays.toString(test));
        List<List<Integer>> condition = combinationSum2(test, 8);

        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer>  list : condition) {
            Iterator i = list.iterator();
            while (i.hasNext()) {
                stringBuilder.append(i.next()+", ");
            }

            stringBuilder.append("||");
        }
        System.out.println(stringBuilder);

//        System.out.println(Arrays.toString());combinationSum2(test, 8);



    }

}
