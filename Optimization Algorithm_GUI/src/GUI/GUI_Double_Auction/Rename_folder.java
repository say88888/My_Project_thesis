package GUI.GUI_Double_Auction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Double_Auction.Read_Double_Auction;

public class Rename_folder{
	private static int N;
	private static int I;
	private static int K;

	private static int Case=1;
	private static boolean rename_Folder=false;
	
	public static void main() throws IOException, InterruptedException {
	
		Read_Double_Auction.main();
		
		N=Read_Double_Auction.getN();
		I=Read_Double_Auction.getI();
		K=Read_Double_Auction.getK();
				
		while( rename_Folder==false)
		{
			 rename_Folder() ;
		}
	}
	
	static void rename_Folder()  throws IOException, InterruptedException{
		 
	String oldPath=I_Set_Paths_for_Current_Simulation_Example.path();
	File f=new File(System.getProperty("user.dir"));
	String newPath=f.getAbsolutePath()+"\\input\\"+"N"+String.valueOf(N)+"_I"+String.valueOf(I)+"_K"+String.valueOf(K)+"_Case"+String.valueOf(Case);
	String filename="N"+String.valueOf(N)+"_I"+String.valueOf(I)+"_K"+String.valueOf(K)+"_Case"+String.valueOf(Case);
	
     Path p = Paths.get(newPath);    //路徑設定
     /*確認資料夾是否存在*/
     if (Files.exists(p)) {
         System.out.print("資料夾已存在");
         Case++;
     }
     if (!Files.exists(p)) {
         /*不存在的話,直接建立資料夾*/
 		new File(oldPath).renameTo(new File(newPath));
    	 
    	   if (Files.exists(p)) {
    	 rename_Folder=true;
    	   
    	 I_Set_Paths_for_Current_Simulation_Example.Setpath(newPath);
     	 I_Set_Paths_for_Current_Simulation_Example.setfilename(newPath);
    	 
    	 System.out.println("newPath="+newPath);
    	 System.out.println("I_Set_Paths_for_Current_Simulation_Example="+I_Set_Paths_for_Current_Simulation_Example.path());
    	 System.out.println("I_Set_Paths_for_Current_Simulation_Example="+I_Set_Paths_for_Current_Simulation_Example.filename());
    	   }
    }
	}
}
