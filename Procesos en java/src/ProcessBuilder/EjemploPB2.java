package ProcessBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Map;
 
public class EjemploPB2 { 
  public static void main(String args[]) throws IOException {
    
	  ProcessBuilder pb = new ProcessBuilder("CMD","/c", "ipconfig");
    
	Map variablesPRoceso =  pb.environment();
	System.out.println(variablesPRoceso);
	
    File fOut = new File("C:\\Users\\Eva Royo\\temporal\\salida.txt");
    File fErr = new File("C:\\Users\\Eva Royo\\temporal\\error.txt");
 
    pb.redirectOutput(fOut);
    pb.redirectError(fErr); 
    
    pb.start(); 
  }
}// EjemploPB2
