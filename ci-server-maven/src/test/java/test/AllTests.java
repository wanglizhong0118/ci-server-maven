package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ test_Utils.class, test_cloneRepository.class, test_mavenRepository.class, test_notification.class })
public class AllTests {

}
