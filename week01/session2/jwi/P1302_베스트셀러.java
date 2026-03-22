import java.util.*;
import java.io.*;


public class Main
{

	private static BufferedReader br;
	private static BufferedWriter bw;


	public static class BookInfo{

		public String bookName;
		public int sales;

		public BookInfo(String bookName , int sales) {
			this.bookName = bookName;
			this.sales = sales;
		}

	}


	public static void main(String args[]) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 시간복잡도 : O(N^2) , N : 1000

		////////////////////////////////////////////////////////

		// 1. 리스트에 삽입
		List<BookInfo> bookInfoList = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < N ; i++) {

			String bookName = br.readLine();

			boolean isExist = false;
			for(int j = 0 ; j < bookInfoList.size() ; j++) {
				String currentbookName = bookInfoList.get(j).bookName;

				if(bookName.equals(currentbookName)) {
					// 기존에 존재 -> sales++
					bookInfoList.get(j).sales++;
					isExist = true;
					break;
				}
			}

			// 기존에 존재 X -> 새로 생성 , sales = 1
			if(!isExist) {
				bookInfoList.add(new BookInfo(bookName , 1));
			}
		}

		//////////////////////////////////////////////////////////

		// 2. 정렬
		// 우선순위 1 : 팔린 갯수
		// 우선순위 2 : 책 제목(사전순)
		Collections.sort(bookInfoList , (o1 , o2) -> {

			if(o1.sales != o2.sales)
				return o2.sales - o1.sales;

			return o1.bookName.compareTo(o2.bookName);
		});

		//////////////////////////////////////////////////////////

		// 3. 출력
		bw.write(bookInfoList.get(0).bookName);

		/////////////////////////////////////////////////////////

		bw.flush();
		bw.close();
		br.close();


	}

}









