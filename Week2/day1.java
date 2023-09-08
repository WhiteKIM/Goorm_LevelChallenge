package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class day1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static List<String> comp = new ArrayList<>();
    public static int max = 0;
    public static List<String> copy;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] data = new String[3];
        for(int i = 1; i < input.length(); i++) {
            for (int j = i+1; j < input.length(); j++) {
                data[0] = input.substring(0, i);
                data[1] = input.substring(i, j);
                data[2] = input.substring(j);
                comp.add(data[0]);
                comp.add(data[1]);
                comp.add(data[2]);
            }
        }
        copy = new ArrayList<>(comp);
        comp = comp.stream().distinct().collect(Collectors.toList());
        Collections.sort(comp);
        int count = 0;
        int sum = 0;
        for(int i = 0; i < copy.size(); i++) {
            for(int j = 0; j < comp.size(); j++) {
                if(comp.get(j).equals(copy.get(i))) {
                    sum += (j+1);
                    count+=1;
                }
                if(count == 3) {
                    max = Math.max(sum, max);
                    count = 0;
                    sum = 0;
                    break;
                }
            }
        }

        System.out.println(max);
    }
}
