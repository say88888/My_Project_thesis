package Algorithm_Carpool.PSO3;

import Input_Output_txt.Carpool.Read_file;

public class FitnessCalc extends PSO3{

	static double getFitness(G_Individual individual) {
    	boolean right=true;
    	int c=0;
	    double fitness = 0;
	    double[][] Y=new double[P][];
	    for(int i=0;i<P;i++)
	    	Y[i]=new double[Read_file.getHp(i)];
	    double[][] X =new double[D][];
	    for(int i=0;i<D;i++)
	    	X[i]=new double[Read_file.getJd(i)];
	    for (int i = 0; i < P ; i++) 
	    	  for(int j=0;j<Y[i].length;j++)
	    	Y[i][j]=individual.getGy(c++);	  
	
	       int b=0;
		    for (int i = 0; i < D ; i++) 
		    	  for(int j=0;j<X[i].length;j++)
		    		  X[i][j]=individual.getGx(b++);
	
		
		 double s1=0,s2=0,s3=0,s4=0;
	   	for (int i = 0; i < P ; i++) 
	    	  for(int j=0;j<Y[i].length;j++)
	    		  s1+=Y[i][j]*Read_file.getfph(i, j);
	       for (int i = 0; i < P ; i++) 
		    	  for(int j=0;j<Y[i].length;j++)
		    		  s3+=Y[i][j]*Read_file.getfph(i, j)*Read_file.getTpm();
		    for (int i = 0; i < D ; i++) 
	    	  for(int j=0;j<X[i].length;j++)
	    		  s2+=X[i][j]*(Read_file.getCdj(i, j)-Read_file.getOdj(i, j));
	    for (int i = 0; i < D ; i++) 
	    	  for(int j=0;j<X[i].length;j++)
	    		  s4+=X[i][j]*(Read_file.getCdj(i, j)-Read_file.getOdj(i, j))*Read_file.getTdm();
    	fitness=s1-s2+s3+s4;
  
	
    	return fitness;
    }
	
//F2(X,Y)
    static double getFitness1(Individual individual) {
    	boolean right=true;
    	int c=0;
	    double fitness = 0;
	    double[][] Y=new double[P][];
	    for(int i=0;i<P;i++)
	    	Y[i]=new double[Read_file.getHp(i)];
	    double[][] X =new double[D][];
	    for(int i=0;i<D;i++)
	    	X[i]=new double[Read_file.getJd(i)];
	    for (int i = 0; i < P ; i++) 
	    	  for(int j=0;j<Y[i].length;j++)
	    	Y[i][j]=individual.getY(c++);	  
	
	       int b=0;
		    for (int i = 0; i < D ; i++) 
		    	  for(int j=0;j<X[i].length;j++)
		    		  X[i][j]=individual.getX(b++);
	
		double st221=0,st222=0;
		 for(int k=0;k<K;k++){
		 	for(int d=0;d<D;d++)
		 		for(int j=0;j<X[d].length;j++)
				st221+=X[d][j]*Read_file.getqdjk(d, j, k);
		
			 for(int p=0;p<P;p++)
			 	for(int h=0;h<Y[p].length;h++)
			 		st222+=Y[p][h]*Read_file.getSphk(p, h, k);
			
			 if(st221<st222)
				right=false;
			 
			 st221=0;
			 st222=0;
		 }
		 double st231=0,st232=0;
		 
		 for(int p=0;p<P;p++)
			 for(int h=0;h<Y[p].length;h++)
				 st231+=Y[p][h]*Read_file.getfph(p, h);
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++)
				 st232+=X[d][j]*(Read_file.getCdj(d, j)-Read_file.getOdj(d, j));
		 if(st231<st232)
			 right=false;
		 
