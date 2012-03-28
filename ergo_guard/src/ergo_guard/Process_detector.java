package ergo_guard;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Process_detector {
    
  private Process_detector() {;}

  public static String writeVbScript(){
      try{
      //Se crea el archivo vb script
      File script = new File("processes.vbs");
      if(!script.exists()){
          script.createNewFile();
//          script.deleteOnExit();
          FileWriter writeScript = new java.io.FileWriter(script);
          
          //Se llena el archivo vb (estas son las istricciones en en codigo basic para acceder al TASKLIST.EXE)
          String vbs = "Set WshShell = WScript.CreateObject(\"WScript.Shell\")\n"
                  + "Set locator = CreateObject(\"WbemScripting.SWbemLocator\")\n"
                  + "Set service = locator.ConnectServer()\n"
                  + "Set processes = service.ExecQuery _\n"
                  + " (\"select name from Win32_Process\")\n"
                  + "For Each process in processes\n"
                  + "wscript.echo process.Name \n"
                  + "Next\n"
                  + "Set WSHShell = Nothing\n";
          writeScript.write(vbs);
          writeScript.close();
          System.out.println("This is the path: " + script.getPath() + "\n");
      }
      return script.getPath();
      }catch(Exception e){
          e.printStackTrace();
          return e.getMessage();
      }
  }

//  public static List<String> executeScript(File script){
//      try{
//          List<String> processList = new ArrayList<String>();
//          //Java ejecuta el script
//          Process p = Runtime.getRuntime().exec("cscript //NoLogo " + script.getPath());
//          System.out.println("This is the path: " + script.getPath() + "\n");
//          BufferedReader input =
//                  new BufferedReader
//                  (new InputStreamReader(p.getInputStream()));
//          
//          //Java captura las lineas de informacion que proporciona el script
//          String line;
//          while ((line = input.readLine()) != null) {
//              System.out.println("The process: " + line + "\n");
//              processList.add(line);
//          }
//          input.close();
//          return processList;
//      }catch(Exception e){
//          e.printStackTrace();
//      }
//  }
  
  public static void processActivation(){
      // TODO code application logic here
      String script = Process_detector.writeVbScript();
//      List<String> processes = process_detector.executeScript(script);
//      String result = "";
//      
//      Iterator<String> it = processes.iterator();
//      int i = 0;
//      while (it.hasNext()) {
//          result += it.next() +",";
//          i++;
//          if (i==10) {
//              System.out.println("The process: " + result + "\n");
//              result += "\n";
//              i = 0;
//          }
//      }
  }
}