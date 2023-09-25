package Demo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class demo2 {

	public static void main(String[] args) {
		
	     
		 Logger	logger = Logger.getLogger("Demo");
		 PropertyConfigurator.configure("Log4j.properties");
		 logger.info("Hi Getting Logs");
		
		 
		
	}

}
