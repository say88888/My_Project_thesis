package GUI.GUI_Consolidation_word;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;


public class Create_word_table_Carpool{

	private static List<List<String>> Consolidation_Algorithm_mean_value = new ArrayList<List<String>>();
	private static List<List<String>> Consolidation_Algorithm = new ArrayList<List<String>>();

	private static ArrayList<String> Consolidation_D = new ArrayList<String>();
	private static ArrayList<String> Consolidation_P = new ArrayList<String>();
	
	private static ArrayList<String> table_title = new ArrayList<String>();
	
	private static int[] X = {4,7,7,4,4,3};
	
	private static int k=0;
	
	private static String Colum;
	private static String Particles;
	private static int fontSize;
	
	public static void main() throws IOException {
		// TODO Auto-generated method stub
		Read_Excel_Carpool.main();
		
		Consolidation_Algorithm_mean_value=Read_Excel_Carpool.Consolidation_Algorithm_mean_value();
		Consolidation_Algorithm=Read_Excel_Carpool.Consolidation_Algorithm();
		
		Consolidation_D=Read_Excel_Carpool.Consolidation_D();
		Consolidation_P=Read_Excel_Carpool.Consolidation_P();
			
		Colum=Set_Parameter.Column();
		Particles=Set_Parameter.Particles();
		fontSize=Integer.parseInt(Set_Parameter.fontSize());
		
		table_title();
		
		 //Blank Document
	      XWPFDocument document = new XWPFDocument();
	        
	      //Write the Document in file system
	      FileOutputStream out = new FileOutputStream(new File("output\\Table_Carpool.docx"));
	       
	      for(int i=0;i<X.length;i++)
	    	  document= table(document,i);

	    
	      document.write(out);
	      out.close();
	      System.out.println("create_table.docx written successully");
	}
	
	public static XWPFDocument table(XWPFDocument document,int i) throws IOException{
		
		 XWPFParagraph paragraph = document.createParagraph();
		 paragraph.setAlignment(ParagraphAlignment.CENTER);
	     XWPFRun run = paragraph.createRun();
	
	      setRun(run, "Times New Roman" , fontSize, "000000" , "  Table  "+ (i+1)+  (char)(97+i) +"  "+Colum+" for several cases with " + Particles +" particles " , false, false);
	      //create table
	      XWPFTable table = document.createTable();
			
	      ArrayList<String> title = new ArrayList<String>();
	      //create first row
	      XWPFTableRow tableRowOne = table.getRow(0);
	      tableRowOne.getCell(0).removeParagraph(0);
	      XWPFParagraph paragraph1 = tableRowOne.getCell(0).addParagraph();
	      paragraph1.setAlignment(ParagraphAlignment.CENTER);
          setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , "Case" , false, false);
          
