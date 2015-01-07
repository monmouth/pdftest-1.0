/**
 * 
 */
package kenhu1970.pdfxstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import com.snowtide.pdf.Page;

/**
 * 以pdfxstream做為讀取資料用的Library並 逐頁讀取PDF內容.
 * @author ken
 *
 */
public class LoadByFileExtractByPage {

	private void printoutText(String filename) throws Exception{
		Document pdf = null;
		PrintWriter out = null;
		Page page = null;
		try {
			pdf = PDF.open(filename);
			out = new PrintWriter(new BufferedWriter(new FileWriter("/tmp/output", true)));
			for (int i=0; i< pdf.getPageCnt(); i++) {
				page = pdf.getPage(i);
		        page.pipe(new OutputTarget(out));
			}
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			if (pdf != null ) { pdf.close();}
		}
	}
	
	public static void main(String[] args) throws Exception {
		int i = 0;
		String filename = args[0];
		LoadByFileExtractByPage reader = new LoadByFileExtractByPage();
		while (i < 100) {
			reader.printoutText(filename);
			i++;
		}
	}
}
