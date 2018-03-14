package test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import app.notification;

public class test_notification {

    /**
     * Test if mail message can accept non-existing file
     */
    @Rule
    public ExpectedException runtimeException = ExpectedException.none();

    @Test
    public void test_init_FileNotExist() {
        String test_logFilePath = new String();
        runtimeException.expect(RuntimeException.class);
        notification.init(test_logFilePath);
    }

}
