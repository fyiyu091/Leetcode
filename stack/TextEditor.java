package stack;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class TextEditor {
    private StringBuilder sb;
    private Deque<String[]> undo;
    private Deque<String[]> redo;

    public TextEditor() {
        this.sb = new StringBuilder();
        this.undo = new ArrayDeque<>();
        this.redo = new ArrayDeque<>();
    }

    public String edit(String[][] actions) {
        if (actions == null) {
            return null;
        }

        for (String[] action : actions) {
            switch(action[1]) {
                case "APPEND":
                    sb.append(action[2]);
                    if ((undo.isEmpty() && !redo.isEmpty()) || (!undo.isEmpty() && redo.isEmpty())) {
                        undo.clear();
                        redo.clear();
                    }
                    undo.push(action);
                break;

                case "BACKSPACE":
                    if ((undo.isEmpty() && !redo.isEmpty()) || (!undo.isEmpty() && redo.isEmpty())) {
                        undo.clear();
                        redo.clear();
                    }
                    buildStrArray(sb, undo, action);
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                break;

                case "UNDO":
                    if (!undo.isEmpty()) {
                        String[] prevAction = undo.pop();
                        if (prevAction[1].equals("BACKSPACE")) {
                            sb.append(prevAction[2]);
                        }
                        else {
                            int length = prevAction[2].length();
                            // 0 1 2 3 4 5, length is 2, [4 which is (6 - 2), 5]
                            sb.delete(sb.length() - length, sb.length());
                        }
                        redo.push(prevAction);
                    }
                break;

                case "REDO":
                    if (!redo.isEmpty()) {
                        String[] prevAction = redo.pop();
                        if (prevAction[1].equals("APPEND")) {
                            sb.append(prevAction[2]);
                        }
                        else {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        undo.push(prevAction);
                    }
                break;

                case "SELECT":
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

    private void buildStrArray(StringBuilder sb, Deque<String[]> undo, String[] action) {
        String[] res = new String[3];
        for (int i = 0; i < 2; i++) {
            res[i] = action[i];
        }
        if (sb.length() > 0) {
            res[2] = String.valueOf(sb.charAt(sb.length() - 1));
            undo.push(res);
        }
    }

    private void clear() {
        sb = new StringBuilder();
        undo.clear();
        redo.clear();
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
        TextEditor te = new TextEditor();
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
        System.out.println("The input1 result is: " + res1);
        System.out.println("--------------------");
        te.clear();

        String[][] input2 = new String[][] {{"0", "APPEND", "str"},
                {"1", "UNDO"},
                {"2", "APPEND", "there"},
                {"3", "REDO"}};
        String res2 = te.edit(input2);
        System.out.println("The input2 result is: " + res2);
        System.out.println("--------------------");

        StringBuilder test1 = new StringBuilder();
        test1.append("abcdefgh");
        test1.insert(3, '*');
        test1.insert(5, '*');
//        test1.insert(15, '*');
        System.out.println(test1.toString());


    }


}
