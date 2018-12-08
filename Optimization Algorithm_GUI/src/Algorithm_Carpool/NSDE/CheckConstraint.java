package Algorithm_Carpool.NSDE;

import Input_Output_txt.Carpool.Read_BPL_TXT;
import Input_Output_txt.Carpool.Read_CarpoolData_Generation_Mode;
import Input_Output_txt.Carpool.Read_file;

	public class CheckConstraint  extends NSDE {
		public static void CheckConstraints(){
			int s=0,s1=0;
			   double[][] y=new double[P][];
			    for(int i=0;i<P;i++)
			    	y[i]=new double[Read_file.getHp(i)];
			    double[][] x =new double[D][];
			    for(int i=0;i<D;i++)
			    	x[i]=new double[Read_file.getJd(i)];
			    
			 for (int i = 0; i <D ; i++) 
		   	  for(int j=0;j<x[i].length;j++)
		   	x[i][j]=X(s++);	     
			 for (int i = 0; i < P ; i++) 
			   	  for(int j=0;j<y[i].length;j++)
			   	y[i][j]=Y(s1++);	   
			 System.out.println();

			 System.out.println("限制式 2-2");
			 int st2=0,st22=0;
			 for(int k=0;k<K;k++){
				 for(int d=0;d<D;d++)
					 for(int j=0;j<x[d].length;j++)
						 st2+=x[d][j]*Read_file.getqdjk(d, j, k);
				
				 for(int p=0;p<P;p++)
					 for(int h=0;h<y[p].length;h++)
						 st22+=y[p][h]*Read_file.getSphk(p, h, k);
			
				 if(st2-st22>=0)
					 System.out.println("K="+(k+1)+" "+"True "+(st2-st22));
				 else
					 System.out.println("K="+(k+1)+" "+"False "+(st2-st22));
				 st2=0;
				 st22=0;
			 }
			 System.out.println();
			 System.out.println("限制式 2-3");
			 int st3=0,st32=0;
			 for(int p=0;p<P;p++)
				 for(int h=0;h<y[p].length;h++)
					 st3+=y[p][h]*Read_file.getfph(p, h);
			 
			 for(int d=0;d<D;d++)
				 for(int j=0;j<x[d].length;j++)
					 st32+=x[d][j]*(Read_file.getCdj(d, j)-Read_file.getOdj(d, j));
				 
			if(st3>=st32)
				System.out.println("True "  +(st3-st32));
			else
				System.out.println("False " +(st3-st32));
			
			 System.out.println();
			 System.out.println("限制式 2-4");
			 int st4=0;
			 for(int d=0;d<D;d++)
				for(int j=0;j<x[d].length;j++){
			 
					for(int k=0;k<K;k++)
						st4+=x[d][j]*Read_file.getqdjk(d, j, k);
			 
					if(st4<=Read_file.getadj(d, j))
						System.out.println("Dx="+(d+1)+" Jd="+(j+1)+" True "+(Read_file.getadj(d,j)-st4));
					else
						System.out.println("Dx="+(d+1)+" Jd="+(j+1)+" False "+(Read_file.getadj(d, j)-st4));
					st4=0;
				}
			 System.out.println();
			 System.out.println("限制式 2-5");
			 int st5=0;
			 for(int d=0;d<D;d++)
				for(int j=0;j<x[d].length;j++){
			 
					for(int k=0;k<K;k++)
						st5+=x[d][j]*Read_file.getWqdjk(d, j, k);
			 
					if(st5<=Read_file.getldj(d, j))
						System.out.println("Dx="+(d+1)+" Jd="+(j+1)+" True "+(Read_file.getldj(d,j)-st5));
					else
						System.out.println("Dx="+(d+1)+" Jd="+(j+1)+" False "+(Read_file.getldj(d, j)-st5));
					st5=0;
				}
			 System.out.println();
			 System.out.println("限制式 2-6");
			 int st6=0;
			 for(int d=0;d<D;d++){
				 for(int j=0;j<x[d].length;j++)
					 st6+=x[d][j];
				 if(st6<=1)
					 System.out.println("Dx="+(d+1)+" True "+st6);
				 else
					 System.out.println("Dx="+(d+1)+" False "+st6);
				 st6=0;
			 }
			 System.out.println("限制式 2-14");
			 if((Omega_4*(1-Epsilon1)*Object_Function.get_ads()) <= (Omega_4*Object_Function.get_aps())
						&& (Omega_4*Object_Function.get_aps()) >= (Omega_4*(1-Epsilon1)*Object_Function.get_ads())
						&& (Omega_4*Object_Function.get_aps()) <= (Omega_4*(1+Epsilon2)*Object_Function.get_ads()))
						 { System.out.println("True ");}
						 else
						 { System.out.println("False ");}
			
			 System.out.println("限制式 2-15");
			 if((Omega_7*(1-Epsilon3)*Object_Function.get_cp_d()) <= (Omega_7*Object_Function.get_cp_p())
						&& (Omega_7*Object_Function.get_cp_p()) >= (Omega_7*(1-Epsilon3)*Object_Function.get_cp_d())
						&& (Omega_7*Object_Function.get_cp_p()) <= (Omega_7*(1+Epsilon4)*Object_Function.get_cp_d()))
						 { System.out.println("True ");}
						 else
						 { System.out.println("False ");}
			 
			if(Read_CarpoolData_Generation_Mode.mode().contains("multi_hop")){
				
					for(int p=0;p<Read_BPL_TXT.Bpl().size();p++){
						int a=0;
						for(int j=0;j<Read_BPL_TXT.Bpl().get(p).size();j++){
							double s8=0,s9=0;
							for(int k=0;k<Read_BPL_TXT.Bpl().get(p).get(j);k++){
								s8+=y[p][a];
								s9+=(1-y[p][a]);
								a+=1;
							}
							if((s8*s9)!=0)
								System.out.println(" False");
							else
								System.out.println(" True");
						}
					}
					 
					for(int p=0;p<Read_BPL_TXT.Bpl().size();p++){
						int a=0;
						 double s11=0;
						for(int j=0;j<Read_BPL_TXT.Bpl().get(p).size();j++){
							double s10=1;
							for(int k=0;k<Read_BPL_TXT.Bpl().get(p).get(j);k++){
								s10*=y[p][a];
								a+=1;
							}
							s11+=s10;
						}	
						if(s11>1)
							System.out.println(" False");
						else
							System.out.println(" True");
					}
					}
		}
	}