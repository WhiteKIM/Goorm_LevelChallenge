package Week2;

import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int count = 0;
        while(N > 0) {
            if(N >= 14) {
                count += N / 14;
                N %= 14;
            }
            if(N >= 7) {
                count += N / 7;
                N %= 7;
            }

            if(N >= 1) {
                count += N;
                N = 0;
            }
        }

        System.out.println(count);
    }
}
