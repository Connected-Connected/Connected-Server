package framework.properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropManager {
	
 private Properties properties;
 public PropManager(){
	 
	 //properties 객체 생성
	 properties = new Properties();
	 try {
         
		 String path = PropManager.class.getResource("").getPath();
		 
		 
		//properties가 있는 경로로 초기화
         properties.load(new FileInputStream(path + "\\connected.properties"));       
         
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
 
 /*
  * 2017-02-15
  * 김지광
  * 키값에 맞는 프로퍼티를 가져옴
  */
 public String getProperties(String key) 
 {
	    return properties.getProperty(key);
 }
}