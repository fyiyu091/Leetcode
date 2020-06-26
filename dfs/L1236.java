package dfs;

/* Web crawler */

import java.util.*;

interface HtmlParser {
    public List<String> getUrls(String url);
}

public class L1236 {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> res = new ArrayList<>();
        if (startUrl == null || startUrl.length() == 0) {
            return res;
        }

        dfs(startUrl, res, new HashSet<>(), htmlParser, startUrl);
        return res;
    }

    private void dfs(String currUrl, List<String> res, Set<String> visited, HtmlParser htmlParser, String startUrl) {
        if (!visited.add(currUrl)) {
            return;
        }

        if (sameHost(startUrl, currUrl)) {
            res.add(currUrl);
            for (String nextUrl : htmlParser.getUrls(currUrl)) {
                dfs(nextUrl, res, visited, htmlParser, startUrl);
            }
        }
    }

    private boolean sameHost(String startUrl, String currUrl) {
        String[] strs1 = startUrl.split("/");
        String[] strs2 = currUrl.split("/");
        return strs1[2].equals(strs2[2]);
    }
}
