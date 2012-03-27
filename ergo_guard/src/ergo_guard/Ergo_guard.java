package ergo_guard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;

public class Ergo_guard {
  private Ergo_guard() {;}

  public static void main(String[] args) {
    // TODO code application logic here
    File script = Ergo_guard.writeVbScript();
    List<String> processes = Ergo_guard.excecuteScript(script);
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
