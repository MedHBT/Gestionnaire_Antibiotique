import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTable;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class GenererPDF {
	
	
	public GenererPDF(JTable table,String targetDir){
		int count=table.getRowCount();
		Document document=new Document(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document,new FileOutputStream(targetDir));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.open();
		BaseFont bf = null;
		Font myfont = null;
		try {
			bf = BaseFont.createFont("c://windows/fonts/arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			myfont = new Font(bf, 10, 0);
		} catch (DocumentException | IOException e1) {
			e1.printStackTrace();
		}
		PdfPTable tab=new PdfPTable(11);
		tab.setWidthPercentage(100);
		tab.addCell("ID");
		tab.addCell("Nom");
		tab.addCell("Prenom");
		tab.addCell("Numero");
		tab.addCell("Region");
		tab.addCell("Date de declaration");
		tab.addCell("Durée");
		tab.addCell("Date d'entrée");
		tab.addCell("Date de Sortie");
		tab.addCell("Veterinaire");
		tab.addCell("Remarque");
		for(int i=0;i<count;i++){
			Object obj1 = GetData(table, i, 0);
			Object obj2 = GetData(table, i, 1);
			Object obj3 = GetData(table, i, 2);
			Object obj4 = GetData(table, i, 3);
			Object obj5 = GetData(table, i, 4);
			Object obj6 = GetData(table, i, 5);
			Object obj7 = GetData(table, i, 6);
			Object obj8 = GetData(table, i, 7);
			Object obj9 = GetData(table, i, 8);
			Object obj10 = GetData(table, i, 9);
			Object obj11 = GetData(table, i, 10);
			String value1=obj1.toString();
			String value2=obj2.toString();
			String value3=obj3.toString();
			String value4=obj4.toString();
			String value5=obj5.toString();
			String value6=obj6.toString();
			String value7=obj7.toString();
			String value8=obj8.toString();
			String value9=obj9.toString();
			String value10=obj10.toString();
			String value11=obj11.toString();
			
			PdfPCell cell1 = new PdfPCell(new Phrase(value1, myfont));
			PdfPCell cell2 = new PdfPCell(new Phrase(value2, myfont));
			PdfPCell cell3 = new PdfPCell(new Phrase(value3, myfont));
			PdfPCell cell4 = new PdfPCell(new Phrase(value4, myfont));
			PdfPCell cell5 = new PdfPCell(new Phrase(value5, myfont));
			PdfPCell cell6 = new PdfPCell(new Phrase(value6, myfont));
			PdfPCell cell7 = new PdfPCell(new Phrase(value7, myfont));
			PdfPCell cell8 = new PdfPCell(new Phrase(value8, myfont));
			PdfPCell cell9 = new PdfPCell(new Phrase(value9, myfont));
			PdfPCell cell10 = new PdfPCell(new Phrase(value10, myfont));
			PdfPCell cell11 = new PdfPCell(new Phrase(value11, myfont));
			
			cell2.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
			cell3.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
			cell4.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
			cell5.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
			cell10.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
			cell11.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

			tab.addCell(cell1);
			tab.addCell(cell2);
			tab.addCell(cell3);
			tab.addCell(cell4);
			tab.addCell(cell5);
			tab.addCell(cell6);
			tab.addCell(cell7);
			tab.addCell(cell8);
			tab.addCell(cell9);
			tab.addCell(cell10);
			tab.addCell(cell11);
		}
		try {
			document.add(tab);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
	}
	
	public Object GetData(JTable table,int row_index, int col_index){
		return table.getModel().getValueAt(row_index, col_index);
	}
}
