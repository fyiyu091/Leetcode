package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class CodeSignalTextEditor {
    private StringBuilder sb;
    private Deque<StringBuilder> undo;
    private Deque<StringBuilder> redo;
    private int left;
    private int right;

    public CodeSignalTextEditor() {
        this.sb = new StringBuilder();
        this.undo = new ArrayDeque<>();
        this.redo = new ArrayDeque<>();
        this.left = -1;
        this.right = -1;
    }

    public String edit(String[][] actions) {
        if (actions == null) {
            return null;
        }

        for (String[] action : actions) {
            switch(action[1]) {
                case "APPEND":
                    if ((undo.isEmpty() && !redo.isEmpty()) || (!undo.isEmpty() && redo.isEmpty())) {
                        undo.clear();
                        redo.clear();
                    }
                    undo.push(new StringBuilder(sb));
                    if (this.left < 0 && this.right < 0) {
                        sb.append(action[2]);
                    }
                    else {
                        if (right >= sb.length()) {
                            right = sb.length() - 1;
                        }
                        sb.replace(left, right, action[2]);
                    }

                    break;

                case "BACKSPACE":
                    if ((undo.isEmpty() && !redo.isEmpty()) || (!undo.isEmpty() && redo.isEmpty())) {
                        undo.clear();
                        redo.clear();
                    }
                    undo.push(new StringBuilder(sb));
                    if (sb.length() > 0) {
                        if (this.left < 0 && this.right < 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        else {
                            if (right >= sb.length()) {
                                right = sb.length() - 1;
                            }
                            sb.deleteCharAt(left);
                            sb.deleteCharAt(right);
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
                        undo.push(sb);
                        sb = prevSb;
                    }
                    break;

                case "SELECT":
                    this.left = Integer.valueOf(action[2]);
                    this.right = Integer.valueOf(action[3]);
                    break;

                case "BOLD":
                    int left = Integer.valueOf(action[2]);
                    int right = Integer.valueOf(action[3]);
                    if (left >= 0 && left < sb.length()) {
                        sb.insert(left, '*');
                    }
                    if (right >= 0 && right < sb.length()) {
                        sb.insert(right, '*');
                    }
                    break;
            }
        }

        return String.valueOf(sb);
    }

    private void clear() {
        sb = new StringBuilder();
        undo.clear();
        redo.clear();
        this.left = -1;
        this.right = -1;
    }

    private static String[][] inputGenerator(int numOfInputs) {
        String[][] input = new String[numOfInputs][3];
        String[] actions = new String[] {"APPEND", "BACKSPACE", "UNDO", "REDO"};
        String[] strs = new String[] {"", " ", "yes", "_good", "lucky_-", "_Crazy_-_-"};
        Random rand = new Random();
        for (int i = 0; i < numOfInputs; i++) {
            int nextAction = rand.nextInt(4);
            int nextStr = rand.nextInt(6);
            input[i][0] = String.valueOf(i);
            input[i][1] = actions[nextAction];
            input[i][2] = strs[nextStr];
            System.out.println("Action is " + input[i][1]);
            System.out.println("Str is " + input[i][2]);
            System.out.println("----------------------");
        }
        return input;
    }

    public static void main(String[] args) {
        CodeSignalTextEditor te = new CodeSignalTextEditor();
        //String[][] input1 = inputGenerator(5);
        String[][] input1 = new String[][] {{"0", "APPEND", "sdfsd"},
                {"1", "UNDO"},
                {"2", "UNDO"},
                {"3", "REDO"},
                {"4", "UNDO"},
                {"5", "BACKSPACE"},
                {"6", "APPEND", "hello"},
                {"7", "UNDO"},
                {"8", "REDO"}};
        String res1 = te.edit(input1);
        System.out.println("The input1 result is: " + res1); // hello
        System.out.println("--------------------");
        te.clear();

        String[][] input2 = new String[][] {{"0", "APPEND", "str"},
                {"1", "UNDO"},
                {"2", "APPEND", "there"},
                {"3", "REDO"},
                {"4", "SELECT", "0", "2"},
                {"5", "APPEND", "go"},
                {"6", "BACKSPACE", "1", "3"}};
        String res2 = te.edit(input2);
        System.out.println("The input2 result is: " + res2); // oee
        System.out.println("--------------------");
        te.clear();

        String[][] input3 = new String[][] {{"0", "APPEND", "This"},
                {"1", "APPEND", " is "},
                {"2", "BACKSPACE"},
                {"3", "APPEND", " a "},
                {"4", "APPEND", "second test"}};
        String res3 = te.edit(input3);
        System.out.println("The input2 result is: " + res3); // This is a second test
        System.out.println("--------------------");
        te.clear();
    }
}
