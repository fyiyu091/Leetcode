package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    root/a_1.txt(abcd)_2.txt(defg)
 */
public class L609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths == null) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            // Split with spaces
            String[] pathArr = path.split("\\s+");
            for (int i = 1; i < pathArr.length; i++) {
                int idx = pathArr[i].indexOf('(');
                String content = pathArr[i].substring(idx);
                String filePath = pathArr[0] + "/" + pathArr[i].substring(0, idx);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(filePath);
            }
        }

        for (List<String> listOfPaths : map.values()) {
            // Make sure the size is greater than 1 for duplicates
            if (listOfPaths.size() > 1) {
                res.add(listOfPaths);
            }
        }

        return res;
    }
}
