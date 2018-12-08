package Generate_random_data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import GUI.I_Set_Paths_for_Current_Simulation_Example;

public class Read_Generate_random_Double_Auction {

		private static int Seller; // 產生賣方人數
		private static int Buyer; // 產生買方人數
		private static int K; // 產生物品數量
		private static int K_top; //  數量上限
		

		public static void main() throws ParseException, IOException {
			String str;
			String Parameter[][]; // 二維陣列
			Vector<String[]> str_vec = new Vector<String[]>(); // 暫存

			int i, j,k=0;

			// 讀取 Generate random Location TXT
				try {
					FileReader PBr = new FileReader(I_Set_Paths_for_Current_Simulation_Example.path()+"\\Generate_random\\double_action.txt");
					BufferedReader br = new BufferedReader(PBr);
					while ((str = br.readLine()) != null) { // 每次讀一行
						k++;
						str_vec.add(str.split(",")); // 將此行以空白(white space)切成字串陣列,存入 Vector暫存
					}
					br.close(); // 關檔
				} catch (Exception e) {
					e.printStackTrace();
				}

				Parameter = new String[str_vec.size()][]; // 產生二維陣列, 依據暫存的size(txt檔的行數)
				for (i = 0; i < str_vec.size(); i++)
					Parameter[i] = str_vec.elementAt(i); // 將暫存區每一個元素(一行裡的字串陣列)放入二維陣列

				Seller=Integer.parseInt(Parameter[0][0]);
				Buyer=Integer.parseInt(Parameter[1][0]);
				K=Integer.parseInt(Parameter[2][0]);
				K_top=Integer.parseInt(Parameter[3][0]);

		}

		public static int Seller() {
			return Seller;
		}

		public static int Buyer() {
			return Buyer;
		}

		public static int K() {
			return K;
		}
		
		public static int K_top() {
			return K_top;
		}

}
