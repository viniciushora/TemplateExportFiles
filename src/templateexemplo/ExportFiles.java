
package templateexemplo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


/*Esse codigo esta uma bangunca..*/

public class ExportFiles extends AbstractExportFiles{

    public ExportFiles() {
        super();
    }
    
    @Override
    protected void loadHTML(){
        try {
            current = new java.io.File(".").getCanonicalPath();
            File file = new File(current + "\\src\\" + "index.html");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            this.out = new BufferedWriter(fw);
            this.out.write("<HTML><BODY>");
        } catch (IOException ex) {
            Logger.getLogger(ExportFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    protected void loadWord(){
        try {
                current = new java.io.File(".").getCanonicalPath();
                this.out1 = new FileOutputStream(new File(current + "\\src\\" + "word.docx"));
                this.document = new XWPFDocument();
                //Blank Document
            } catch (IOException ex) {
                Logger.getLogger(ExportFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Override
    public void exportHTML(String txt){
        String[] txtLinhas = txt.split("\n");
        for(Object linhas : txtLinhas )
        {
            printLineHTML((String)linhas);
        }   
        saveHTML();
        
    }
    
    @Override
    public void exportWord(String txt){
             String[] txtLinhas = txt.split("\n");
        for(Object linhas : txtLinhas )
        {
            printLineWord((String)linhas);
        }   
        saveWord();   
    }

    @Override
    protected void printLineHTML(String linha) {
        try {
            this.out.write("<BR>" + linha);
        } catch (IOException ex) {
            Logger.getLogger(ExportFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void printLineWord(String linha) {
        XWPFParagraph paragraph = this.document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(linha);
    }
        
    @Override
    protected void saveWord() {
        try {
            this.document.write(this.out1);
            this.out1.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void saveHTML() {
        try {
            this.out.write("</BODY>");
            this.out.write("</HTML>");
            this.out.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportFiles.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
