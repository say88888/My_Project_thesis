package Make_Carpool_data;

import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import GUI.GUI_Carpool.X_Select_Algorithm_Type_to_Solve_the_Problem;
import Generate_random_data.Read_Generate_random;
import Input_Output_txt.Carpool.check_batch_TXT;

public class make_result {

		public static	void makeresult1(double route,double cost,double route_B,double cost_B,double route_BB,double route_ad)throws Exception {
	
			String path = null;
			
			if(GUI.main.getmethod()!=2)
			{
			   FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
					   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"carpool_result.txt",false);
			   
			   fw1.write("決策前整體路徑及成本: "+"總距離: "+String.valueOf(route/1000)+"總成本: "+String.valueOf(cost)+"\r\n");
			   fw1.write("決策後整體路徑及成本: "+"總距離: "+String.valueOf(route_B/1000)+"總成本: "+String.valueOf(cost_B)+"\r\n");
			   fw1.write("計算出[(a)+(b)]/(c)的值: "+String.valueOf(route_BB)+"\r\n");
			   fw1.write("計算出[a/d的值: "+String.valueOf(route_ad));
			    fw1.write("\r\n");
				fw1.close();
			}
			
			else if(GUI.main.getmethod()==2)
			{
				int N=check_batch_TXT.getN1();
				String path2 = check_batch_TXT.getString(N);
				
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
				{path="PSO1_Batch"; 
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
				{path="PSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
				{path="PSO3_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
				{path="PSO4_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
				{path="APSO1_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
				{path="APSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				   FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\carpool_result.txt",false);
				   
				   fw1.write("決策前整體路徑及成本: "+"總距離: "+String.valueOf(route/1000)+"總成本: "+String.valueOf(cost)+"\r\n");
				   fw1.write("決策後整體路徑及成本: "+"總距離: "+String.valueOf(route_B/1000)+"總成本: "+String.valueOf(cost_B)+"\r\n");
				   fw1.write("計算出[(a)+(b)]/(c)的值: "+String.valueOf(route_BB)+"\r\n");
				   fw1.write("計算出[a/d的值: "+String.valueOf(route_ad));
				    fw1.write("\r\n");
					fw1.close();
			}
	    }
		
		
		public static	void makeresult2(int k,int l,float kl)throws Exception {
		
			String path = null;
			if(GUI.main.getmethod()!=2){
			   FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
					   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"carpool_result.txt",true);
	   
			   	fw1.write("整體共乘人數: "+String.valueOf(k)+"\r\n");
			   	fw1.write("整體座位數: "+String.valueOf(l)+"\r\n");
			   	fw1.write("計算出整體使用率的值: "+String.valueOf(kl));
			   	fw1.write("\r\n");
			   	fw1.close();
		}
			else if(GUI.main.getmethod()==2)
			{
				int N=check_batch_TXT.getN1();
				String path2 = check_batch_TXT.getString(N);
				
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
				{path="PSO1_Batch"; 
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
				{path="PSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
				{path="PSO3_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
				{path="PSO4_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
				{path="APSO1_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
				{path="APSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				   FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\carpool_result.txt",true);
							   
				   fw1.write("整體共乘人數: "+String.valueOf(k)+"\r\n");
				   fw1.write("整體座位數: "+String.valueOf(l)+"\r\n");
				   fw1.write("計算出整體使用率的值: "+String.valueOf(kl));
				    fw1.write("\r\n");
				    fw1.write("\r\n");
					fw1.close();
			}
		
	    }
		
		
		public static	void makeresult3(long time)throws Exception {
				
			String path = null;
			float a=time/1000/60;
			
			if(GUI.main.getmethod()!=2){
			FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
					   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"carpool_result.txt",true);
			
				fw1.write("執行時間: "+String.valueOf(a)+"\r\n");
			    fw1.write("\r\n");
				fw1.close();
			    }
			
			else if(GUI.main.getmethod()==2)
			{
				int N=check_batch_TXT.getN1();
				String path2 = check_batch_TXT.getString(N);
				
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
				{path="PSO1_Batch"; 
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
				{path="PSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
				{path="PSO3_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
				{path="PSO4_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
				{path="APSO1_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
				{path="APSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				   FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\carpool_result.txt",true);
				   fw1.write("執行時間: "+String.valueOf(a)+"\r\n");
				    fw1.write("\r\n");
					fw1.close();
			}
			
		}
		
		public static	void makecarpool_allocate_surplus_before0(double cost)throws Exception {
			
			String path = null;
			
			if(GUI.main.getmethod()!=2){
			FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
					   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"carpool_allocate_surplus.txt",false);
			   fw.write("以共乘前各自的距離去分配餘額"+"\r\n");
			   fw.write("總利潤:"+String.valueOf(cost)+"元"+"\r\n");
			    fw.write("\r\n");
				fw.close();
			}
			else if(GUI.main.getmethod()==2)
			{
				int N=check_batch_TXT.getN1();
				String path2 = check_batch_TXT.getString(N);
				
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
				{path="PSO1_Batch"; 
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
				{path="PSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
				{path="PSO3_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
				{path="PSO4_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
				{path="APSO1_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
				{path="APSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				   FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\carpool_allocate_surplus.txt",false);
				   fw.write("以共乘前各自的距離去分配餘額"+"\r\n");
				   fw.write("總利潤:"+String.valueOf(cost)+"元"+"\r\n");
				    fw.write("\r\n");
					fw.close();
			}
			
				
			    }
		
		public static	void makecarpool_allocate_surplus_before(String d_ID,String string,String d)throws Exception {
			
			String path = null;			
			if(GUI.main.getmethod()!=2){
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
						   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"carpool_allocate_surplus.txt",true);
				
			   fw.write("司機"+String.valueOf(d_ID)+" 分配率"+String.valueOf(string)+"%"+"利潤分配 "+String.valueOf(d));
			    fw.write("\r\n");
				fw.close();
			}
				else if(GUI.main.getmethod()==2)
				{
					int N=check_batch_TXT.getN1();
					String path2 = check_batch_TXT.getString(N);
					
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
					{path="PSO1_Batch"; 
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
					{path="PSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
					{path="PSO3_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
					{path="PSO4_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
					{path="APSO1_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
					{path="APSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\carpool_allocate_surplus.txt",true);
						
				   fw.write("司機"+String.valueOf(d_ID)+" 分配率"+String.valueOf(string)+"%"+"利潤分配 "+String.valueOf(d));
				    fw.write("\r\n");
					fw.close();
				}
			
		  }
		
		
		public static	void makecarpool_allocate_surplus_before1(String p_ID,String string,String d)throws Exception {
			
			String path = null;
			if(GUI.main.getmethod()!=2){
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
						   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"carpool_allocate_surplus.txt",true);
				
				   fw.write("乘客"+String.valueOf(p_ID)+" 分配率"+String.valueOf(string)+"%"+"利潤分配 "+String.valueOf(d));
				    fw.write("\r\n");
					fw.close();
			}
				else if(GUI.main.getmethod()==2)
				{
					int N=check_batch_TXT.getN1();
					String path2 = check_batch_TXT.getString(N);
					
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
					{path="PSO1_Batch"; 
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
					{path="PSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
					{path="PSO3_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
					{path="PSO4_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
					{path="APSO1_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
					{path="APSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
			
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\carpool_allocate_surplus.txt",true);
						
				   fw.write("乘客"+String.valueOf(p_ID)+" 分配率"+String.valueOf(string)+"%"+"利潤分配 "+String.valueOf(d));
				    fw.write("\r\n");
					fw.close();
				}
				
			    }
		
			
		public static	void makecarpool_allocate_surplus()throws Exception {
			
			String path = null;
			
			if(GUI.main.getmethod()!=2){
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
						   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"carpool_allocate_surplus.txt",true);
				
				   fw.write("--------------------------------------------------");
				    fw.write("\r\n");
					fw.close();
			}
				else if(GUI.main.getmethod()==2)
				{
					int N=check_batch_TXT.getN1();
					String path2 = check_batch_TXT.getString(N);
					
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
					{path="PSO1_Batch"; 
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
					{path="PSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
					{path="PSO3_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
					{path="PSO4_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
					{path="APSO1_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
					{path="APSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\carpool_allocate_surplus.txt",true);
						
				 fw.write("--------------------------------------------------");
				    fw.write("\r\n");
					fw.close();
				}
	    }
		
		  
		public static	void makecarpool_allocate_surplus_after0(double cost)throws Exception {
			
			String path = null;
			
			if(GUI.main.getmethod()!=2){
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
						   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"carpool_allocate_surplus.txt",true);
				   fw.write("以共乘前各自的距離去分配餘額"+"\r\n");
				   fw.write("總利潤:"+String.valueOf(cost)+"元"+"\r\n");
				    fw.write("\r\n");
					fw.close();
				}
				else if(GUI.main.getmethod()==2)
				{
					int N=check_batch_TXT.getN1();
					String path2 = check_batch_TXT.getString(N);
					
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
					{path="PSO1_Batch"; 
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
					{path="PSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
					{path="PSO3_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
					{path="PSO4_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
					{path="APSO1_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
					{path="APSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					   FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\carpool_allocate_surplus.txt",true);
					   fw.write("以共乘前各自的距離去分配餘額"+"\r\n");
					   fw.write("總利潤:"+String.valueOf(cost)+"元"+"\r\n");
					    fw.write("\r\n");
						fw.close();
				}
			    }
		
		public static	void makecarpool_allocate_surplus_after(String d_ID,String string,double d)throws Exception {
			
			String path = null;
			
			if(GUI.main.getmethod()!=2){
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
						   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"carpool_allocate_surplus.txt",true);
				
			   fw.write("司機"+String.valueOf(d_ID)+" 分配率"+String.valueOf(string)+"%"+"利潤分配 "+String.valueOf(d));
			    fw.write("\r\n");
				fw.close();
			}
				else if(GUI.main.getmethod()==2)
				{
					int N=check_batch_TXT.getN1();
					String path2 = check_batch_TXT.getString(N);
					
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
					{path="PSO1_Batch"; 
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
					{path="PSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
					{path="PSO3_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
					{path="PSO4_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
					{path="APSO1_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
					{path="APSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\carpool_allocate_surplus.txt",true);
						
				   fw.write("司機"+String.valueOf(d_ID)+" 分配率"+String.valueOf(string)+"%"+"利潤分配 "+String.valueOf(d));
				    fw.write("\r\n");
					fw.close();
				}
			    }
		
			
		public static	void makecarpool_allocate_surplus_after1(String p_ID,String string,double d)throws Exception {
			
			String path = null;
			
			if(GUI.main.getmethod()!=2){
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
						   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"carpool_allocate_surplus.txt",true);
				
				   fw.write("乘客"+String.valueOf(p_ID)+" 分配率"+String.valueOf(string)+"%"+"利潤分配 "+String.valueOf(d));
				    fw.write("\r\n");
					fw.close();
			}
				else if(GUI.main.getmethod()==2)
				{
					int N=check_batch_TXT.getN1();
					String path2 = check_batch_TXT.getString(N);
					
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
					{path="PSO1_Batch"; 
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
					{path="PSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
					{path="PSO3_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
					{path="PSO4_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
					{path="APSO1_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
					{path="APSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
				FileWriter fw = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\carpool_allocate_surplus.txt",true);
						
				   fw.write("乘客"+String.valueOf(p_ID)+" 分配率"+String.valueOf(string)+"%"+"利潤分配 "+String.valueOf(d));
				    fw.write("\r\n");
					fw.close();
			    }
		}

		
		public static	void makereport1(double route,double cost,double route_B,double cost_B,double route_BB,double route_ad)throws Exception {
			
			Read_Generate_random.main();
			
			String path = null;
			if(GUI.main.getmethod()!=2){
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\CPLEX\\")){path="CPLEX";}
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\GA1\\")){path="GA1";}
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\GA2\\")){path="GA2";}
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\")){path="PSO1";}
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\")){path="PSO2";}
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\")){path="PSO3";}
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\")){path="PSO4";}
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\")){path="APSO1";}
			if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\")){path="APSO2";}
			   FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path+".txt",false);
			  
			   fw1.write(String.valueOf(I_Set_Paths_for_Current_Simulation_Example.filename())+" ");
			   
			   fw1.write(String.valueOf( Read_Generate_random.D())+" "+String.valueOf( Read_Generate_random.P())+" ");
			   
			   fw1.write(String.valueOf(route/1000)+"/"+String.valueOf(cost)+" ");
			   fw1.write(String.valueOf(route_B/1000)+"/"+String.valueOf(cost_B)+" ");
			   fw1.write(String.valueOf(route_BB)+" ");
			   fw1.write(String.valueOf(route_ad)+" ");
				fw1.close();
			}
				else if(GUI.main.getmethod()==2)
				{
					int N=check_batch_TXT.getN1();
					String path2 = check_batch_TXT.getString(N);
					
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
					{path="PSO1_Batch"; 
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
					{path="PSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
					{path="PSO3_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
					{path="PSO4_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
					{path="APSO1_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
					{path="APSO2_Batch";
					File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
					 f1.mkdir();
					}
			
				FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\"+path+".txt",false);
				   fw1.write(String.valueOf(route/1000)+"/"+String.valueOf(cost)+" ");
				   fw1.write(String.valueOf(route_B/1000)+"/"+String.valueOf(cost_B)+" ");
				   fw1.write(String.valueOf(route_BB)+" ");
				   fw1.write(String.valueOf(route_ad)+" ");
					fw1.close();
		}
		}
				
				
				public static	void makereport2(int k,int l,float kl)throws Exception {
					
					String path = null;
				if(GUI.main.getmethod()!=2){
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\CPLEX\\")){path="CPLEX";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\GA1\\")){path="GA1";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\GA2\\")){path="GA2";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\")){path="PSO1";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\")){path="PSO2";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\")){path="PSO3";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\")){path="PSO4";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\")){path="APSO1";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\")){path="APSO2";}
					FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path+".txt",true);
					   
			   fw1.write(String.valueOf(k)+" ");
			   fw1.write(String.valueOf(l)+" ");
			   fw1.write(String.valueOf(kl)+" ");
				fw1.close();
				}
				else if(GUI.main.getmethod()==2)
				{
				int N=check_batch_TXT.getN1();
				String path2 = check_batch_TXT.getString(N);
				
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
				{path="PSO1_Batch"; 
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
				{path="PSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
				{path="PSO3_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
				{path="PSO4_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
				{path="APSO1_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
				{path="APSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
			FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\"+path+".txt",true);
			   fw1.write(String.valueOf(k)+" ");
			   fw1.write(String.valueOf(l)+" ");
			   fw1.write(String.valueOf(kl)+" ");
				fw1.close();
				}
			}
				
				public static	void makereport3(long time)throws Exception {
						
					float a=time/1000/60;
					
					String path = null;
					if(GUI.main.getmethod()!=2){
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\CPLEX\\")){path="CPLEX";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\GA1\\")){path="GA1";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\GA2\\")){path="GA2";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\")){path="PSO1";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\")){path="PSO2";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\")){path="PSO3";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\")){path="PSO4";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\")){path="APSO1";}
					if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\")){path="APSO2";}
					   FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path+".txt",false);
					   fw1.write(String.valueOf(a));
						fw1.close();
			  }
					else if(GUI.main.getmethod()==2)
					{
						int N=check_batch_TXT.getN1();
						String path2 = check_batch_TXT.getString(N);
						
						if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
						{path="PSO1_Batch"; 
						File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
						 f1.mkdir();
						}
						if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
						{path="PSO2_Batch";
						File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
						 f1.mkdir();
						}
						if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
						{path="PSO3_Batch";
						File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
						 f1.mkdir();
						}
						if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
						{path="PSO4_Batch";
						File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
						 f1.mkdir();
						}
						if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
						{path="APSO1_Batch";
						File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
						 f1.mkdir();
						}
						if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
						{path="APSO2_Batch";
						File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
						 f1.mkdir();
						}
						FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\"+path+".txt",false);
						fw1.write(String.valueOf(a));
					}
					
					
			}
				

				public static	void makereportX(int[] Xd, int[] Xj, int[] Xdj)throws Exception {
						
					String path = null;
				
			if(GUI.main.getmethod()!=2){
						FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
								   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"ReportX.txt",false);
					   
					   for(int i=0;i<Xdj.length;i++)
					   {
						   fw1.write(String.valueOf(Xd[i])+" ");
						   fw1.write(String.valueOf(Xj[i])+" ");
						   fw1.write(String.valueOf(Xdj[i]));
						   fw1.write("\r\n");
					   }
						fw1.close();
			}
			else if(GUI.main.getmethod()==2)
			{
				int N=check_batch_TXT.getN1();
				String path2 = check_batch_TXT.getString(N);
				
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
				{path="PSO1_Batch"; 
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
				{path="PSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
				{path="PSO3_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
				{path="PSO4_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
				{path="APSO1_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
				{path="APSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\"+"ReportX.txt",false);
				
				for(int i=0;i<Xdj.length;i++)
				   {
					   fw1.write(String.valueOf(Xd[i])+" ");
					   fw1.write(String.valueOf(Xj[i])+" ");
					   fw1.write(String.valueOf(Xdj[i]));
					   fw1.write("\r\n");
				   }
					fw1.close();
				
			}
			
			}
				

				public static	void makereportY(int[] Yp, int[] Yh, int[] Yph)throws Exception {
					
					String path = null;
					
					if(GUI.main.getmethod()!=2){
						FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
								   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"ReportY.txt",false);
					   
						   for(int i=0;i<Yph.length;i++)
						   {
							   fw1.write(String.valueOf(Yp[i])+" ");
							   fw1.write(String.valueOf(Yh[i])+" ");
							   fw1.write(String.valueOf(Yph[i]));
							   fw1.write("\r\n");
						   }
							fw1.close();
						}
					
			else if(GUI.main.getmethod()==2)
			{
				int N=check_batch_TXT.getN1();
				String path2 = check_batch_TXT.getString(N);
				
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
				{path="PSO1_Batch"; 
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
				{path="PSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
				{path="PSO3_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
				{path="PSO4_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
				{path="APSO1_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
				{path="APSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\"+"ReportY.txt",false);
				
				   for(int i=0;i<Yph.length;i++)
				   {
					   fw1.write(String.valueOf(Yp[i])+" ");
					   fw1.write(String.valueOf(Yh[i])+" ");
					   fw1.write(String.valueOf(Yph[i]));
					   fw1.write("\r\n");
				   }
					fw1.close();
			  }
		}
				

				public static	void makeRideSharingDetails(int Xd, int Xj,String up_down,double B,double r,
						double Br,double driverBids, double reward1,double reward2,double reward3,double reward4,double  distance,int time,double Ratio)throws Exception {
						
					String path = null;
					DecimalFormat df = new DecimalFormat("##.###");
					if(GUI.main.getmethod()!=2){
						FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
								   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"RideSharingDetails.txt",false);
					   
						 fw1.write("("+String.valueOf(Xd)+","+String.valueOf(Xj)+")"+ up_down+" "
								   +String.valueOf(B)+" "
								   +String.valueOf(r)+" "
								   +String.valueOf(df.format(Br))+" "
								   +String.valueOf(driverBids)+" "
								   +String.valueOf(df.format(reward1))+" "                  
								   +String.valueOf(df.format(reward1/driverBids))+" "
								   +String.valueOf(df.format(reward2))+" "
								   +String.valueOf(df.format(reward2/driverBids))+" "
								   +String.valueOf(df.format(reward3))+" "
								   +String.valueOf(df.format(reward3/driverBids))+" "
								   +String.valueOf(df.format(reward4))+" "
								   +String.valueOf(df.format(reward4/driverBids))+" "
								   +String.valueOf(distance)+" "
								   +String.valueOf(time)+" "
								   + String.valueOf(df.format(Ratio))+"\r\n");
						   
						   fw1.close();
						}
					
			else if(GUI.main.getmethod()==2)
			{
				int N=check_batch_TXT.getN1();
				String path2 = check_batch_TXT.getString(N);
				
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
				{path="PSO1_Batch"; 
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
				{path="PSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
				{path="PSO3_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
				{path="PSO4_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
				{path="APSO1_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
				{path="APSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\"+"RideSharingDetails.txt",false);
				
				 fw1.write("("+String.valueOf(Xd)+","+String.valueOf(Xj)+")"+ up_down+" "
						   +String.valueOf(B)+" "
						   +String.valueOf(r)+" "
						   +String.valueOf(df.format(Br))+" "
						   +String.valueOf(driverBids)+" "
						   +String.valueOf(df.format(reward1))+" "
						   +String.valueOf(df.format(reward1/driverBids))+" "
						   +String.valueOf(df.format(reward2))+" "
						   +String.valueOf(df.format(reward2/driverBids))+" "
						   +String.valueOf(df.format(reward3))+" "
						   +String.valueOf(df.format(reward3/driverBids))+" "
						   +String.valueOf(df.format(reward4))+" "
						   +String.valueOf(df.format(reward4/driverBids))+" "
						   +String.valueOf(distance)+" "
						   +String.valueOf(time)+" "
						   + String.valueOf(df.format(Ratio))+"\r\n");
				   
				   fw1.close();
			}		
		  }
				

				public static	void makeRideSharingDetails1(int Xd, int Xj,String up_down,double B,double r,
						double Br,double driverBids, double reward1,double reward2,double reward3,double reward4,double  distance,int time,double Ratio)throws Exception {
						

					String path = null;
					DecimalFormat df = new DecimalFormat("##.###");
					if(GUI.main.getmethod()!=2){
						FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
								   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"RideSharingDetails.txt",true);
					   
						 fw1.write("("+String.valueOf(Xd)+","+String.valueOf(Xj)+")"+ up_down+" "
								   +String.valueOf(B)+" "
								   +String.valueOf(r)+" "
								   +String.valueOf(df.format(Br))+" "
								   +String.valueOf(driverBids)+" "
								   +String.valueOf(df.format(reward1))+" "
								   +String.valueOf(df.format(reward1/driverBids))+" "
								   +String.valueOf(df.format(reward2))+" "
								   +String.valueOf(df.format(reward2/driverBids))+" "
								   +String.valueOf(df.format(reward3))+" "
								   +String.valueOf(df.format(reward3/driverBids))+" "
								   +String.valueOf(df.format(reward4))+" "
								   +String.valueOf(df.format(reward4/driverBids))+" "
								   +String.valueOf(distance)+" "
								   +String.valueOf(time)+" "
								   + String.valueOf(df.format(Ratio))+"\r\n");
						   
						   fw1.close();
						}
					
			else if(GUI.main.getmethod()==2)
			{
				int N=check_batch_TXT.getN1();
				String path2 = check_batch_TXT.getString(N);
				
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
				{path="PSO1_Batch"; 
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
				{path="PSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
				{path="PSO3_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
				{path="PSO4_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
				{path="APSO1_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
				{path="APSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\"+"RideSharingDetails.txt",true);
				
				 fw1.write("("+String.valueOf(Xd)+","+String.valueOf(Xj)+")"+ up_down+" "
						   +String.valueOf(B)+" "
						   +String.valueOf(r)+" "
						   +String.valueOf(df.format(Br))+" "
						   +String.valueOf(driverBids)+" "
						   +String.valueOf(df.format(reward1))+" "
						   +String.valueOf(df.format(reward1/driverBids))+" "
						   +String.valueOf(df.format(reward2))+" "
						   +String.valueOf(df.format(reward2/driverBids))+" "
						   +String.valueOf(df.format(reward3))+" "
						   +String.valueOf(df.format(reward3/driverBids))+" "
						   +String.valueOf(df.format(reward4))+" "
						   +String.valueOf(df.format(reward4/driverBids))+" "
						   +String.valueOf(distance)+" "
						   +String.valueOf(time)+" "
						   + String.valueOf(df.format(Ratio))+"\r\n");
				   
				   fw1.close();
				   }
	    }
				
		public static	void make_RideSharing() throws Exception {
	
					String path = null;

					if(GUI.main.getmethod()!=2){
						FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
								   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"RideSharingDetails.txt",true);
						   fw1.write("--------------------------------------------------------------------------------------------");
						    fw1.write("\r\n");
							fw1.close();
					}
				if(GUI.main.getmethod()==2){
				int N=check_batch_TXT.getN1();
				String path2 = check_batch_TXT.getString(N);
				
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
				{path="PSO1_Batch"; 
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
				{path="PSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
				{path="PSO3_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
				{path="PSO4_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
				{path="APSO1_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
				{path="APSO2_Batch";
				File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
				 f1.mkdir();
				}
				FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\"+"RideSharingDetails.txt",true);
				   fw1.write("--------------------------------------------------------------------------------------------");
				    fw1.write("\r\n");
					fw1.close();
 		}
		}
		
		
		public static	void makeEqution_Value(double V1, double V2,double V3, double V4, double W1, double W2, double W3, double W4)throws Exception {
			
			String path = null;
			
			if(GUI.main.getmethod()!=2){
				FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
						   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Eqution_Value.txt",false);
			   
				   fw1.write("V-1 = "+String.valueOf(V1)+"\r\n");
				   fw1.write("V-2 = "+String.valueOf(V2)+"\r\n");
				   fw1.write("V-3 = "+String.valueOf(V3)+"\r\n");
				   fw1.write("V-4 = "+String.valueOf(V4)+"\r\n");
				   fw1.write("W-1 = "+String.valueOf(W1)+"\r\n");
				   fw1.write("W-2 = "+String.valueOf(W2)+"\r\n");
				   fw1.write("W-3 = "+String.valueOf(W3)+"\r\n");
				   fw1.write("W-4 = "+String.valueOf(W4)+"\r\n");
				fw1.close();
				}
			
	else if(GUI.main.getmethod()==2)
	{
		int N=check_batch_TXT.getN1();
		String path2 = check_batch_TXT.getString(N);
		
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO1\\"))
		{path="PSO1_Batch"; 
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO2\\"))
		{path="PSO2_Batch";
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO3\\"))
		{path="PSO3_Batch";
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\PSO4\\"))
		{path="PSO4_Batch";
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO1\\"))
		{path="APSO1_Batch";
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		if(X_Select_Algorithm_Type_to_Solve_the_Problem.path().equals("\\APSO2\\"))
		{path="APSO2_Batch";
		File f1 = new File("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result");
		 f1.mkdir();
		}
		FileWriter fw1 = new FileWriter("output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()+"\\"+path+"\\"+path2+"\\"+"carpool_result"+"\\"+"Eqution_Value.txt",false);
		

			   fw1.write("V-1 = "+String.valueOf(V1)+"\r\n");
			   fw1.write("V-2 = "+String.valueOf(V2)+"\r\n");
			   fw1.write("V-3 = "+String.valueOf(V3)+"\r\n");
			   fw1.write("V-4 = "+String.valueOf(V4)+"\r\n");
			   fw1.write("W-1 = "+String.valueOf(W1)+"\r\n");
			   fw1.write("W-2 = "+String.valueOf(W2)+"\r\n");
			   fw1.write("W-3 = "+String.valueOf(W3)+"\r\n");
			   fw1.write("W-4 = "+String.valueOf(W4)+"\r\n");
			fw1.close();
	  }
}


}


