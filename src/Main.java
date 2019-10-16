import java.io.*;
import java.util.*;

interface I {
    boolean equals(I x);
    int hashCode();
}



//MAIN
public class Main {

    static class A {
        private int id;

        A(int id) {
            this.id = id;
        }
    }

    static class A4 implements I {

        private int x, y;

        public A4(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x;
        }

        @Override
        public boolean equals(I o) {
            if (this == o) return true;
            if (!(o instanceof A4)) return false;
            A4 a = (A4) o;
            return x == a.x &&
                    y == a.y;
        }
    }

    static class A1 implements Serializable {

        private static int serialVersionUID = 188713;
        private transient int id;

        A1(int id) {
            this.id = id;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A1 that = (A1) o;
            return this.id == that.id;
        }

        @Override public int hashCode() {
            return id;
        }
    }




    static class Id implements Comparable<Id>{
        public final int id;

        public Id(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Id o) {
            return id - o.id;
        }

        @Override
        public int hashCode() {
            return 42;
        }
    }




    class Business {}
    class Hotel extends Business {} //T
    class Inn extends Hotel {} //S

    public class Travel {
        ArrayList<Hotel> go() { //T
            //Insert code here
            return new ArrayList<Hotel>();
            //return new ArrayList<Object>();
            //return new ArrayList<Main.Inn>(); //Liskov substitution principle? //S
            //return new ArrayList<Main.Business>();
        }
    }

////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println("Skillotron DataArt tests!");

        //1
        System.out.println(spaghettiMethod()); //Starting execution Illegal IO finally 3

        //2
        minMethod();



        //3
        print03(new ArrayList<Number>(Arrays.asList(1, 2, 3)));


        //4
        out04();



        //05
        List<A> list = new ArrayList<>();
        Set<A> set = new HashSet<>();

        A a1 = new A(1);
        A a2 = new A(1);
        A a3 = a1;

        list.add(a1);
        list.add(a2);
        list.add(a3);

        set.add(a1);
        set.add(a2);
        set.add(a3);

        System.out.println("\nList size: "+list.size()+" Set size: "+set.size());


        //06
        StringBuilder sb = new StringBuilder("01234567");
        sb.insert(4, "---");
        System.out.println(sb);



        //07
        try {
            File file = new File("test.txt");
            A1 a = new A1(1);
            A1 b = new A1(1);

            System.out.println("\n\na.id = " + a.id);
            System.out.println("\n\na.id = " + a.id);
            System.out.println("a equals to b: "+ a.equals(b));

            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(a);
            os.close();

            ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
            a = (A1)is.readObject();
            System.out.println("a.id = " + a.id);
            System.out.println("a equals to b: "+a.equals(b));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        //08
        double f = 10.10;
        System.out.println("");
        System.out.printf("test %-+10.4f text\n", f);
        System.out.printf("%-+10.8f text\n", f);
        System.out.printf("%+10.8f text\n", f);
        System.out.printf("%-1.1f text\n", f);
        System.out.println("");




        //09
        System.out.println("\nTEST 09");
        HashSet<Id> hashIds = new HashSet<>();
        TreeSet<Id> treeIds = new TreeSet<>();

        Id idOne = new Id(1);
        Id idTwo = new Id(1);
        Id idThree = new Id(2);

        hashIds.add(idOne);
        hashIds.add(idTwo);
        hashIds.add(idThree);

        treeIds.add(idOne);
        treeIds.add(idTwo);
        treeIds.add(idThree);

        for (Id id : hashIds) {
            System.out.print(id.id);
        }

        System.out.println("\nLambda test");
        hashIds.stream().forEach(id -> System.out.print(id.id));

        System.out.println();
        for (Id id : treeIds) {
            System.out.print(id.id);
        }



        //10
        System.out.println("\nTEST 10");
        System.out.format("%10.4f", 12.3);






        //11
        System.out.println("\nTEST 11");
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("a", "ant"); map.put("d", "dog"); map.put("h", "horse");

        SortedMap<String, String> subMap = map.subMap("b", "g");
        System.out.println(map+" "+subMap);

        map.put("b", "bat"); //#1
        subMap.put("f", "fish");//#2
        map.put("r", "raccoon");//#3
        System.out.println(map+" "+subMap);
        //{a=ant, d=dog, h=horse} {d=dog}
        //{a=ant, b=bat, d=dog, f=fish, h=horse, r=raccoon} {b=bat, d=dog, f=fish}


        //12
        System.out.println("\nTEST 12");
        //INSERT CODE HERE
        //List<List<Integer>> table = new ArrayList<ArrayList<Integer>>();
        //+List<List<Integer>> table = new ArrayList<>();
        //-List<List<Integer>> table = new ArrayList<ArrayList, Integer>();
        //-List<List<Integer>> table = new List<List<Integer>>();
        List<List<Integer>> table = new ArrayList<List<Integer>>();

        for (int i = 0; i < 10; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < 10; j++) {
                row.add(i * j);
            }
            table.add(row);
        }
        for (List<Integer> row : table) {
            System.out.println(row);
        }





