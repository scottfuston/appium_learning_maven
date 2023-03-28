package com.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static Properties props = new Properties();
    TestUtils utils = new TestUtils();

    public Properties getProps() throws IOException {

        InputStream is = null;

        if(props.isEmpty()){
            String propsFileName= "configLocal.properties";

            if(!System.getenv().containsKey("DEV") ){
                utils.log().info("fetching config.properties");
                propsFileName = "config.properties";
            }else{
                utils.log().info("fetching configLocal.properties");
            }

            try{
                utils.log().info("loading config properties");
                is = getClass().getClassLoader().getResourceAsStream(propsFileName);
                props.load(is);
            } catch (IOException e) {
                e.printStackTrace();
                utils.log().fatal("Failed to load config properties. ABORT!!" + e.toString());
                throw e;
            } finally {
                if(is != null){
                    is.close();
                }
            }
        }

        return props;
    }
}
