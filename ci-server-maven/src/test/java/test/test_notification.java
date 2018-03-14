package test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import app.notification;

/**
 * Test case for class notification
 * 
 * @author allwi
 *
 */
public class test_notification {

    /**
     * Defining an instance of ExpectedException
     */
    @Rule
    public ExpectedException runtimeException = ExpectedException.none();

    /**
     * Test if mail message can accept non-existing file
     */
    @Test
    public void test_init_FileNotExist() {
        String test_logFilePath = new String();
        runtimeException.expect(RuntimeException.class);
        notification.init(test_logFilePath);
    }

}