        //13
        System.out.println("\nTEST 13");
        Set set1 = new TreeSet();
        set1.add("2");
        set1.add("1"); // 1 - runtime error
        set1.add("3");
        for (Iterator iterator = set1.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next() + " ");
        }

        //set1.get
        //set1.stream().forEach( -> System.out.print());


        //14
        System.out.println("\nTEST 14");
        String s = "Java";
        s = s.concat(" Rules!");
        System.out.println("s = " + s); //s = Java Rules!


        //15
        System.out.println("\nTEST 15");
        Thread t  = new Thread(() -> {
            int a = 0;
            while(true) {
                a++;
            }
        });
        t.start();
        t.interrupt();
        if (t.isInterrupted()) {
            System.out.println("Thread is interrupted");// Thread has been interrupted on above statement
        }


        System.out.println("\nTEST 16");
        A4 a41 = new A4(0,0);
        A4 a42 = new A4(0,0);
        System.out.println(((Object)a41).equals(a42));

        A4 a43 = new A4(0,0);
        A4 a44 = new A4(0,0);
        System.out.println(a43.equals(a44));





        System.out.println("\nTEST 17");
        System.out.println("\n\n++l + l++ + ++k + l");
        int l = 0;
        int k = 2;
        //++l = 1
        //++k = 3
        //1 + 2 + 3 + 1 = 7
        System.out.println(++l + l++ + ++k + l); // Output 7



        System.out.println("\nTEST 18");
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;

        System.out.println(String.format("\na = %s (HashCode  = %s)", a, System.identityHashCode(a))); // similar
        System.out.println(String.format("b = %s (HashCode  = %s)", b, System.identityHashCode(b))); // similar
        System.out.println("(a == b) = " + (a == b)); // true
        System.out.println("(a.equals(b)) = " + (a.equals(b))); // true

        System.out.println(String.format("\nc %s - HashCode %s", c, System.identityHashCode(c))); // different
        System.out.println(String.format("d %s - HashCode %s", d, System.identityHashCode(d))); // different
        System.out.println("(c == d) = " + (c == d));// false
        System.out.println("(c.equals(d)) = " + (c.equals(d)));// true


        System.out.println("\nTEST 19");
        Integer i = new Integer("10");
        System.out.println("i = " + i + ". identityHashCode = " + System.identityHashCode(i.toString()));
        System.out.println("i = " + i + ". identityHashCode = " + System.identityHashCode(i.toString()));

        if (i.toString() == i.toString()) {
            System.out.println("i.toString() == i.toString() = Equals");
        } else {
            System.out.println("i.toString() == i.toString() = Not equals"); // Not equals
        }


        System.out.println("\nTEST 20");
        Set objects = new HashSet();
        objects.add(new Boolean(true));
        new Foo().print(objects);



        System.out.println("\nTEST 21");
        System.out.print("\n**************** STATIC BLOCK 2\n");
        new Test();


        //last one
        System.out.println("\nTEST LAST ONE");
        try {
            System.out.println("try");
            System.exit(0);
        } finally {
            System.out.println("finally");// is not reachable here - after System.exit(0);
        }
    }


    static {
        System.out.print("\n**************** STATIC BLOCK 3\n");
    }

    public static class Test {
        {
            System.out.print("\n**************** STATIC BLOCK 1\n");
        }
    }

        static class Foo {
       /* public void print(Set<Boolean> strSet) {//'print(Set<Boolean>)' clashes with 'print(Set<Integer>)'; both methods have same erasure
            System.out.println("Boolean");
        }*/

        public void print(Set<Integer> intSet) {
            System.out.println("Integer");
        }
    }

    public static void minMethod() {
        int a = 1;
        int b = 10;
        //java.util.Integer.min(a, b);
        //java.math.Min.int(a,b);
        int c = java.lang.Math.min(a,b);
        System.out.println(c);

    }


    public static void out04() {
        System.out.printf("%3$d + %2$d + %1$d", 123, 456, 789);
    }

    public static void print03(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }


    public void aMethod() throws IOException {
        System.out.println("1");

        throw new IOException("error");
    }


    public static int spaghettiMethod() {
        try {
            System.out.println("Starting execution");
            throw new IOException();
        } catch (IOException ex) {
            System.out.println("Illegal IO");
            return 1;
        } catch (IllegalArgumentException ex) {
            System.out.println("Illegal argument");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }
}
