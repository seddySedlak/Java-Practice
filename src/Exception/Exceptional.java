package Exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Uncomment everything inside the main() method.
 * The rules are simple:
 * 1. No try-catch blocks are allowed inside the main() method.
 * 2. No method is allowed to declare 'throws' in its header.
 * 3. You are not allowed to delete or modify existing code — only add try-catch blocks (with meaningful handling in catch).
 *  Note 3: No, catch(Exception ...) is NOT allowed — don't even try it.
 *  Note 3.2: Also, you are NOT allowed to create new files in the directory.
 */

public class Exceptional {

    static int saharaSandCounter(int countdown) {
        if (countdown > Integer.MAX_VALUE - 42)
            return 42; //yeey, you counted them all, sadly, this answer is one above all
        System.out.println("Speck of sand #" + countdown);
        return saharaSandCounter(countdown + 1);
    }

    static void subSaharaCounter() {
        System.out.println("Amount of sand in sahara counted as specks starting from 0:");
        try {
            System.out.println(saharaSandCounter(0));
        } catch (StackOverflowError stackOverflowError) {
            System.out.println("Nope StakOverflow\n");
        }
    }

    static void readMeIfYouCan(String path) {
        System.out.println("Reading file " + path + "...");
        try {
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Nope FileNotFound");
            }
        } catch (IOException ioException) {
            System.out.println("IOEXCEPTION UPS\n");
        }
    }

    static void twoAtOnceWinkWink(String name, int index) {
        String[] names = {"Karel", "Karel1", "Karel2", "Karel3", "Karel4"};
        System.out.println("Controlling whether or not our very original name database contains you... ");
        try {
            try {
                if (name.matches(names[index])) {
                    System.out.println(" Found ya!");
                }
            } catch (NullPointerException nullPointerException) {
                System.out.println(" Error: Provided name is null.");
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            System.out.println(" Error: Index \" + index + \" is out of bounds.");
        }
        System.out.println(" Finished twoAtOnceWinkWink.\\n");
    }

    static void mathGenius(String number) {
        System.out.println("Hopefully you gave a good number or this is going tits up");
        try {
            try {
                int mathematikMachtFrei = 42 / Integer.parseInt(number);
                System.out.println(mathematikMachtFrei);
            } catch (ArithmeticException arithmeticException) {
                System.out.println("Divide by zero!");
            }
        } catch (NumberFormatException numberFormatException) {
            System.out.println("NONO");
        }
        System.out.println("Yep...it did\n");
    }

    static void mathGenius(int number) {
        System.out.println("Hopefully you gave a good number or this is going tits up");
        try {
            int mathematikMachtFrei = 42 / number;
            System.out.println(mathematikMachtFrei);
        } catch (ArithmeticException arithmeticException) {
            System.out.println("Divide by zero!");
        }
        System.out.println("Yep...it did\n");
    }

    static void wellWhyNot() {
        System.out.println("Parry this you filthy casual");
        try {
            throw new RuntimeException();
        } catch (RuntimeException runtimeException) {
            System.out.println("Nope RunTimeE\n");
        }
    }

    static void poopingTheStack() {
        try {
            Stack<Integer> stack = new Stack<>();
            System.out.println(stack.pop());
        } catch (EmptyStackException emptyStackException) {
            System.out.println("Stack is empty");
        }
        System.out.println("And the stack to be popped from empty stack is...\n");
    }

    public static void main(String[] args) {
        mathGenius(0);
        mathGenius("0");
        mathGenius("cTyRiceTDva, to urcite vyjde Jedna");

        readMeIfYouCan("neverGonnaGiveYouUp.RickRoll");

        wellWhyNot();

        poopingTheStack();

        twoAtOnceWinkWink(null, 2);
        twoAtOnceWinkWink("Karel3", 42);

        System.out.println("Counting down...");
        subSaharaCounter();

        System.out.println("Nothing works, everything is fucked, therefore...");
        System.out.println("Happy ending!");
    }
}
