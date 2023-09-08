package Week4;

import java.util.*;

public class day2 {
    public static int N;
    public static ArrayList<Integer>[] data;
    public static int[] visited;

    public static int bfs(int x, int index, ArrayList<Component> components) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        int count = 0;
        visited[x] = index;

        if(!data[x].isEmpty()) {
            Component component = new Component(0);
            component.addData(x);

            while (!queue.isEmpty()) {
                x = queue.poll();

                for(int V : data[x]) {
                    if(visited[V]==0) {
                        visited[V] = index;
                        queue.add(V);
                        count+=1;
                        if(component.index > V) {
                            component.index = V;//최소값으로 초기화한다.
                        }
                        component.addData(V);
                    } else if(visited[V]==index){
                        count+=1;
                    }
                }
            }
            components.add(component);
            return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        data = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            data[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            input = sc.nextLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            data[A].add(B);
            data[B].add(A);
        }

        int index = 1;
        ArrayList<Component> components = new ArrayList<>();
        visited = new int[N+1];
        for(int i = 1; i <= N; i++) {
            if(visited[i] == 0) {
                int edge = bfs(i, index, components);
//                components.get(index-1).weight = edge;
                if(edge != -1) {
                    edge /=2;
                    components.get(index-1).setWeight(edge);
                    index += 1;
                }
            }
        }

        Collections.sort(components, new Comparator<Component>() {
            @Override
            public int compare(Component c1, Component c2) {
                if (c1.weight != c2.weight) {
                    return Float.compare(c2.weight, c1.weight);
                } else if (c1.size != c2.size) {
                    return Integer.compare(c2.size, c1.size);
                } else {
                    return Integer.compare(c1.index, c2.index);
                }
            }
        });

        Component highestPriorityComponent = components.get(0); // 가장 높은 우선순위의 컴포넌트 선택
        highestPriorityComponent.data.sort(Comparator.naturalOrder());
        for(int i : highestPriorityComponent.data) {
            System.out.print(i+" ");
        }
    }

    public static class Component {
        float weight;
        ArrayList<Integer> data = new ArrayList<>();
        int size = 0;
        int index;

        public Component(int index) {
            this.index = index;
        }
        public void addData(int i) {
            data.add(i);
            size+=1;
        }

        public void setWeight(int edge) {
            weight = (float) edge / size;
        }
    }
}
