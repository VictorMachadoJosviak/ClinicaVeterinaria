package com.up.clinicaveterinaria.util;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtil {
	private static PropertiesUtil instance = null;
	
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesUtil.class);
	
	private Properties properties;
	
	private PropertiesUtil(){
		try{
			properties = new Properties();
			properties.load(getClass().getResourceAsStream("../../../../messages.properties"));
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
		}
	}

	public static PropertiesUtil getInstance() {
		if(instance == null)
			instance = new PropertiesUtil();
		return instance;
	}

	public String get(String key) {
		return (String)properties.get(key);
	}
}