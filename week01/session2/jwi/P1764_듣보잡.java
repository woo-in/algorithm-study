import java.util.*;
import java.io.*;


public class Main
{

	private static BufferedReader br;
	private static BufferedWriter bw;


	public static void main(String args[]) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 시간 복잡도 : N : 500000 , O(NlogN)

		/////////////////////////////////////////////////////////

		// 0. 입력
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		/////////////////////////////////////////////////////////

		// 1. 듣을 HashSet 삽입 O(N)
		HashSet<String> set = new HashSet<>();
		for(int i = 0 ; i < N ; i++) {
			set.add(br.readLine());
		}

		/////////////////////////////////////////////////////////


		// 2. 보를 사용해 검색 O(N)  , 검색이 되면 List 추가
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0 ; i < M ; i++) {

			String notLook = br.readLine();

			if(set.contains(notLook)) {
				list.add(notLook);
			}
		}

		/////////////////////////////////////////////////////////

		// 3. List 정렬 O(NlogN)
		Collections.sort(list);

		/////////////////////////////////////////////////////////

		// 5. 출력
		bw.write(list.size() + "\n");
		for(int i = 0 ; i < list.size() ; i++) {
			bw.write(list.get(i) + "\n");
		}

		/////////////////////////////////////////////////////////

		bw.flush();
		bw.close();
		br.close();
	}
}

	 


	 
	
	


