package com.dockerforjavadevelopers.hello;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Test;

public class DummyTest {

  @Test
  public void aTest() {
    assertEquals(true, true);
  }

@Test
public void bTest(){
String url="http://localhost:8082/";
		String[] status={"curl", "-s"," -o", "/dev/null", "-w", "%{http_code}",url};
		ProcessBuilder process = new ProcessBuilder(status); 
        Process p;	
        try
        {
            p = process.start();
             BufferedReader reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ( (line = reader.readLine()) != null) {
                        builder.append(line);
                        builder.append(System.getProperty("line.separator"));
                }
                String result = builder.toString();
                System.out.print(result);
                

                if(result=="200"){
                	System.out.println("deployment is succesfull");
                }else{
                	System.out.println("deployment not successfull");
                }
        }
        catch (IOException e)
        {   System.out.print("error");
            e.printStackTrace();
        }
}
}
