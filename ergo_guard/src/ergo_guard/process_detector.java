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
public class process_detector {
    
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
            BufferedReader input =
                    new BufferedReader
                    (new InputStreamReader(p.getInputStream()));
            
            //Java captura las lineas de informacion que proporciona el script
            String line;
            while ((line = input.readLine()) != null) {
                processList.add(line);
            }
            input.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return processList;
    }
}
