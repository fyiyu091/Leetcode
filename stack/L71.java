package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/* Simplify absolute path
   /a//b////c/d//././/.. converted to
   /a/b/c
 */
public class L71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }

        String[] strs = path.split("\\/");
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (String str : strs) {
            if (str.length() == 0 || str.equals(".")) {
                continue;
            }
            else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(str);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        return sb.toString();
    }
}
