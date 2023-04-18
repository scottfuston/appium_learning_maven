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
            //SAUCE CONFIGS
            //String propsFileName= "configs/androidReal_sauce.properties";
            //String propsFileName= "configs/androidSim_sauce.properties";
            //String propsFileName= "configs/iosReal_sauce.properties";
            //String propsFileName= "configs/iosSim_sauce.properties";

            //LOCAL CONFIGS
            String propsFileName= "configs/androidReal_local.properties";
            //String propsFileName= "configs/androidVirtual_local.properties";
            //String propsFileName= "configs/iosReal_local.properties";
            //String propsFileName= "configs/iosSim_local.properties";


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