		 double st241=0;
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++){
				 for(int k=0;k<K;k++)
					 st241+=X[d][j]*Read_file.getqdjk(d, j, k);
				 if(st241>Read_file.getadj(d, j))
					 right=false;
				 st241=0;
				}
	
		 double st251=0 ;
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++){
				 for(int k=0;k<K;k++)
					 st251+=X[d][j]*Read_file.getWqdjk(d, j, k);
				 if(st251>Read_file.getldj(d, j))
					right=false;
				 st251=0;
				}
		 int st261=0;
		 for(int d=0;d<D;d++){
			 st261=0;
			 for(int j=0;j<X[d].length;j++){
				 st261+=X[d][j];
			 }
			 if(st261>1)
				 right=false;	 
		 }
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++)
				 if(X[d][j]>1 && X[d][j]<0)
					 right=false;
			
		 for(int p=0;p<P;p++)
			 for(int h=0;h<Y[p].length;h++)
				 if(Y[p][h]>1 && Y[p][h]<0)
					 right=false;
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(right==true){
		 double s1=0,s2=0,s3=0,s4=0;
	   	for (int i = 0; i < P ; i++) 
	    	  for(int j=0;j<Y[i].length;j++)
	    		  s1+=Y[i][j]*Read_file.getfph(i, j);
	       for (int i = 0; i < P ; i++) 
		    	  for(int j=0;j<Y[i].length;j++)
		    		  s3+=Y[i][j]*Read_file.getfph(i, j)*Read_file.getTpm();
		    for (int i = 0; i < D ; i++) 
	    	  for(int j=0;j<X[i].length;j++)
	    		  s2+=X[i][j]*(Read_file.getCdj(i, j)-Read_file.getOdj(i, j));
	    for (int i = 0; i < D ; i++) 
	    	  for(int j=0;j<X[i].length;j++)
	    		  s4+=X[i][j]*(Read_file.getCdj(i, j)-Read_file.getOdj(i, j))*Read_file.getTdm();
    	fitness=s1-s2+s3+s4;
    	SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=PSO3.Sfmin;
		  
		    for(int k=0;k<K;k++){
		    double s1=0,s2=0;
		    	for(int d=0;d<D;d++){
		    		for(int j=0;j<X[d].length;j++)
		    			s1+=X[d][j]*Read_file.getqdjk(d, j, k);
		    	}
		    	for(int p=0;p<P;p++){
		    		for(int h=0;h<Y[p].length;h++)
		    			s2+=Y[p][h]*Read_file.getSphk(p, h, k);
		    	}
		    	fitness+=Math.min(s1-s2, 0.0);
		    	
		    }
		    double s3=0,s4=0;
		    for(int p=0;p<P;p++){
		    	for(int h=0;h<Y[p].length;h++)
		    		s3+=Y[p][h]*Read_file.getfph(p,h);
		    }
		    for(int d=0;d<D;d++){
		    	for(int j=0;j<X[d].length;j++)
		    		s4+=X[d][j]*(Read_file.getCdj(d, j)-Read_file.getOdj(d, j));
		    }
		    fitness+=Math.min(s3-s4, 0.0);
		
		    for(int d=0;d<D;d++){
		    	for(int j=0;j<X[d].length;j++){
		    		double s5=0;
		    		for(int k=0;k<K;k++)
		    			s5+=X[d][j]*Read_file.getqdjk(d, j, k);
		    		fitness+=Math.min(Read_file.getadj(d, j)-s5, 0.0);
		    
		    	}
		    }
		    for(int d=0;d<D;d++){
		    	for(int j=0;j<X[d].length;j++){
		    		double s6=0;
		    		for(int k=0;k<K;k++)
		    			s6+=X[d][j]*Read_file.getWqdjk(d, j, k);
		    		fitness+=Math.min(Read_file.getldj(d, j)-s6, 0.0);
		    
		    	}
		    }
		    for(int d=0;d<D;d++){
		    	double s7=0;
		    	for(int j=0;j<X[d].length;j++)
		    	s7+=X[d][j];
		    fitness+=Math.min(1-s7, 0.0);
		    }
		    for(int d=0;d<D;d++)
				  for(int j=0;j<X[d].length;j++){
					  fitness+=Math.min(1-X[d][j], 0.0);
					  fitness+=Math.min(X[d][j], 0.0);
				  }
			  for(int p=0;p<P;p++)
				  for(int h=0;h<Y[p].length;h++){
					  fitness+=Math.min(1-Y[p][h], 0.0);
					  fitness+=Math.min(Y[p][h], 0.0);
				  }
		    fitness+=Sfmin;
	}
    	return fitness;
    }
    static double getPFitness (P_Individual individual) {
    	boolean right=true;
    	int c=0;
	    double fitness = 0;
	    double[][] Y=new double[P][];
	    for(int i=0;i<P;i++)
	    	Y[i]=new double[Read_file.getHp(i)];
	    double[][] X =new double[D][];
	    for(int i=0;i<D;i++)
	    	X[i]=new double[Read_file.getJd(i)];
	    for (int i = 0; i < P ; i++) 
	    	  for(int j=0;j<Y[i].length;j++)
	    	Y[i][j]=individual.getPy(c++);	  
	
	       int b=0;
		    for (int i = 0; i < D ; i++) 
		    	  for(int j=0;j<X[i].length;j++)
		    		  X[i][j]=individual.getPx(b++);
	
		double st221=0,st222=0;
		 for(int k=0;k<K;k++){
		 	for(int d=0;d<D;d++)
		 		for(int j=0;j<X[d].length;j++)
				st221+=X[d][j]*Read_file.getqdjk(d, j, k);
		
			 for(int p=0;p<P;p++)
			 	for(int h=0;h<Y[p].length;h++)
			 		st222+=Y[p][h]*Read_file.getSphk(p, h, k);
			
			 if(st221<st222)
				right=false;
			 
			 st221=0;
			 st222=0;
		 }
		 double st231=0,st232=0;
		 
		 for(int p=0;p<P;p++)
			 for(int h=0;h<Y[p].length;h++)
				 st231+=Y[p][h]*Read_file.getfph(p, h);
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++)
				 st232+=X[d][j]*(Read_file.getCdj(d, j)-Read_file.getOdj(d, j));
		 if(st231<st232)
			 right=false;
		 
		 double st241=0;
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++){
				 for(int k=0;k<K;k++)
					 st241+=X[d][j]*Read_file.getqdjk(d, j, k);
				 if(st241>Read_file.getadj(d, j))
					 right=false;
				 st241=0;
				}
	
		 double st251=0 ;
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++){
				 for(int k=0;k<K;k++)
					 st251+=X[d][j]*Read_file.getWqdjk(d, j, k);
				 if(st251>Read_file.getldj(d, j))
					right=false;
				 st251=0;
				}
		 int st261=0;
		 for(int d=0;d<D;d++){
			 st261=0;
			 for(int j=0;j<X[d].length;j++){
				 st261+=X[d][j];
			 }
			 if(st261>1)
				 right=false;	 
		 }
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++)
				 if(X[d][j]>1 && X[d][j]<0)
					 right=false;
			
		 for(int p=0;p<P;p++)
			 for(int h=0;h<Y[p].length;h++)
				 if(Y[p][h]>1 && Y[p][h]<0)
					 right=false;
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(right==true){
		 double s1=0,s2=0,s3=0,s4=0;
	   	for (int i = 0; i < P ; i++) 
	    	  for(int j=0;j<Y[i].length;j++)
	    		  s1+=Y[i][j]*Read_file.getfph(i, j);
	       for (int i = 0; i < P ; i++) 
		    	  for(int j=0;j<Y[i].length;j++)
		    		  s3+=Y[i][j]*Read_file.getfph(i, j)*Read_file.getTpm();
		    for (int i = 0; i < D ; i++) 
	    	  for(int j=0;j<X[i].length;j++)
	    		  s2+=X[i][j]*(Read_file.getCdj(i, j)-Read_file.getOdj(i, j));
	    for (int i = 0; i < D ; i++) 
	    	  for(int j=0;j<X[i].length;j++)
	    		  s4+=X[i][j]*(Read_file.getCdj(i, j)-Read_file.getOdj(i, j))*Read_file.getTdm();
    	fitness=s1-s2+s3+s4;
    	SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=PSO3.Sfmin;
		  
		    for(int k=0;k<K;k++){
		    double s1=0,s2=0;
		    	for(int d=0;d<D;d++){
		    		for(int j=0;j<X[d].length;j++)
		    			s1+=X[d][j]*Read_file.getqdjk(d, j, k);
		    	}
		    	for(int p=0;p<P;p++){
		    		for(int h=0;h<Y[p].length;h++)
		    			s2+=Y[p][h]*Read_file.getSphk(p, h, k);
		    	}
		    	fitness+=Math.min(s1-s2, 0.0);
		    	
		    }
		    double s3=0,s4=0;
		    for(int p=0;p<P;p++){
		    	for(int h=0;h<Y[p].length;h++)
		    		s3+=Y[p][h]*Read_file.getfph(p,h);
		    }
		    for(int d=0;d<D;d++){
		    	for(int j=0;j<X[d].length;j++)
		    		s4+=X[d][j]*(Read_file.getCdj(d, j)-Read_file.getOdj(d, j));
		    }
		    fitness+=Math.min(s3-s4, 0.0);
		
		    for(int d=0;d<D;d++){
		    	for(int j=0;j<X[d].length;j++){
		    		double s5=0;
		    		for(int k=0;k<K;k++)
		    			s5+=X[d][j]*Read_file.getqdjk(d, j, k);
		    		fitness+=Math.min(Read_file.getadj(d, j)-s5, 0.0);
		    
		    	}
		    }
		    for(int d=0;d<D;d++){
		    	for(int j=0;j<X[d].length;j++){
		    		double s6=0;
		    		for(int k=0;k<K;k++)
		    			s6+=X[d][j]*Read_file.getWqdjk(d, j, k);
		    		fitness+=Math.min(Read_file.getldj(d, j)-s6, 0.0);
		    
		    	}
		    }
		    for(int d=0;d<D;d++){
		    	double s7=0;
		    	for(int j=0;j<X[d].length;j++)
		    	s7+=X[d][j];
		    fitness+=Math.min(1-s7, 0.0);
		    }
		    for(int d=0;d<D;d++)
				  for(int j=0;j<X[d].length;j++){
					  fitness+=Math.min(1-X[d][j], 0.0);
					  fitness+=Math.min(X[d][j], 0.0);
				  }
			  for(int p=0;p<P;p++)
				  for(int h=0;h<Y[p].length;h++){
					  fitness+=Math.min(1-Y[p][h], 0.0);
					  fitness+=Math.min(Y[p][h], 0.0);
				  }
		    fitness+=Sfmin;
	}
    	return fitness;
    }
    static double getGFitness(G_Individual individual) {
    	boolean right=true;
    	int c=0;
	    double fitness = 0;
	    double[][] Y=new double[P][];
	    for(int i=0;i<P;i++)
	    	Y[i]=new double[Read_file.getHp(i)];
	    double[][] X =new double[D][];
	    for(int i=0;i<D;i++)
	    	X[i]=new double[Read_file.getJd(i)];
	    for (int i = 0; i < P ; i++) 
	    	  for(int j=0;j<Y[i].length;j++)
	    	Y[i][j]=individual.getGy(c++);	  
	
	       int b=0;
		    for (int i = 0; i < D ; i++) 
		    	  for(int j=0;j<X[i].length;j++)
		    		  X[i][j]=individual.getGx(b++);
	
		double st221=0,st222=0;
		 for(int k=0;k<K;k++){
		 	for(int d=0;d<D;d++)
		 		for(int j=0;j<X[d].length;j++)
				st221+=X[d][j]*Read_file.getqdjk(d, j, k);
		
			 for(int p=0;p<P;p++)
			 	for(int h=0;h<Y[p].length;h++)
			 		st222+=Y[p][h]*Read_file.getSphk(p, h, k);
			
			 if(st221<st222)
				right=false;
			 
			 st221=0;
			 st222=0;
		 }
		 double st231=0,st232=0;
		 
		 for(int p=0;p<P;p++)
			 for(int h=0;h<Y[p].length;h++)
				 st231+=Y[p][h]*Read_file.getfph(p, h);
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++)
				 st232+=X[d][j]*(Read_file.getCdj(d, j)-Read_file.getOdj(d, j));
		 if(st231<st232)
			 right=false;
		 
		 double st241=0;
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++){
				 for(int k=0;k<K;k++)
					 st241+=X[d][j]*Read_file.getqdjk(d, j, k);
				 if(st241>Read_file.getadj(d, j))
					 right=false;
				 st241=0;
				}
	
		 double st251=0 ;
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++){
				 for(int k=0;k<K;k++)
					 st251+=X[d][j]*Read_file.getWqdjk(d, j, k);
				 if(st251>Read_file.getldj(d, j))
					right=false;
				 st251=0;
				}
		 int st261=0;
		 for(int d=0;d<D;d++){
			 st261=0;
			 for(int j=0;j<X[d].length;j++){
				 st261+=X[d][j];
			 }
			 if(st261>1)
				 right=false;	 
		 }
		 for(int d=0;d<D;d++)
			 for(int j=0;j<X[d].length;j++)
				 if(X[d][j]>1 && X[d][j]<0)
					 right=false;
			
		 for(int p=0;p<P;p++)
			 for(int h=0;h<Y[p].length;h++)
				 if(Y[p][h]>1 && Y[p][h]<0)
					 right=false;
	//F(X,Y)
	//if((st22==K)&&(st23>=0)&&(st24==Xsize)&&(st25==Xsize)&&(st26<=D)	){						
	if(right==true){
		 double s1=0,s2=0,s3=0,s4=0;
	   	for (int i = 0; i < P ; i++) 
	    	  for(int j=0;j<Y[i].length;j++)
	    		  s1+=Y[i][j]*Read_file.getfph(i, j);
	       for (int i = 0; i < P ; i++) 
		    	  for(int j=0;j<Y[i].length;j++)
		    		  s3+=Y[i][j]*Read_file.getfph(i, j)*Read_file.getTpm();
		    for (int i = 0; i < D ; i++) 
	    	  for(int j=0;j<X[i].length;j++)
	    		  s2+=X[i][j]*(Read_file.getCdj(i, j)-Read_file.getOdj(i, j));
	    for (int i = 0; i < D ; i++) 
	    	  for(int j=0;j<X[i].length;j++)
	    		  s4+=X[i][j]*(Read_file.getCdj(i, j)-Read_file.getOdj(i, j))*Read_file.getTdm();
    	fitness=s1-s2+s3+s4;
    	SFminsb.append(fitness+" ");
	}
	//U1(X,Y)
	else{
		double Sfmin;
		Sfmin=PSO3.Sfmin;
		  
		    for(int k=0;k<K;k++){
		    double s1=0,s2=0;
		    	for(int d=0;d<D;d++){
		    		for(int j=0;j<X[d].length;j++)
		    			s1+=X[d][j]*Read_file.getqdjk(d, j, k);
		    	}
		    	for(int p=0;p<P;p++){
		    		for(int h=0;h<Y[p].length;h++)
		    			s2+=Y[p][h]*Read_file.getSphk(p, h, k);
		    	}
		    	fitness+=Math.min(s1-s2, 0.0);
		    	
		    }
		    double s3=0,s4=0;
		    for(int p=0;p<P;p++){
		    	for(int h=0;h<Y[p].length;h++)
		    		s3+=Y[p][h]*Read_file.getfph(p,h);
		    }
		    for(int d=0;d<D;d++){
		    	for(int j=0;j<X[d].length;j++)
		    		s4+=X[d][j]*(Read_file.getCdj(d, j)-Read_file.getOdj(d, j));
		    }
		    fitness+=Math.min(s3-s4, 0.0);
		
		    for(int d=0;d<D;d++){
		    	for(int j=0;j<X[d].length;j++){
		    		double s5=0;
		    		for(int k=0;k<K;k++)
		    			s5+=X[d][j]*Read_file.getqdjk(d, j, k);
		    		fitness+=Math.min(Read_file.getadj(d, j)-s5, 0.0);
		    
		    	}
		    }
		    for(int d=0;d<D;d++){
		    	for(int j=0;j<X[d].length;j++){
		    		double s6=0;
		    		for(int k=0;k<K;k++)
		    			s6+=X[d][j]*Read_file.getWqdjk(d, j, k);
		    		fitness+=Math.min(Read_file.getldj(d, j)-s6, 0.0);
		    
		    	}
		    }
		    for(int d=0;d<D;d++){
		    	double s7=0;
		    	for(int j=0;j<X[d].length;j++)
		    	s7+=X[d][j];
		    fitness+=Math.min(1-s7, 0.0);
		    }
		    for(int d=0;d<D;d++)
				  for(int j=0;j<X[d].length;j++){
					  fitness+=Math.min(1-X[d][j], 0.0);
					  fitness+=Math.min(X[d][j], 0.0);
				  }
			  for(int p=0;p<P;p++)
				  for(int h=0;h<Y[p].length;h++){
					  fitness+=Math.min(1-Y[p][h], 0.0);
					  fitness+=Math.min(Y[p][h], 0.0);
				  }
		    fitness+=Sfmin;
	}
    	return fitness;
    }
    static double getSFmin(StringBuilder sb) {
    	double SFmin;
    	String[] a = sb.toString().split(" ");
    	if (a.length == 1){
    		SFmin = 0;}
    	else {
    		SFmin = Double.parseDouble(a[0]);
    		for (int i = 0; i < a.length; i++) {
    			if (SFmin >= Double.parseDouble(a[i]))
    				SFmin = Double.parseDouble(a[i]);
    		}
    	}
    	//System.err.println(sb);

    	SFminsb = new StringBuilder();
    	return SFmin;
    }
}
