package localgroup.localartifact.test.internal;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class TestUtils {

	private ArrayList<String> iso8601Array = null;
	private ObjectMapper mapper = new ObjectMapper()
			.registerModule(new ParameterNamesModule())
	        .registerModule(new Jdk8Module())
	        .registerModule(new JavaTimeModule())
	        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
	    	.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	public TestUtils() {
		iso8601Array = new ArrayList<>();
		iso8601Array.add("2019-07-10T21:06:53.041292352+0000");
    	iso8601Array.add("2019-07-10T21:06:53+0000");
    	iso8601Array.add("2019-07-10T21:06:53+00:00");
    	iso8601Array.add("2019-07-10T21:06:57-07:00");
    	iso8601Array.add("2019-07-10T21:06:57+07:00");
    	iso8601Array.add("2019-07-10T21:07:37.168Z");
    	iso8601Array.add("2019-07-10T21:06:57.123+03:30");
    	iso8601Array.add("2019-07-10T21:06:53Z");
    	iso8601Array.add("2019-07-10T21:06:53.041292352+09:00");
	}
	
	public ArrayList<String> getIso8601Array() {
		return iso8601Array;
	}

	public ObjectMapper getObjectMapper() {
		return mapper;
	}

}
