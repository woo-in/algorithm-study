import java.util.*;
import java.io.*;


public class Main
{

	private static BufferedReader br;
	private static BufferedWriter bw;


	public static void main(String args[]) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 시간복잡도 : O(N) , N : 100000

		//////////////////////////////////////////////////

		// 0. 입력
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		//////////////////////////////////////////////////

		// 1. 배열 , 해쉬 맵에 삽입
		String [] pocketMonsterArr = new String[N+1];
		HashMap<String , Integer> pocketMonsterMap = new HashMap<>();

		for(int i = 1 ; i <= N ; i++) {
			String pocketMonsterName = br.readLine();
			pocketMonsterArr[i] = pocketMonsterName;
			pocketMonsterMap.put(pocketMonsterName , i);
		}

		//////////////////////////////////////////////////

		// 2. 번호 -> 배열 사용 , 이름 -> 해쉬맵 사용 검색 , 출력
		for(int i = 0 ; i < M ; i++) {
			String search = br.readLine();
			// 정규 표현식 사용!
			Boolean isNumber = search.matches("\\d+");
			if(isNumber) {
				int pocketMonsterNumber = Integer.parseInt(search);
				bw.write(pocketMonsterArr[pocketMonsterNumber] + "\n");
			}
			else {
				String pocketMonsterName = search ;
				bw.write(pocketMonsterMap.get(pocketMonsterName) + "\n");
			}
		}

		//////////////////////////////////////////////////

		bw.flush();
		bw.close();
		br.close();

	}
}









