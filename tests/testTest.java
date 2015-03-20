import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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


    @Test
    public void testOutTag() throws Exception {


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
    public void testCount() throws Exception {
        assertEquals("equals", "0", String.valueOf(myTest.count("j a v a ", "java")));

        // Test some special characters
        assertEquals("equals", "2", String.valueOf(myTest.count("The Java® Language Specification (Java SE 8 ed.).", "java")));

        assertEquals("equals", "1", String.valueOf(myTest.count(" 1.2 Design Goals of the Java™ Programming Language", "java")));

        //Test src1.txt and src2.txt
        assertEquals("equals", "4", String.valueOf(myTest.count(fileReader("/Users/hczhang/Documents/workspace/demo1/word/tests/src1.txt"), "java")));

        assertEquals("equals", "6", String.valueOf(myTest.count(fileReader("/Users/hczhang/Documents/workspace/demo1/word/tests/src2.txt"), "java")));

        // There is one java word in <head></head>, but removed from main function, so here for the test it is 305 + 1
        assertEquals("equals", "306", String.valueOf(myTest.count(myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/test.html")), "java")));

        // Test each hidden block
        assertEquals("equals", "11", String.valueOf(myTest.count(myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/hiddenBlock1.txt")), "java")));

        assertEquals("equals", "5", String.valueOf(myTest.count(myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/hiddenBlock2.txt")), "java")));

        assertEquals("equals", "1", String.valueOf(myTest.count(myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/hiddenBlock3.txt")), "java")));

        // test if the table title (shown) is removed
        assertEquals("equals", "16", String.valueOf(myTest.count(myTest.outTag(myTest.hideMatcher(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/pagesource.txt"))), "java")));


        // There is one java word in <head></head>, but removed from main function, so here for the test it is 305 + 1
        assertEquals("equals", "306", String.valueOf(myTest.count(myTest.outTag(fileReader("/Users/hczhang/Documents/workspace/demo1/word/src/pagesource.txt")), "java")));


        // test if it is correct when retrieving from the URL
        assertEquals("equals", "16", String.valueOf(myTest.count(myTest.outTag(myTest.hideMatcher(myTest.getURLContent("http://en.wikipedia.org/wiki/Java_(programming_language)", "gb2312"))),"java")));

    }


    @Test
    public void testMain() throws Exception {

    }
}