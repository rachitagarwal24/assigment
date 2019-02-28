import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by rachit on 28/2/19.
 */
public class SolutionTest {

    /**
     * Test case
     * input : provide inputs
     * output : provide expected output
     * @throws Exception
     */
    @Test
    public void testMain() throws Exception {
        String input = "9\r\n-2 1 -3 4 -1 2 1 -5 4";
        String expected = "Largest SubArray\nStart Index: 3\nLength: 4\nSum: 6\nElements: 4 -1 2 1 ";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream console = System.out;
        System.setOut(new PrintStream(bytes));
        String args[] = null;
        try {
            Solution.main(args);
        }finally {
            System.setOut(console);
        }
        assertEquals(expected, bytes.toString());
    }

}
