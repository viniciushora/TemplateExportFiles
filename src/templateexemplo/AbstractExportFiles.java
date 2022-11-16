/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templateexemplo;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author Vinicius Corte
 */
public abstract class AbstractExportFiles {
    
    protected BufferedWriter out = null;
    protected XWPFDocument document;
    protected FileOutputStream out1 = null;
    protected String current = null;
    
    public AbstractExportFiles(){
        this.loadHTML();
        this.loadWord();
    }
    
    protected abstract void loadHTML();
    protected abstract void loadWord();
    public abstract void exportHTML(String txt);
    public abstract void exportWord(String txt);
    protected abstract void printLineHTML(String linha);
    protected abstract void printLineWord(String linha);
    protected abstract void saveWord();
    protected abstract void saveHTML();
}
