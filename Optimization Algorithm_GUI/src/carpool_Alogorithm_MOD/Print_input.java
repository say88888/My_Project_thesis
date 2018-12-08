package carpool_Alogorithm_MOD;

import java.io.IOException;

import Input_Output_txt.Carpool.Read_file;


public class Print_input {

	public static void main(int Print_Mode) throws IOException {
		// TODO Auto-generated method stub
		if (Print_Mode == 1) {
			Read_file.loadData();
			System.out.println("DriverBids");
			for (int i = 0; i < Read_file.getD(); i++) 
				for (int j = 0; j < Read_file.getJd(i); j++) 
					for (int k = 0; k < Read_file.getK(); k++) 
						System.out.println("d=" +  (i+1)  + " " + "j=" +  (j+1)  + " " + "k=" + (k+1) + " " + "Qdjk=" + Read_file.getqdjk(i, j, k));
			System.out.println();
			for (int i = 0; i < Read_file.getD(); i++) 
				for (int j = 0; j < Read_file.getJd(i); j++) 
					System.out.println("d=" +  (i+1)  + " " + "j=" + (j+1)  +  " " + "Cdj=" + Read_file.getCdj(i, j));
			System.out.println();
			for (int i = 0; i < Read_file.getD(); i++) 
				for (int j = 0; j < Read_file.getJd(i); j++) 
					System.out.println("d=" + (i+1) + " " + "j=" + (j+1)  +  " " + "Odj=" + Read_file.getOdj(i, j));
			System.out.println();
			for (int i = 0; i < Read_file.getD(); i++) 
				for (int j = 0; j < Read_file.getJd(i); j++) 
					System.out.println("d=" +  (i+1)  + " " + "j=" + (j+1)  +  " " + "adj=" + Read_file.getadj(i, j));
			System.out.println();
			for (int i = 0; i < Read_file.getD(); i++) 
				for (int j = 0; j < Read_file.getJd(i); j++) 
					for (int k = 0; k < Read_file.getK(); k++) 
						System.out.println("d=" + (i+1)  + " " + "j=" + (j+1) + " " + "k=" + (k+1) + " " + "WQdjk=" + Read_file.getWqdjk(i, j, k));
			System.out.println();
			for (int i = 0; i < Read_file.getD(); i++) 
				for (int j = 0; j < Read_file.getJd(i); j++) 
					System.out.println("d=" + (i+1)  + " " + "j=" + (j+1)  +  " " + "ldj=" + Read_file.getldj(i, j));
			System.out.println("PassengerBids");
			for (int i = 0; i < Read_file.getP(); i++) 
				for (int j = 0; j < Read_file.getHp(i); j++) 
					for (int k = 0; k < Read_file.getK(); k++) 
						System.out.println("p=" +  (i+1)  + " " + "h=" + (j+1) + " " + "k=" +  (k+1) + " " + "Sphk=" + Read_file.getSphk(i, j, k));
			System.out.println();	
			for (int i = 0; i < Read_file.getP(); i++) 
				for (int j = 0; j < Read_file.getHp(i); j++) 
					System.out.println("p=" + (i+1) + " " + "h=" + (j+1) + " " + "fph=" + Read_file.getfph(i, j));
		}
	}
}
