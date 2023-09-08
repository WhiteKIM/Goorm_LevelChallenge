package Week1;

import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        int sum = 0;

        for(int i = 0; i < N; i++) {
            String input = sc.nextLine();

            String[] data = input.split(" ");
            int num1 = Integer.parseInt(data[0]);
            int num2 = Integer.parseInt(data[2]);

            if(data[1].equals("+")) {
                int result = num1 + num2;
                sum+= result;
            } else if(data[1].equals("-")) {
                int result = num1 - num2;
                sum+= result;
            } else if(data[1].equals("/")) {
                int result = num1 / num2;
                sum+= result;
            } else {
                int result = num1 * num2;
                sum+= result;
            }
        }
        System.out.println(sum);
    }
}
