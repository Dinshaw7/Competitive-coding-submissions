import java.io.*;
import java.util.*;


public class SubString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        String S = br.readLine();

        long out_ = solve(N, K, S);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static long solve(int N, int K, String S){
        // Type your code here
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i=0; i<=N-K; i++){  // i=i+K-1; my previous logic
            int count=1;
            String subStr = S.substring(i,i+K);
            if(hashMap.containsKey(subStr)){
                count = hashMap.get(subStr)+1;
            }
            hashMap.put(subStr, count);
        }


        long P=0;
        long Q=0;
        for(Map.Entry<String, Integer> entry: hashMap.entrySet()){
            P +=  entry.getValue()*entry.getValue();
            Q += entry.getValue();
        }
       
        return (P/Q)%998244353;
    }
}
