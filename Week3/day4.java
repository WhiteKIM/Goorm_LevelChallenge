package Week3;

import java.util.*;

public class day4 {
    public static int N;//노드 개수
    public static int E;//에지 개수
    public static int K;//시작 노드
    public static ArrayList<Integer>[] map;
    public static void bfs() {
        boolean[] visited = new boolean[N+1];
        int count = 1;
        int last = K;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(K);
        visited[K] = true;
        visited[0] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            last = x;
            if(!map[x].isEmpty()) {
                for(int V : map[x]) {
                    if(!visited[V]) {
                        visited[V] = true;
                        queue.add(V);
                        count+=1;
                        break;
                    }
                }
            }
        }
        System.out.println(count+" "+last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        map = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            input = sc.nextLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            map[start].add(end);
            map[end].add(start);
        }

        for(int i = 1; i<= N; i++) {
            Collections.sort(map[i]);
        }

        bfs();
    }
}