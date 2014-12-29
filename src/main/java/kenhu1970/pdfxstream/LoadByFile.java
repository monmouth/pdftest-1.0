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

/**
 * @author ken
 *
 */
public class LoadByFile {

	private void printoutText(String filename) throws Exception{
		Document pdf = null;
		PrintWriter out = null;
		try {
			pdf = PDF.open(filename);
			out = new PrintWriter(new BufferedWriter(new FileWriter("/tmp/output", true)));
		    pdf.pipe(new OutputTarget(out));
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			if (pdf != null ) { pdf.close();}
		}
	}
	
	public static void main(String[] args) throws Exception {
		int i = 0;
		String filename = args[0];
		LoadByFile reader = new LoadByFile();
		while (i < 100) {
			reader.printoutText(filename);
			i++;
		}
	}
}
