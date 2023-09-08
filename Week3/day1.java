package Week3;

import java.util.Arrays;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        int pain = 0;
        Scanner sc = new Scanner(System.in);
        pain = Integer.parseInt(sc.nextLine());
        String[]  input = sc.nextLine().split(" ");
        int itemA = Integer.parseInt(input[0]);
        int itemB = Integer.parseInt(input[1]);

        int[] dp = new int[pain+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i = 1; i <= pain; i++) {
            if(i >= itemA) {
                dp[i] = Math.min(dp[i], dp[i-itemA]+1);
            }

            if(i >= itemB)
                dp[i] = Math.min(dp[i], dp[i-itemB]+1);
        }
        if(dp[pain]==Integer.MAX_VALUE-1)
            System.out.println(-1);
        else
            System.out.println(dp[pain]);
    }
}