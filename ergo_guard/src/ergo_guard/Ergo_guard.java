package ergo_guard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;

public class Ergo_guard {
    
  private Ergo_guard() {;}

  public static void main(String[] args) throws InterruptedException {
    //Process_detector.processActivation();
    
    for(int x = 0; x < 10; x++){
      Notifications.printAlert();
    }
  }
}
