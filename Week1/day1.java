package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 운동 중독 플레이어
 */
public class day1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int W = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);

        double calc = (1+(double) R /30);
        double oneRm = W * calc;
        System.out.println(Math.round(Math.floor(oneRm)));
    }
}