          tableRowOne.addNewTableCell();
          tableRowOne.getCell(1).removeParagraph(0);
          paragraph1.setAlignment(ParagraphAlignment.CENTER);
	      paragraph1 = tableRowOne.getCell(1).addParagraph();
          setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , "D" , false, false);

          tableRowOne.addNewTableCell();
          tableRowOne.getCell(2).removeParagraph(0);
	      paragraph1 = tableRowOne.getCell(2).addParagraph();
          setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , "P" , false, false);

          int k2=3;
	      for(int j=0;j<X[i];j++){
	  //    tableRowOne.addNewTableCell().setText(table_title.get(k));
	    	tableRowOne.addNewTableCell();
	        tableRowOne.getCell(k2).removeParagraph(0);
	        paragraph1 = tableRowOne.getCell(k2).addParagraph();
	        paragraph1.setAlignment(ParagraphAlignment.CENTER);
	        setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , table_title.get(k) , false, false);

	      title.add(table_title.get(k));
	      k++;
	      k2++;
	      }
	      
	      for(int j=0;j<Consolidation_D.size();j++){
	    //create second row
	      XWPFTableRow tableRowTwo = table.createRow();
	      
	  //    tableRowTwo.getCell(0).setText(String.valueOf(j+1));
	      tableRowTwo.getCell(0).removeParagraph(0);
	      paragraph1 = tableRowTwo.getCell(0).addParagraph();
	      paragraph1.setAlignment(ParagraphAlignment.CENTER);
	      setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , String.valueOf(j+1) , false, false);

	      tableRowTwo.getCell(1).removeParagraph(0);
	      paragraph1 = tableRowTwo.getCell(1).addParagraph();
	      paragraph1.setAlignment(ParagraphAlignment.CENTER);
	        setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , String.valueOf(Consolidation_D.get(j)) , false, false);

	      tableRowTwo.getCell(2).removeParagraph(0);
	      paragraph1 = tableRowTwo.getCell(2).addParagraph();
	      paragraph1.setAlignment(ParagraphAlignment.CENTER);
	        setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , String.valueOf(Consolidation_P.get(j)) , false, false);

	      
	      int k1=3;
	      
	      	for(int m=0;m<title.size();m++)
	      	{
	      		System.out.println(Consolidation_Algorithm.get(j)+" ----- "+ title.get(m));
	      		if(Consolidation_Algorithm.get(j).contains(title.get(m)))
	      		{
	      			System.out.println(Consolidation_Algorithm.get(j)+" ----- "+ title.get(m));
	      			for(int l=0;l<Consolidation_Algorithm.get(j).size();l++){
	      				if(Consolidation_Algorithm.get(j).get(l).equals(title.get(m)))
	      				{
	      					if(Consolidation_Algorithm_mean_value.get(j).size()%2==0)
	      					{
	      					  String s=Consolidation_Algorithm_mean_value.get(j).get(l*2);
	      					  String s1=Consolidation_Algorithm_mean_value.get(j).get(l*2+1);
	      				//	  tableRowTwo.getCell(k1).setText(s+"/"+s1);
	      					  tableRowTwo.getCell(k1).removeParagraph(0);
  							  paragraph1 = tableRowTwo.getCell(k1).addParagraph();
  						      paragraph1.setAlignment(ParagraphAlignment.CENTER);
  						      setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , s , false, true);
						      setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , "/"+s1 , false,false);
	      					}
	      					else
	      					{
	      						if(l==0){
	      								String s=Consolidation_Algorithm_mean_value.get(j).get(0);
	      						//		tableRowTwo.getCell(k1).setText(s);
	      						      tableRowTwo.getCell(k1).removeParagraph(0);
	      							  paragraph1 = tableRowTwo.getCell(k1).addParagraph();
	      						      paragraph1.setAlignment(ParagraphAlignment.CENTER);
	      						       setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , s , false, false);

	      								}
	      						else{
	      								String s=Consolidation_Algorithm_mean_value.get(j).get(l*2-1);
	      								String s1=Consolidation_Algorithm_mean_value.get(j).get(l*2);
	      						//		tableRowTwo.getCell(k1).setText(s+"/"+s1);
	      						      tableRowTwo.getCell(k1).removeParagraph(0);
	      							  paragraph1 = tableRowTwo.getCell(k1).addParagraph();
	      						      paragraph1.setAlignment(ParagraphAlignment.CENTER);
	      						      setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , s , false, true);
	      						      setRun(paragraph1.createRun() , "Times" , fontSize, "000000" , "/"+s1 , false,false);
	      								}
	      					}
	      				}
	      			}
	      		}
	      		k1++;
	      	}
	     
	      }
	      
	      //create third row
	   /*   XWPFTableRow tableRowThree = table.createRow();
	      tableRowThree.getCell(0).setText("col one, row three");
	      tableRowThree.getCell(1).setText("col two, row three");
	      tableRowThree.getCell(2).setText("col three, row three");
	    
	      XWPFTableRow tableRowfour = table.createRow();
	      tableRowfour.getCell(0).setText("4");
	      tableRowfour.getCell(1).setText("5");
	      tableRowfour.getCell(2).setText("6");
	     */ 
	      
		return document;
	}
	

	static void table_title()
	{
		table_title.clear();
		table_title.add("CPLEX");
		table_title.add("PSO2");
		table_title.add("CCPSO2");
		table_title.add("DECC");
		
		table_title.add("DE");
		table_title.add("DE_strategy1");
		table_title.add("DE_strategy2");
		table_title.add("DE_strategy3");
		table_title.add("DE_strategy4");
		table_title.add("DE_strategy5");
		table_title.add("DE_strategy6");
	
		table_title.add("DE_Real");
		table_title.add("DE_strategy1_Real");
		table_title.add("DE_strategy2_Real");
		table_title.add("DE_strategy3_Real");
		table_title.add("DE_strategy4_Real");
		table_title.add("DE_strategy5_Real");
		table_title.add("DE_strategy6_Real");
		
		table_title.add("NSDE");
		table_title.add("SaNSDE");
		table_title.add("FA");
		table_title.add("FA_PSO");
	
		table_title.add("DMS-L-PSO");
		table_title.add("DMSDL-PSO");
		table_title.add("ALPSO2_NEW");
		table_title.add("ALPSO2_NEW_PrematureConvegence1");
		
		table_title.add("NLPSO2");
		table_title.add("DynDE");
		table_title.add("L-SHADE");
	}
	
	private static void setRun (XWPFRun run , String fontFamily , int fontSize , String colorRGB , String text , boolean bold , boolean addBreak) {
        run.setFontFamily(fontFamily);
        run.setFontSize(fontSize);
        run.setColor(colorRGB);
        run.setText(text);
        run.setBold(bold);
        if (addBreak) run.addBreak();
    }
	
}
