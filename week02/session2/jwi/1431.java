import java.util.*;
import java.io.*;


public class Main
{

    private static BufferedReader br;
    private static BufferedWriter bw;


    public static void main(String args[]) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // O(NlogN) , N 은 50 이하

        ////////////////////////////////////////////////////////

        // 1. 입력 및 리스트 삽입
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            list.add(br.readLine());
        }

        ////////////////////////////////////////////////////////

        // 2. 정렬
        Collections.sort(list , (o1,o2) -> {

            // 우선순위1: 짧은 것이 먼저 온다.
            if(o1.length() != o2.length()) return o1.length() - o2.length();

            // 우선순위2: A 의 모든 자리수의 합과 B 의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저 온다.
            int sum1 = getDigitSum(o1);
            int sum2 = getDigitSum(o2);
            if(sum1 != sum2) return sum1 - sum2;

            // 우선순위3 : 사전 순으로 비교한다.
            return o1.compareTo(o2);

        });

        ////////////////////////////////////////////////////////

        // 3. 출력
        for(int i = 0 ; i < N ; i++) {
            bw.write(list.get(i)+"\n");
        }



        /////////////////////////////////////////////////////////

        bw.flush();
        bw.close();
        br.close();


    }

    public static int getDigitSum(String s) {

        int sum = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(Character.isDigit(s.charAt(i))) {
                sum += s.charAt(i) - '0';
            }
        }
        return sum;
    }

}

