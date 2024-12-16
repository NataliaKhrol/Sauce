package tests;

import org.testng.annotations.Test;

/**
 * *Пояснение студентам про String
 */

public class SttringTest {
    @Test
    public void bla() {
        String str1 = "Hello";
        String str22 = "Hello";
        String str2 = new String("Hello");
        String str34 = str1 + str22;
        System.out.println(str34);

    }
}
