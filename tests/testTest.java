import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.net.MalformedURLException;

import static org.junit.Assert.*;

public class testTest {

    private test myTest;

    @Before
    public void setUp() throws Exception {
        myTest = new test();

    }

    @Test
    public void testGetURLContent() throws Exception {

        assertNotNull("not null", myTest.getURLContent("http://www.baidu.com/", "gb2312"));

        assertNotNull("not null", myTest.getURLContent("http://www.google.co.uk/", "gb2312"));

    }

//    @Test(expected = MalformedURLException.class)
//    public void URLIsMalformedThrowsException() throws MalformedURLException {
//        myTest.getURLContent("www.baidu.com","gb2312");
//    }


    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void URLIsMalformedThrowsException() throws MalformedURLException {
        myTest.getURLContent("www.baidu.com","gb2312");
        expectedEx.expect(MalformedURLException.class);
        expectedEx.expectMessage("no protocol");

    }

    @Test
    public void testOutTag() throws Exception {

    }

    @Test
    public void testSubCounter() throws Exception {
        //assertEquals("equals", "0", myTest.subCounter(myTest.getURLContent("http://www.baidu.com/", "gb2312"), "java"));
        assertEquals("equals", "0", String.valueOf(myTest.subCounter
                (myTest.outTag(myTest.getURLContent("http://www.google.com/", "gb2312")), "java")));

        assertEquals("just-in-time", "3", String.valueOf(myTest.subCounter
                (myTest.outTag(myTest.getURLContent("http://en.wikipedia.org/wiki/Java_(programming_language)", "gb2312")), "just-in-time")));

    }


    @Test
    public void testMain() throws Exception {

    }
}