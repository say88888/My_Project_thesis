package Make_Excel.Carpool;

import Generate_random_data.File_funtion;

public class Create_Data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String newPath="C:\\Users\\say88888\\Desktop\\Optimization Algorithm_GUI\\input\\";
		
		String newName;
		String oldName;
		
		for(int D=40;D<45;D+=5){
			int P=D;
			
			for(int pop=10;pop<20;pop+=10){
			
		for(int i=2;i<11;i++)
		{
			if(i<10){
			 newName=newPath+"D"+D+"P"+P+"Case1_OTO_Omega1_pop"+pop+"_Run0"+i;
			
			 oldName=newPath+"D"+D+"P"+P+"Case1_OTO_Omega1_pop"+pop+"_Run01";
			
			File_funtion.copyFolder(oldName,newName);
			}
			if(i==10){
				
				 newName=newPath+"D"+D+"P"+P+"Case1_OTO_Omega1_pop"+pop+"_Run"+i;
				
				 oldName=newPath+"D"+D+"P"+P+"Case1_OTO_Omega1_pop"+pop+"_Run01";
				
				File_funtion.copyFolder(oldName,newName);
				
				}
			}
		}
		}
		System.out.print("End");
		
	}

}
