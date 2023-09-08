package Week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class day4 {
    public static int N;
    public static ArrayList<Integer>[] data;

    public static int bfs(int fixed, boolean[] visited, int start, int end) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{start, 1});
        visited[start] = true;

        if(fixed == start || fixed == end) {
            return -1;
        }

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int count = arr[1];

            if(x == end) {
                return count;
            }

            for(int nx : data[x]) {
                if(!visited[nx] && (fixed != nx)) {
                    visited[nx] = true;
                    queue.add(new int[]{nx, count+1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);//도시 개수
        int M = Integer.parseInt(input[1]);//도로 개수
        int S = Integer.parseInt(input[2]);//출발 도시
        int E = Integer.parseInt(input[3]);
        StringBuilder sb = new StringBuilder();

        data = new ArrayList[N+1];

        // 초기화 진행
        for(int i = 1; i <= N; i++) {
            data[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            input = sc.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            // 양방향
            data[x].add(y);
            data[y].add(x);
        }

        for(int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N+1];
            int result = bfs(i, visited, S, E);
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
