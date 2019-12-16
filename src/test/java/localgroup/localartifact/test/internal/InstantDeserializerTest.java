package localgroup.localartifact.test.internal;

import java.time.Instant;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class InstantDeserializerTest extends TestCase
{
	ArrayList<String> iso8601Array = null;
	ObjectMapper mapper = null; 
	
	public InstantDeserializerTest( String testName )
    {
		super(testName);
        TestUtils testUtils = new TestUtils();
        this.iso8601Array=testUtils.getIso8601Array();
		this.mapper=testUtils.getObjectMapper();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( InstantDeserializerTest.class );
    }

    /**
     * 
     */
    public void testIso8601ToInstant()
    {
    	for(String s : iso8601Array) {
    		Instant i = null;
    		try {
    			String json = mapper.writeValueAsString(s); // Instant -> json  - simulate write to kafka
    			i = mapper.readValue(json, Instant.class); // json -> Instant - simulate read from kafka 
    			System.out.println("[OK] - String "+ s + " converted to OffsetDateTime -> " + i );
    			assertNotNull(i);
    		} catch (Exception e) {
    			System.out.println("[FAIL] - failed to convert string "+s+" to OffsetDateTime - "+e.getMessage());
    			assertNotNull("[FAIL] - failed to convert string "+s+" to OffsetDateTime - "+e.getMessage(), i);
    		}
    	}
    }
}
