/**
 * 
 */
package kenhu1970.itext;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

/**
 * @author ken
 *
 */
public class LoadByFileExtractByPage {
private PrintWriter out;

	private void printoutText(String filename) throws Exception {
		try {
			PdfReader reader = new PdfReader(filename);
			PdfReaderContentParser parser = new PdfReaderContentParser(reader);
			out = new PrintWriter(new BufferedWriter(new FileWriter("/tmp/output", true)));
			TextExtractionStrategy strategy;

			for (int i = 1; i <= reader.getNumberOfPages(); i++) {
				strategy = parser.processContent(i,
						new SimpleTextExtractionStrategy());
				out.println(strategy.getResultantText());
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
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
