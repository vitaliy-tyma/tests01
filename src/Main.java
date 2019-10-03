import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(spaghettiMethod());
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
