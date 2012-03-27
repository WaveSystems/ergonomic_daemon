/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo_guard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;
/**
 *
 * @author Alberto
 */
public class Ergo_guard {
    private Ergo_guard() {  }
    /**
     * @param args the command line arguments
     */
    public static List<String> listRunningProcesses() {
        List<String> processList = new ArrayList<String>();
        try {
            //Se crea el archivo vb script en temp
            File file = File.createTempFile("realhowto",".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);
            
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
            fw.write(vbs);
            fw.close();
            
            //Java ejecuta el script
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            System.out.println("This is the path: " + file.getPath() + "\n");
            BufferedReader input =
                    new BufferedReader
                    (new InputStreamReader(p.getInputStream()));
            
            //Java captura las lineas de informacion que proporciona el script
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println("The process: " + line + "\n");
                processList.add(line);
                }
            input.close();
            }
        catch(Exception e){
            e.printStackTrace();
            }
        return processList;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
         List<String> processes = Ergo_guard.listRunningProcesses();
         String result = "";
         
         Iterator<String> it = processes.iterator();
         int i = 0;
         while (it.hasNext()) {
             result += it.next() +",";
             i++;
             if (i==10) {
                 System.out.println("The process: " + result + "\n");
                 result += "\n";
                 i = 0;
                 }
             }
         msgBox("Running processes : " + result);
         }
    
    public static void msgBox(String msg) {
        javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)
                null, msg, "VBSUtils", javax.swing.JOptionPane.DEFAULT_OPTION);
        }
}
