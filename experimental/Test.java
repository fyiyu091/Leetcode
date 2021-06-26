package experimental;

import org.jetbrains.annotations.NotNull;

public class Test {
    static void print(@NotNull String str) {
        System.out.println(str);
    }
    public static void main(String[] args) {
        print(null);
    }
}
