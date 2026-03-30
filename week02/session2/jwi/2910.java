import java.util.*;
import java.io.*;






public class Main
{

    static class Element {
        public int number;
        public int count;
        public int initIdx;

        public Element(int number , int count , int initIdx){
            this.number = number;
            this.count = count ;
            this.initIdx = initIdx;
        }
    }



    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String args[]) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // O(N^2) , N 은 1000 이하

        ////////////////////////////////////////////////////////

        // 1. 입력
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());

        String numbers = br.readLine();
        StringTokenizer numberTokens = new StringTokenizer(numbers);

        /////////////////////////////////////////////////////////

        // 2. 숫자들을 순회하면서 {숫자 , 횟수 , 초기 인덱스 } 형태로 리스트에 저장
        ArrayList<Element> list = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            if(!numberTokens.hasMoreTokens()) break;

            int currentNumber = Integer.parseInt(numberTokens.nextToken());

            boolean isExist = false;

            // 존재하는 숫자 였다면 : count + 1
            for(int listI = 0 ; listI <list.size() ; listI++) {
                if(list.get(listI).number == currentNumber) {
                    list.get(listI).count++;
                    isExist = true;
                }
            }

            // 존재하지 않은 숫자 였다면 : {숫자 , 횟수:1 , 초기 인덱스 } 형태로 저장
            if(!isExist) list.add(new Element(currentNumber , 1 , i));
        }

        /////////////////////////////////////////////////////////

        // 3. 정렬
        Collections.sort(list , (o1,o2)->{

            // 우선순위 1 : 횟수 , 내림차순
            if(o1.count != o2.count) return o2.count - o1.count ;

            // 우선순위 2 : 초기인덱스 , 오름차순
            return o1.initIdx - o2.initIdx;
        });

        /////////////////////////////////////////////////////////

        // 4. 리스트 순회하며 숫자를 횟수만큼 출력
        for(int i = 0 ; i < list.size() ; i++) {

            int printNumber = list.get(i).number;
            int printCount = list.get(i).count;

            for(int c = 0 ; c < printCount ; c++) {
                bw.write(printNumber + " ");
            }

        }

        /////////////////////////////////////////////////////////

        bw.flush();
        bw.close();
        br.close();
    }
}



