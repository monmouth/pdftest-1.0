/**
 * 
 */
package kenhu1970.pdfbox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 * @author ken
 *
 */
public class LoadByFile {
private File pdf;
private PrintWriter out;
private PDDocument doc ;

	private void printoutText(String filename) throws Exception{
		try {
		pdf = new File(filename);
		doc = PDDocument.load(pdf);
		PDFTextStripper extractor = new PDFTextStripper();
		out = new PrintWriter(new BufferedWriter(new FileWriter("/tmp/output", true)));
		out.println(extractor.getText(doc));
		} catch (Exception e) {
			System.out.println("print out pdf text fails ! " +  e);			
		} finally {
			if (out != null ) { out.close();}
			if (doc != null) {doc.close(); }
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
