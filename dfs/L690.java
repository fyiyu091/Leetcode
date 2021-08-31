package dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }

        // Build for quick query
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return dfs(id);
    }

    private int dfs(int id) {
        int res = map.get(id).importance;
        for (int subordinate : map.get(id).subordinates) {
            res += dfs(subordinate);
        }
        return res;
    }
}
