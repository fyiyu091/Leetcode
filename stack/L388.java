package stack;

/* Longest absolute file path
*  Find the longest length to a file
*  If no file exists return 0
*
*  dir
*     subdir1
*     subdir2
*         file.ext
*
* The answer will be dir/subdir2/file.ext -> 20
* Stack stores the length of each directory + /
* The stack doesn't store .ext files
* The size of the stack is the deepest + 1 because need to push 0 in
* */

import java.util.ArrayDeque;
import java.util.Deque;

public class L388 {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        String[] strs = input.split("\n");
        Deque<Integer> stack = new ArrayDeque<>(); // stack stores path length, e.g. dir/ -> 4
        stack.push(0);
        int res = 0;

        for (int i = 0; i < strs.length; i++) {
            int level = strs[i].lastIndexOf('\t') + 1; // \t\tgood -> level is 1 + 1 = 2
            int len = strs[i].length() - level; // len is the actual directory or file name

            while (level < stack.size() - 1) { // because we add 0, 0 dir subdir1 this case size is 3, when level 2 == 3 - 1 we don't need to pop
                stack.pop();
            }

            if (strs[i].contains(".")) {
                res = Math.max(res, stack.peek() + len);
            }
            else {
                stack.push(stack.peek() + len + 1); // because need to peek, need to add 0 firstly
            }
        }

        return res;
    }
}
