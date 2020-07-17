import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.print("Result: ");
        if (operation.equals("sum")) System.out.println(a + b);
        if (operation.equals("dif")) System.out.println(a - b);
        if (operation.equals("mul")) System.out.println(a * b);
        if (operation.equals("div")) System.out.println(a / b);
    }
}