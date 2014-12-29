/**
 * 
 */
package kenhu1970.pdfbox;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 * @author ken
 *
 */
public class LoadByStream {
private File pdf;	
private FileInputStream fis;
private BufferedInputStream bis;
private PrintWriter out;
private PDDocument doc ;

	private void printoutText(String filename) throws Exception{
		try {
		pdf = new File(filename);
		fis = new FileInputStream(pdf);
		bis = new BufferedInputStream(fis);
		doc = PDDocument.load(bis);
		PDFTextStripper extractor = new PDFTextStripper();
		out = new PrintWriter(new BufferedWriter(new FileWriter("/tmp/output", true)));
		extractor.writeText(doc, out);
		} catch (Exception e) {
			System.out.println("print out pdf text fails ! " +  e);
		} finally {
			out.close();doc.close();bis.close();fis.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		int i=0;
		String filename=  args[0];
		LoadByStream reader = new LoadByStream();
		while(i<100) {
		reader.printoutText(filename);
		i++;
		}
	}
}
