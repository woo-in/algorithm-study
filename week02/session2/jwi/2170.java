import java.util.*;
import java.io.*;

public class Main
{

    private static class Point{
        public int start;
        public int end;

        Point(int start , int end){
            this.start = start;
            this.end = end;
        }

    }

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String args[]) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ////////////////////////////////////////////////////////

        // 1. 입력 , {시작점,끝점} 형태 객체의 배열로 저장
        int N = Integer.parseInt(br.readLine());
        Point[] lines = new Point[N];
        for(int i = 0 ; i < N ; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines[i] = new Point(start,end);
        }

        ////////////////////////////////////////////////////////

        // 2. 시작점 기준 오름차순 정렬
        Arrays.sort(lines , (o1,o2)->{
            return o1.start - o2.start;
        });

        ////////////////////////////////////////////////////////

        // 3. 알고리즘
        int sum = 0;
        int currentStart = lines[0].start;
        int currentEnd = lines[0].end;
        for(int i = 1 ; i < N ; i++) {

            int nextStart = lines[i].start;
            int nextEnd = lines[i].end;


            // case 3 : current 가 next 를 포함할 때
            // <------------> : current
            //     <------>   : next
            // <------------> : result
            if(nextEnd <= currentEnd) continue;

            // case 2 : current 와 next 가 겹치지 않을 때
            // <------> 			: current
            //           <------>   : next
            // 			 <------>   : result
            if(nextStart > currentEnd) {
                sum += currentEnd - currentStart;
                currentStart = nextStart;
                currentEnd = nextEnd;
                continue;
            }

            // case 1 : current 와 next 가 겹칠 때
            // <------> 			: current
            //      <------>   		: next
            // <----------->  		: result
            currentEnd = nextEnd;
        }

        // 마지막 합치기
        sum += currentEnd - currentStart;

        ////////////////////////////////////////////////////////

        // 4. 출력
        bw.write(sum+"");

        /////////////////////////////////////////////////////////

        bw.flush();
        bw.close();
        br.close();
    }
}



