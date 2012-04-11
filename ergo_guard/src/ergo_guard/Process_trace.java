/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo_guard;

import java.util.Calendar;

/**
 *
 * @author Alberto
 */
public class Process_trace {
    
    class process {
        String name;
        float timeElapsed;
        long actualTime;
        
        process (String nam){
            Calendar cal = Calendar.getInstance();
            name = nam;
            timeElapsed = 0;
            actualTime = cal.getTimeInMillis()/1000;
        }
    
    }
    
    public Process_trace () {
        String leisure[]={"chrome.exe","Safari.exe","iexplorer.exe","firefox.exe","Skype.exe","msnmsgr.exe"};
        String entertainment[]={"wmplayer.exe","iTunes.exe","vlc.exe"};
        String work[]={"WINWORD.EXE","EXCEL.EXE","MSACCESS.EXE","MSPUB.EXE","POWERPNT.EXE"};
    }

    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTimeInMillis()/1000);
    }
}
