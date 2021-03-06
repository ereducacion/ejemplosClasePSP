package util;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class ProxyPrintStream extends PrintStream{    
    private PrintStream fileStream = null;
    private PrintStream originalPrintStream = null;
    public ProxyPrintStream(PrintStream out, String FilePath) {
        super(out);
        originalPrintStream = out;
         try {
             FileOutputStream fout = new FileOutputStream(FilePath,true);
             fileStream = new PrintStream(fout);
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }    
    public void print(final String str) {
        originalPrintStream.print(str);
        fileStream.print(str);
    }
    public void println(final String str) {
        originalPrintStream.println(str);
        fileStream.println(str);
    }     
}
