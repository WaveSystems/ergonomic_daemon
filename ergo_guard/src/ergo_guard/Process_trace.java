/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo_guard;

import java.util.*;

/**
 *
 * @author Alberto
 */
public class Process_trace {
    
    public String leisure[]={"chrome.exe","Safari.exe","iexplorer.exe","firefox.exe","Skype.exe","msnmsgr.exe"};
    public String entertainment[]={"wmplayer.exe","iTunes.exe","vlc.exe"};
    public String work[]={"WINWORD.EXE","EXCEL.EXE","MSACCESS.EXE","MSPUB.EXE","POWERPNT.EXE"};
    public List<process> processes = new ArrayList<process>();
    
    class process {
        String name;
        String type;
        long timeElapsed;
        long actualTime;
        
        process (String nam){
            Calendar cal = Calendar.getInstance();
            name = nam;
            type = "";
            timeElapsed = 0;
            actualTime = cal.getTimeInMillis()/1000;
        }
        
        void setTime(long ms){
            actualTime = ms;
        }
        
        void setElapsed (long nms) {
            long t = nms - actualTime;
            timeElapsed =+ t;
        }
        
        void setType(String t) {
            type = t;
        }
        
        String getName (){
            return name;
        }
        
        String getType (){
            return type;
        }
        
        long getElapsed (){
            return timeElapsed;
        }
    
    }
    
    public void processClassify (String proc){
        
        int size, cont, listC;
        boolean exist = false;
        process procTracing = new process(proc);
        process procc = new process(proc);
        
        for(listC = 0; listC < processes.size(); listC ++){
            procc = (process) processes.get(listC);
            
            if(proc.equals(procc.getName())){
                exist = true;
            } 
        }
        
        if(exist == false){
            System.out.println("Added");
            size = leisure.length;

            for(cont = 0; cont < size; cont ++){
                if(proc.equals(leisure[cont]))
                    procTracing.setType("leisure");
            }
            
            size = entertainment.length;
            
            for(cont = 0; cont < size; cont ++){
                if(proc.equals(entertainment[cont]))
                    procTracing.setType("entertainment");
            }
            
            size = work.length;
            
            for(cont = 0; cont < size; cont ++){
                if(proc.equals(work[cont]))
                    procTracing.setType("work");
            }
            
            processes.add(procTracing);
        }
    }
}
