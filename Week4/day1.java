package Week4;

import java.util.*;

public class day1 {
    public static int count = 0;
    public static int N;
    public static boolean[] visited;
    public static int[][] map;

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            x = queue.poll();

            for(int y = 1; y <= N; y++) {
                if(!visited[y]) {
                    if(map[x][y]==1 && map[y][x]==1) {
                        visited[y] = true;
                        queue.add(y);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int M;
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < M; i++) {
            input = sc.nextLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            map[s][e] = 1;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                count+=1;
                bfs(i);
            }
        }

        System.out.println(count);
    }
}
