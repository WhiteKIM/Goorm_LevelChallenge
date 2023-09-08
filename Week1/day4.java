package Week1;

import java.util.Scanner;

public class day4 {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());

        String[] input = sc.nextLine().split(" ");
        int[] data = new int[N];
        int max = 0;
        int index = -1;
        int sum = 0;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            sum+= num;
            data[i] = num;

            if(max < num) {
                max = num;
                index = i;
            }
        }
        boolean check1 = true;
        boolean check2 = true;
        // 최대값을 기준으로 좌우로 검색해보자
        int before = data[0];
        for(int i = 0; i < index; i++) {
            if(before > data[i]) {
                System.out.println(data[i]);
                check1 = false;
                break;
            }

            before = data[i];
        }
        // 최대값이 인덱스의 끝인 상황이 존재하는지
        if(index+1 < N) {
            before = data[index+1];
            for(int i = index+1; i < N; i++) {
                if(before < data[i]){
                    check2 = false;
                    break;
                }

                before = data[i];
            }
        }

        if(check1 && check2) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }
    }
}
