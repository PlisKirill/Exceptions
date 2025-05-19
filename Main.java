import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker checker = new PasswordChecker();

        System.out.print("Введите мин. длину пароля: ");
        int number1 = Integer.parseInt(scanner.nextLine());
        try {
            checker.setMinLength(number1);
        } catch (IllegalArgumentException e) {
            System.out.println("Недопустимое значение!");
        }
        System.out.println();

        System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
        int number2 = Integer.parseInt(scanner.nextLine());
        try {
            checker.setMaxRepeats(number2);
        } catch (IllegalArgumentException e) {
            System.out.println("Недопустимое значение!");
        }
        System.out.println();

        while (true) {
            System.out.println("Введите пароль или end: ");
            String input = scanner.nextLine();
            try {
                if (checker.verify(input) == true) {
                    System.out.println("Подходит!");
                } else System.out.println("Не подходит!");
                System.out.println();
            } catch (IllegalStateException e) {
                System.out.println("Не все параметны заданы!");
            }

            if ("end".equals(input)) {
                break;
            }
        }
        System.out.println("Программа завершена");
    }
}
