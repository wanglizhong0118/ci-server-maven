package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ test_helpFunc.class, test_cloneRepository.class, test_compileRepository.class })
public class AllTests {

}
