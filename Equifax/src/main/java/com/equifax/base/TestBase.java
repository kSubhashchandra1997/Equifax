package com.equifax.base;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

    public Properties property;
    public TestBase(){

        try{
            property = new Properties();
            property.load(new FileInputStream("./src/main/java/com/equifax/configure/config.properties"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
