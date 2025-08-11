package dev.yely;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationTable {
    public List<String> generateTable(int numb) {
        List<String> table = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int multiplicationResult = numb * i;
            String row = "%d x %d = %d".formatted(numb, i, multiplicationResult);
            table.add(row);
        }
        return table;
    }
}
