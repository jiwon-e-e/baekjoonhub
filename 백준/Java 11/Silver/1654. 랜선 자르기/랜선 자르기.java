import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] strList = str.split(" ");
        int K = Integer.parseInt(strList[0]);
        int N = Integer.parseInt(strList[1]);

        int[] arr = new int[K];
        long max = 0;

        for (int i=0 ;i< K; i++){
            String t = br.readLine();
            arr[i] = Integer.parseInt(t);
            if (arr[i]>max) max=arr[i];
        }

        long min = 1;
        max++;

        while (min<max){
            long mid = (max+min)/2;

            int cnt = 0;

            for (int i=0;i<arr.length;i++){
                cnt += (arr[i]/mid);
            }

            if (cnt<N){
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        bw.write(String.valueOf(min-1));
        bw.flush();
        bw.close();
    }
}