/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo_guard;

import java.util.Calendar;
import java.util.Stack;

/**
 *
 * @author Alberto
 */
public class Process_trace {
    
    public String leisure[]={"chrome.exe","Safari.exe","iexplorer.exe","firefox.exe","Skype.exe","msnmsgr.exe"};
    public String entertainment[]={"wmplayer.exe","iTunes.exe","vlc.exe"};
    public String work[]={"WINWORD.EXE","EXCEL.EXE","MSACCESS.EXE","MSPUB.EXE","POWERPNT.EXE"};
    public Stack processes = new Stack ();
    
    class process {
        String name;
        String type;
        float timeElapsed;
        long actualTime;
        
        process (String nam){
            Calendar cal = Calendar.getInstance();
            name = nam;
            type = "";
            timeElapsed = 0;
            actualTime = cal.getTimeInMillis()/1000;
        }
        
        void setType(String t) {
            System.out.println("Enter 2");
            type = t;
        }
    
    }
    
    public void processClassify (String proc){
        
        System.out.println("Enter");
        
        int size, cont;
        process procTracing = new process(proc);
        
        size = leisure.length;
        
        for(cont = 0; cont <= size; cont ++){
            if(proc.equals(leisure[cont])){
                procTracing.setType("leisure");
            }
        }
        
        size = entertainment.length;
        
        for(cont = 0; cont <= size; cont ++){
            if(proc.equals(leisure[cont])){
                procTracing.setType("entertainment");
            }
        }
        
        size = work.length;
        
        for(cont = 0; cont <= size; cont ++){
            if(proc.equals(leisure[cont])){
                procTracing.setType("work");
            }
        }
        
//        System.out.println(procTracing);
        
        processes.push(procTracing);
    }
}
