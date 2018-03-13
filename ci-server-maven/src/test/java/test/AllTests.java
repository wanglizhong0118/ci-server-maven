package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Junit test suite
 * 
 * @author allwi
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ test_Utils.class, test_cloneRepository.class, test_compileRepository.class })
public class AllTests {

}
