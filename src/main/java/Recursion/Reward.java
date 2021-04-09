package Recursion;

import java.util.ArrayList;

public class Reward {
    static int[] moneyType = {1,2,5,10};

    public static void get(int total, ArrayList<Integer> result) {
        if (total == 0) {
            System.out.println(result);
            return;
        } else if (total < 0) {
            return;
        } else {
            for (int i = 0; i < moneyType.length; i++) {
                ArrayList<Integer> newResult = (ArrayList<Integer>) result.clone();
                newResult.add(moneyType[i]);
                get(total-moneyType[i], newResult);
            }
        }
    }


    public static void main(String[] args) {
        Reward.get(10, new ArrayList<Integer>());

    }




}
