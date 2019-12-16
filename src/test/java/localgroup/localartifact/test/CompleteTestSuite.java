package localgroup.localartifact.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import localgroup.localartifact.test.internal.InstantDeserializerTest;
import localgroup.localartifact.test.internal.OffsetDateTimeDeserializerTest;

@RunWith(Suite.class)
@SuiteClasses({OffsetDateTimeDeserializerTest.class,InstantDeserializerTest.class})
public class CompleteTestSuite {

	
}
