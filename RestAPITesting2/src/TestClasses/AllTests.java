package TestClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses(
		{
			TestDeleteRestAPI.class,
		    TestGetRestAPI.class,
		    TestPostRestAPI.class,
		    TestPutRestAPI.class 
		})

public class AllTests
{

}
