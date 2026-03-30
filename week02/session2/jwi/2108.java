import java.util.*;
import java.io.*;


public class Main
{

    private static BufferedReader br;
    private static BufferedWriter bw;


    public static void main(String args[]) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // O(NlogN) , N 은 50만 이하

        ////////////////////////////////////////////////////////

        // 1. 입력 및 정렬
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        for(int i = 0 ; i < N ; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        ////////////////////////////////////////////////////////

        // 2. 산술평균 구하기
        int sum = 0;
        for(int i = 0 ; i < N ; i++) sum += arr[i];
        long roundedAvg = Math.round((double) sum / N);

        ////////////////////////////////////////////////////////

        // 3. 중앙값 구하기
        int median = arr[N/2];

        ////////////////////////////////////////////////////////

        // 4. 최빈값 구하기

        int mode = 0;

        // map 에 (숫자 , 빈도) 형태로 저장합니다.
        // max 는 최다 빈도 횟수를 의미합니다.
        // 예를들어 , arr 이 [-1,-2,-3,-1,-2] 일 때

        // map 에는 (-1:2) , (-2:2) , (-3:1) 저장
        // max 는 2 저장
        HashMap<Integer , Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0 ; i < N ; i++) {
            int current = map.getOrDefault(arr[i] , 0)+1;
            map.put(arr[i] , current);
            max = Math.max(max, current);
        }

        // list 에 최다 빈도 수에 해당하는 key 값을 저장하고 오름차순으로 정렬합니다.
        // 위의 예에서 list 에는 [-1,-2] 저장 및 [-2,-1] 로 정렬
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) if(map.get(key) == max) list.add(key);
        Collections.sort(list);

        // 최빈값을 출력합니다.
        // 여러개 있을 경우 , 두번쨰로 작은 값을 출력 합니다.
        if(list.size()==1) mode = list.get(0);
        else mode = list.get(1);

        /////////////////////////////////////////////////////////

        // 5. 범위 구하기
        int range = arr[N-1] - arr[0];


        /////////////////////////////////////////////////////////

        // 6. 출력

        bw.write(roundedAvg + "\n");
        bw.write(median+"\n");
        bw.write(mode+"\n");
        bw.write(range+"\n");


        /////////////////////////////////////////////////////////

        bw.flush();
        bw.close();
        br.close();
    }
}



