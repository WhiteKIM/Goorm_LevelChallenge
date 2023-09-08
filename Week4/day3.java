package Week4;

import java.util.Scanner;

public class day3 {
    public static int N;
    public static int[][] map;
    public static int[][] horizon;
    public static int[][] vertical;

    public static void drawing(char command, int x, int y) {
        switch (command) {
            case 'R':
                for(int i = y; i < N; i++) {
                    horizon[x][i] +=1;
                }
                break;
            case 'D':
                for(int i = x; i < N; i++) {
                    vertical[i][y] +=1;
                }
                break;
            case 'L':
                for(int i = y; i >= 0; i--) {
                    horizon[x][i] +=1;
                }
                break;
            case 'U':
                for(int i = x; i >= 0; i--) {
                    vertical[i][y] +=1;
                }
                break;
            default:
                break;
        }
    }

    public static long countIntersaction() {
        long intersaction = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(horizon[i][j] >= 1 && vertical[i][j] >= 1) {
                    intersaction+= ((long) horizon[i][j] * vertical[i][j]);
                }
            }
        }
        return intersaction;
    }

    public static void main(String[] args) {
        int M;

        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][N];
        horizon = new int[N][N];
        vertical = new int[N][N];
        for(int i = 0; i < M; i++) {
            input = sc.nextLine().split(" ");
            int x = Integer.parseInt(input[0]) - 1;
            int y = Integer.parseInt(input[1]) - 1;
            char ch = input[2].charAt(0);
            drawing(ch, x, y);
        }

//        for(int[] x : map) {
//            for (int y : x) {
//                System.out.print(y+" ");
//            }
//            System.out.println();
//        }
        long result = countIntersaction();
        System.out.println(result);
    }
}
