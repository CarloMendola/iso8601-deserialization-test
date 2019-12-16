package localgroup.localartifact;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;


public class App 
{
	public static ObjectMapper mapper = new ObjectMapper()
			.registerModule(new ParameterNamesModule())
	        .registerModule(new Jdk8Module())
	        .registerModule(new JavaTimeModule())
	        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
	    	.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        
        
    public static void main( String[] args )
    {
    	ArrayList<String> iso8601Array = new ArrayList<>();
    	
    	iso8601Array.add("2019-07-10T21:06:53.041292352+0000");
    	iso8601Array.add("2019-07-10T21:06:53+0000");
    	iso8601Array.add("2019-07-10T21:06:53+00:00");
    	iso8601Array.add("2019-07-10T21:06:57-07:00");
    	iso8601Array.add("2019-07-10T21:06:57+07:00");
//    	iso8601Array.add("2019-07-10T23:06:59+0200");  // malformed iso8601 string fails on both deserializer
    	iso8601Array.add("2019-07-10T21:07:37.168Z");
    	iso8601Array.add("2019-07-10T21:06:57.123+03:30");
    	iso8601Array.add("2019-07-10T21:06:53Z");
    	iso8601Array.add("2019-07-10T21:06:53.041292352+09:00");
    	System.out.println("---------------------------------------------------------------------------------------------");
    	System.out.println("- iso8601 string to java.time.Instant                                                       -");
    	System.out.println("---------------------------------------------------------------------------------------------");
    	testInstantSerDes(iso8601Array);
    	System.out.println("---------------------------------------------------------------------------------------------");
    	System.out.println("- iso8601 string to java.time.OffsetDateTime                                                -");
    	System.out.println("---------------------------------------------------------------------------------------------");
    	testOffsetDateTimeSerDes(iso8601Array);
    	System.out.println("---------------------------------------------------------------------------------------------");
    }
    
    private static void testInstantSerDes(ArrayList<String> iso8601Array) {
    	for(String s : iso8601Array) {
    		Instant i = null;
    		try {
    			String json = mapper.writeValueAsString(s); // Instant as iso string -> json  - simulate write to kafka
    			i = mapper.readValue(json, Instant.class); // json -> Instant - simulate read from kafka 
    			System.out.println("[OK] - String "+ s + " converted to Instant -> " + i );
    		} catch (Exception e) {
    			System.out.println("[FAIL] - failed to convert string "+s+" to Instant - "+e.getMessage());
    		}
    	}
    }
    
    private static void testOffsetDateTimeSerDes(ArrayList<String> iso8601Array) {
    	for(String s : iso8601Array) {
    		OffsetDateTime o = null;
    		try {
    			String json = mapper.writeValueAsString(s); // Instant -> json  - simulate write to kafka
    			o = mapper.readValue(json, OffsetDateTime.class); // json -> Instant - simulate read from kafka 
    			System.out.println("[OK] - String "+ s + " converted to OffsetDateTime -> " + o );
    		} catch (Exception e) {
    			System.out.println("[FAIL] - failed to convert string "+s+" to OffsetDateTime - "+e.getMessage());
    		}
    	}
    }
    
}
