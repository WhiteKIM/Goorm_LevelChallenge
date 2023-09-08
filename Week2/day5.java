package Week2;

import java.util.Scanner;

public class day5 {
    public static int N;
    public static String[][] map;

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public static int solved(int x, int y) {
        int count = 1;
        boolean[][] visited = new boolean[N][N];
        boolean check = true;
        visited[x][y] = true;
        while (check) {
            String command = map[x][y];

            String direction = command.replaceAll("[0-9]", ""); // 이동 방향(L, R, U, P)
            int move = Integer.parseInt(command.replaceAll("[^0-9]", ""));

            for(int i = 0; i < move; i++) {
                int nx = x;
                int ny = y;

                if(direction.equals("U")) {
                    nx = x - 1;
                } else if(direction.equals("D")) {
                    nx = x + 1;
                } else if (direction.equals("L")) {
                    ny = y - 1;
                } else {
                    ny = y + 1;
                }

                if(nx < 0)
                    nx = N-1;
                if(nx >= N)
                    nx = 0;
                if(ny < 0)
                    ny = N-1;
                if(ny >= N)
                    ny = 0;

                if(visited[nx][ny]) {
                    check = false;
                    break;
                }

                visited[nx][ny] = true;
                count++;
                x = nx;
                y = ny;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new String[N][N];

        int goorm_x, goorm_y;
        int player_x, player_y;

        String[] input = sc.nextLine().split(" ");
        goorm_x = Integer.parseInt(input[0])-1;
        goorm_y = Integer.parseInt(input[1])-1;

        input = sc.nextLine().split(" ");
        player_x = Integer.parseInt(input[0])-1;
        player_y = Integer.parseInt(input[1])-1;

        for(int i = 0; i < N; i++) {
            input = sc.nextLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = input[j];
            }
        }

        int goormResult = solved(goorm_x, goorm_y);
        int playerResult = solved(player_x, player_y);

        if(goormResult > playerResult) {
            System.out.println("goorm "+goormResult);
        } else {
            System.out.println("player "+playerResult);
        }
    }
}
