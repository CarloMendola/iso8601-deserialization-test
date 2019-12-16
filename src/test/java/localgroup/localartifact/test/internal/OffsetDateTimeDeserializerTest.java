package localgroup.localartifact.test.internal;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.TestCase;

public class OffsetDateTimeDeserializerTest extends TestCase
{
	ArrayList<String> iso8601Array = null;
	ObjectMapper mapper = null;

	public OffsetDateTimeDeserializerTest(String testName)
    {
        super(testName);
        TestUtils testUtils = new TestUtils();
        this.iso8601Array=testUtils.getIso8601Array();
		this.mapper=testUtils.getObjectMapper();
    }
    
    public void testIso8601ToOffsetDateTime()
    {
    	for(String s : iso8601Array) {
    		OffsetDateTime o = null;
    		try {
    			String json = mapper.writeValueAsString(s); // Instant -> json  - simulate write to kafka
    			o = mapper.readValue(json, OffsetDateTime.class); // json -> Instant - simulate read from kafka 
    			System.out.println("[OK] - String "+ s + " converted to OffsetDateTime -> " + o );
    		} catch (Exception e) {
    			System.out.println("[FAIL] - failed to convert string "+s+" to OffsetDateTime - "+e.getMessage());
    		}
    		assertNotNull(o);
    	}
    }
}
