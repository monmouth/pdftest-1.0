/**
 * 
 */
package kenhu1970.pdfbox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 * 在載入PDF檔案處，使用Interface org.apache.pdfbox.io.RandomAccess來試試對記憶體使用
 * 的影響.
 * @author ken
 *
 */
public class LoadByScratchFile {
private File pdf;	
private File scratchFile;
private String scratchFileAccessMode = "rw";

private PrintWriter out;
private PDDocument doc ;

	private void printoutText(String filename) throws Exception {
		try {
			pdf = new File(filename);
			scratchFile = new File("/tmp/scratchfile");
			RandomAccessFile temp = new RandomAccessFile(scratchFile,
					scratchFileAccessMode);
			doc = PDDocument.load(pdf, temp);
			PDFTextStripper extractor = new PDFTextStripper();
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					"/tmp/output", true)));
			extractor.writeText(doc, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				doc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		int i=0;
		String filename=  args[0];
		LoadByScratchFile reader = new LoadByScratchFile();
		while(i<100) {
		reader.printoutText(filename);
		i++;
		}
	}
}
