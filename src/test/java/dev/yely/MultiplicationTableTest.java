package dev.yely;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MultiplicationTableTest {
    @Test
    public void TestGenerateMultiplicationTableFor5() {

        MultiplicationTable multiplicationTable = new MultiplicationTable();
        int numb = 5;
        List<String> expected = new ArrayList<>(
                Arrays.asList(
                        "5 x 1 = 5",
                        "5 x 2 = 10",
                        "5 x 3 = 15",
                        "5 x 4 = 20",
                        "5 x 5 = 25",
                        "5 x 6 = 30",
                        "5 x 7 = 35",
                        "5 x 8 = 40",
                        "5 x 9 = 45",
                        "5 x 10 = 50"));
        List<String> result = multiplicationTable.generateTable(numb);
        assertThat(result, is(equalTo(expected)));
    }

    @Test
    void TestPrintMultiplicationTable() {
        MultiplicationTable multiplicationTable = new MultiplicationTable();
        List<String> table = multiplicationTable.generateTable(5);
        String expected = "5 x 1 = 5\n5 x 2 = 10\n5 x 3 = 15\n5 x 4 = 20\n5 x 5 = 25\n5 x 6 = 30\n5 x 7 = 35\n5 x 8 = 40\n5 x 9 = 45\n5 x 10 = 50\n";

        PrintStream originalOut = System.out;

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStreamCaptor));

        multiplicationTable.printTable(table);

        System.setOut(originalOut);

        String result = outputStreamCaptor.toString();

        assertThat(result, is(equalTo(expected)));
    }

}
