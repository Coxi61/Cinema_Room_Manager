import java.util.Scanner;


public class Main {

    public static String concatStrings(String str1, String str2) {
        /*
        str1 = str1 == null ? "" : str1;
        str2 = str2 == null ? "" : str2;

         */
        return (str1 == null ? "" : str1).concat(str2 == null ? "" : str2);
    }

    /* Do not change code below */
    public static void main(String[] args) {

        char ch = '5';
        int ch2 = 6;
        System.out.printf("Marks for my assignment is %d%d",ch, ch2);

        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        str1 = "null".equalsIgnoreCase(str1) ? null : str1;
        str2 = "null".equalsIgnoreCase(str2) ? null : str2;

        System.out.println(concatStrings(str1, str2));

        String s = null;
        System.out.println(s);
    }
}