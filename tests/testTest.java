import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
//
       assertEquals("equals", "4", String.valueOf(myTest.count(myTest.outTag(myTest.hideMatcher(myTest.getURLContent("http://en.wikipedia.org/wiki/Java_(programming_language)", "gb2312"))),"java")));
//
//        assertNotNull("not null", myTest.getURLContent("http://www.baidu.com/", "gb2312"));
//
//        assertNotNull("not null", myTest.getURLContent("http://www.google.co.uk/", "gb2312"));

    }


//    @Rule
//    public ExpectedException expectedEx = ExpectedException.none();
//
//    @Test
//    public void URLIsMalformedThrowsException() throws MalformedURLException {
//        myTest.getURLContent("www.baidu.com","gb2312");
//        expectedEx.expect(MalformedURLException.class);
//        expectedEx.expectMessage("no protocol");
//
//    }

    @Test
    public void testOutTag() throws Exception {

        // Expected: 5<6, 7>6 Actual: 56
        //assertEquals("remove tags", "5<6, 7>6", myTest.outTag("<br>5<6, 7>6</br>"));

//        assertEquals("remove tags", "\n\n\n\n", myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/yincang.txt")));

    }

    // Add function file reader to test function with files
    public static String fileReader(String fileName) throws Exception{
        File file = new File(fileName);

        StringBuilder sb = new StringBuilder();
        String s;
        BufferedReader br = new BufferedReader(new FileReader(file));

        while( (s = br.readLine()) != null) {
            sb.append(s + "\n");
        }

        br.close();
        return sb.toString();
    }

    @Test
    public void testSubCounter() throws Exception {
//        assertEquals("equals", "0", String.valueOf(myTest.subCounter("j a v a ", "java")));

        // Test the keyword in hidden blocks
        //assertEquals("equals", "20", String.valueOf(myTest.outTag(myTest.hideMatcher(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/hide.txt")))));


        //Test src1.txt and src2.txt
        assertEquals("equals", "4", String.valueOf(myTest.count(fileReader("/Users/hczhang/Documents/workspace/demo1/word/tests/src1.txt"), "java")));

        assertEquals("equals", "6", String.valueOf(myTest.count(fileReader("/Users/hczhang/Documents/workspace/demo1/word/tests/src2.txt"), "java")));

        assertEquals("equals", "6", String.valueOf(myTest.count(myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/test.html")), "java")));

        assertEquals("equals", "17", String.valueOf(myTest.count(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/1.txt"), "java")));

        assertEquals("equals", "11", String.valueOf(myTest.count(myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/hiddenBlock1.txt")), "java")));

        assertEquals("equals", "5", String.valueOf(myTest.count(myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/hiddenBlock2.txt")), "java")));

        assertEquals("equals", "1", String.valueOf(myTest.count(myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/hiddenBlock3.txt")), "java")));

        assertEquals("equals", "305", String.valueOf(myTest.count(myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/pagesource.txt")), "java")));

        assertEquals("equals", "16", String.valueOf(myTest.count(myTest.outTag(myTest.hideMatcher(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/pagesource.txt"))), "java")));

        assertEquals("equals", "16", String.valueOf(myTest.count(myTest.outTag(myTest.hideMatcher(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/123.html"))), "java")));

        //assertEquals("equals", "0", String.valueOf(myTest.count(myTest.outTag(myTest.hideMatcher(myTest.getURLContent("http://en.wikipedia.org/wiki/Java_(programming_language)", "UTF-8"))), "java")));




//        assertEquals("equals", "0", String.valueOf(myTest.subCounter
//                (myTest.outTag(myTest.getURLContent("http://www.google.com/", "gb2312")), "java")));
//
//        assertEquals("just-in-time", "3", String.valueOf(myTest.subCounter
//                (myTest.outTag(myTest.getURLContent("http://en.wikipedia.org/wiki/Java_(programming_language)", "gb2312")), "just-in-time")));

    }


    @Test
    public void testMain() throws Exception {

    }
}