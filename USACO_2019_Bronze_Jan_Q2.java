import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class USACO_2019_Bronze_Jan_Q2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));

        int cowSize = Integer.parseInt(br.readLine());
        String cowOrder = br.readLine();
        StringTokenizer tok = new StringTokenizer(cowOrder);

        ArrayList<Integer> order = new ArrayList<>();
        ArrayList<Integer> perfectOrder = new ArrayList<>();
        for (int i = 0; i < cowSize; i++) {
            order.add(Integer.parseInt(tok.nextToken()));
            perfectOrder.add(i+1);
        }
        br.close();

        int count = 0;
        for (int i = 0; i < order.size(); i++) {

            if(!order.equals(perfectOrder))count++;
            else break;
            int replace = order.get(0);
            order.remove(0);
            int prev = Integer.MAX_VALUE;
            for (int j = order.size()-1; j >=0; j--) {
                if(!(order.get(j) > replace && order.get(j) < prev) ) {
                    order.add(j+1, replace);
                    break;
                }
                prev = order.get(j);

            }


        }

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        out.println(count);
        out.close();
        }


    }
