import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class compare {

  public static void main(String[] args) {

    FileReader fr1 = null;
    FileReader fr2 = null;
    String Line1 = null;
    String Line2 = null;
    int k = 0;
    int m = 0;
    Map map1 = new HashMap();
    Map map2 = new HashMap();
    
    try {
      fr1 = new FileReader("hw1-mpzhu.out");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }// 建立FileReader对象，并实例化为fr

    BufferedReader br1 = new BufferedReader(fr1);// 建立BufferedReader对象，并实例化为br
    
  try {
    while(br1.ready())
      try {
        Line1 = br1.readLine();
        map1.put(Line1, 1);
    
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
  } catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
  }// 从文件读取一行字符串

  
    try {
      fr2 = new FileReader("src/main/resources/sample.out");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }// 建立FileReader对象，并实例化为fr

    BufferedReader br2 = new BufferedReader(fr2);// 建立BufferedReader对象，并实例化为br
    try {
      while(br2.ready())
      try {
        Line2 = br2.readLine();
        map2.put(Line2, 1);
        m++;
      
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }// 从文件读取一行字符串



    Set keys = map1.keySet();
    if (keys != null) {
      Iterator iterator = keys.iterator();
      while (iterator.hasNext()) {
        String key = (String) iterator.next();
       
        if (map2.containsKey(key)) 
        {

          k++;
          System.out.println("!!!");
        }

      }
    }

   
    System.out.println("similarity=" + k * 100 / m + "%");
  }
}
