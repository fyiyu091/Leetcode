package stack;


import java.util.*;

public class TextEditor {

    public TextEditor() {}

    public static String textEditor(String[][] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        Deque<StringBuilder> undo = new ArrayDeque<>();
        Deque<StringBuilder> redo = new ArrayDeque<>();
        int left = -1;
        int right = -1;

        // Sort the input based on the timestamp
        Arrays.sort(input, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                if (Long.valueOf(a[0]) - Long.valueOf(b[0]) < 0) {
                    return -1;
                }
                else if (Long.valueOf(a[0]) - Long.valueOf(b[0]) > 0) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });

        for (String[] action : input) {
            switch(action[1]) {
                case "APPEND":
                    if (undo.isEmpty()) {
                        redo.clear();
                    }
                    undo.push(new StringBuilder(sb));
                    if (left < 0 && right < 0) {
                        sb.append(action[2]);
                    }
                    else {
                        if (right >= sb.length()) {
                            right = sb.length() - 1;
                        }
                        sb.delete(left, right + 1);
                        sb.insert(left, action[2]);
                    }
                    break;

                case "BACKSPACE":
                    if (undo.isEmpty()) {
                        redo.clear();
                    }
                    undo.push(new StringBuilder(sb));
                    if (sb.length() > 0) {
                        if (left < 0 && right < 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        else {
                            if (right >= sb.length()) {
                                right = sb.length() - 1;
                            }
                            sb.deleteCharAt(right);
                            sb.deleteCharAt(left);
                        }
                    }
                    break;

                case "UNDO":
                    if (!undo.isEmpty()) {
                        StringBuilder prevSb = undo.pop();
                        redo.push(new StringBuilder(sb));
                        sb = prevSb;
                    }
                    break;

                case "REDO":
                    if (!redo.isEmpty()) {
                        StringBuilder prevSb = redo.pop();
                        undo.push(new StringBuilder(sb));
                        sb = prevSb;
                    }
                    break;

                case "SELECT":
                    left = Integer.valueOf(action[2]);
                    right = Integer.valueOf(action[3]);
                    break;

                case "BOLD":
                    if (left >= 0 && left < sb.length()) {
                        sb.insert(left, '*');
                    }
                    if (right >= 0 && right < sb.length()) {
                        sb.insert(right + 1, '*');
                    }
                    break;
            }
        }
        return String.valueOf(sb);
    }
}
