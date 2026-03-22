import java.util.*;
import java.io.*;


public class Main
{

	private static BufferedReader br;
	private static BufferedWriter bw;


	public static void main(String args[]) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));


		// 시간복잡도 : O(NlogN) , N : 10만

		///////////////////////////////////////////////////////////////

		// 1. HashSet 사용해서 , (enter,leave) 시뮬레이션
		HashSet<String> current = new HashSet<>();
		int n = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < n ; i++) {
			String record = br.readLine();
			StringTokenizer st = new StringTokenizer(record);

			String name = st.nextToken();
			boolean isEnter = judge(st.nextToken());

			if(isEnter) {
				current.add(name);
			}
			else {
				current.remove(name);
			}
		}

		///////////////////////////////////////////////////////////////

		// 2. 남아있는 사람 이름 역순 정렬
		List<String> list = new ArrayList<>(current);
		Collections.sort(list , Collections.reverseOrder());


		///////////////////////////////////////////////////////////////

		// 3. 출력
		for(int i = 0 ; i < list.size() ; i++) {
			bw.write(list.get(i) + "\n");
		}

		///////////////////////////////////////////////////////////////

		bw.flush();
		bw.close();
		br.close();

	}







	public static boolean judge(String enterOrleave) {
		if(enterOrleave.equals("enter")) {
			return true;
		}
		else return false;
	}
}

	 


	 
	
	


