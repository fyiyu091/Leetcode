package experimental;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Student {
    class Teacher {
        private String name;
    }
    int age;
    String name;
    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            return ((Student) o).age == this.age;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.err.println(Arrays.hashCode(a) == Arrays.hashCode(b));
        System.err.println(a.hashCode() == b.hashCode());
        Set<int[]> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println(set.size());
//        List<String> res = new ArrayList<>();
//        for (String str : res) {
//            System.err.println(str);
//        }
//        Random rand = new Random();
//        List<Integer> list = new ArrayList<>();
//        int a = Integer.MIN_VALUE;
//        int b = -1;
//        System.err.println(Math.abs(a));
//        System.err.println(Math.abs(b));
//        Student s1 = new Student(20, "xiaoming");
//        Student s2 = new Student(20, "xiaohuang");
//        Set<Student> set = new HashSet<>();
//        set.add(s1);
//        set.add(s2);
//        /*
//           this will add both s1 and s2 into the bucket, because when add s2, we find the bucket first
//           the bucket is found based on name, not age, so then we use age to compare two object, and then they
//           are not equal
//         */
//        System.err.println(set.size());
//        if (null instanceof Student) {
//            System.err.println("am here");
//        }
//        else {
//            System.err.println("nice");
//        }
//
//        LinkedList<Integer>[] graph = (LinkedList<Integer>[]) new LinkedList[2];
//        for (int i = 0; i < 2; i++) {
//            graph[i] = new LinkedList<>();
//        }
//        for (Integer x : graph[1]) {
//            System.err.println(x);
//        }
    }
}
