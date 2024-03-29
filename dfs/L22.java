package dfs;

/* Generate parentheses */

/*
                   (        ) (This right parenthesis is already delta < 0 so the next level would just return)
          ((       ()      )(         ))
    ((( (()  ()(  ())   )(( )()   ))(   )))
 */
import java.util.ArrayList;
import java.util.List;

public class L22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        dfs(res, new StringBuilder(), n, 0);
        return res;
    }

    // Why does it return void instead of a value up, it's like we need a storage to store all the solutions when we goes
    // very deep
    private void dfs(List<String> res, StringBuilder path, int n, int delta) {
        if (path.length() == 2 * n && delta == 0) {
            res.add(path.toString());
            return;
        }
        if (path.length() == 2 * n || delta < 0) {
            return;
        }
        path.append('(');
        dfs(res, path, n, delta + 1);
        path.setLength(path.length() - 1);

        path.append(')');
        dfs(res, path, n, delta - 1);
        path.setLength(path.length() - 1);
        return;
    }
}
