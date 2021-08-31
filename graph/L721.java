package graph;

import java.util.*;

/*
    Accounts merge
    name, email1, email2
    Need to merge all the emails under the same name

    Model the question to check the connected components problem
    The trick is that we used another map to store from email to name because the name will need to be at index 0
 */

public class L721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return res;
        }

        // Need a graph that contains all the connected email
        // Need a map, key is the email and value would be the name
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> name = new HashMap<>();

        for (List<String> account : accounts) {
            String accountName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                    name.put(account.get(i), accountName);
                }
                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                // The for loop already went through i - 1, so must contains i - 1 key
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }

        // Go through each components
        Set<String> visited = new HashSet<>();
        for (String email : graph.keySet()) {
            List<String> component = new ArrayList<>();
            // We only want to touch each email once
            if (visited.add(email)) {
                dfs(graph, component, email, visited);
                Collections.sort(component);
                component.add(0, name.get(component.get(0)));
                res.add(component);
            }
        }

        return res;
    }

    private void dfs(Map<String, Set<String>> graph, List<String> component, String currEmail, Set<String> visited) {
        component.add(currEmail);

        for (String next : graph.get(currEmail)) {
            if (visited.add(next)) {
                dfs(graph, component, next, visited);
            }
        }
        return;
    }
}
