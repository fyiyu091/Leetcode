package multithreading;

import dfs.HtmlParser;

import java.util.*;
import java.util.concurrent.*;

public class L1242 {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Deque<Future> tasks = new ArrayDeque<>();

        String targetHostName = getHostName(startUrl);
        queue.offer(startUrl);

        // Create the fixed size thread pool
        ExecutorService executor = Executors.newFixedThreadPool(4, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });

        while (true) {
            String nextUrl = queue.poll();
            if (nextUrl != null) {
                String nextHostName = getHostName(nextUrl);
                if (visited.add(nextUrl) && nextHostName.equals(targetHostName)) {
                    res.add(nextUrl);
                    // Parse the URL and offer into the queue
                    // Submit a callable which can return a value
                    tasks.add(executor.submit(() -> {
                        List<String> strs = htmlParser.getUrls(nextUrl);
                        for (String str : strs) {
                            queue.offer(str);
                        }
                    }));
                }
            }
            else {
                if (!tasks.isEmpty()) {
                    Future nextTask = tasks.poll();
                    try {
                        // Some new URLs might be added to the queue
                        // Then start the loop all over again
                        nextTask.get();
                    }
                    catch (InterruptedException | ExecutionException e) {}
                }
                else {
                    break;
                }
            }
        }

        return res;
    }

    private String getHostName(String url) {
        url = url.substring(7);
        String[] parts = url.split("/");
        return parts[0];
    }
}
