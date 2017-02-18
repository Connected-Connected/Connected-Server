package framework.properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropManager {
	
 private Properties properties;
 public PropManager(){
	 
	 //properties ��ü ����
	 properties = new Properties();
	 try {
         
		 String path = PropManager.class.getResource("").getPath();
		 
		 
		//properties�� �ִ� ��η� �ʱ�ȭ
         properties.load(new FileInputStream(path + "\\connected.properties"));       
         
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
 
 /*
  * 2017-02-15
  * ������
  * Ű���� �´� ������Ƽ�� ������
  */
 public String getProperties(String key) 
 {
	    return properties.getProperty(key);
 }
}