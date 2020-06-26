package amazonoa;

import java.util.*;

public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return new String[0];
        }

        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String[] strs1 = a.split("\\W", 2);
                String[] strs2 = b.split("\\W", 2);
                boolean isDigit1 = Character.isDigit(strs1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(strs2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int comp = strs1[1].compareTo(strs2[1]);
                    if (comp == 0) {
                        return strs1[0].compareTo(strs2[0]);
                    }
                    return comp;
                }
                else if (!isDigit2) {
                    return 1;
                }
                else if (!isDigit1) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });

        return logs;
    }
}
