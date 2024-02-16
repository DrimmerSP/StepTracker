import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует счётчик калорий!");
        StepTracker tracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();

        int userInput = scanner.nextInt();
        scanner.nextLine();

        while (userInput != 4) {
            switch (userInput) {
                case 1:
                    saveSteps(scanner, tracker);
                    break;
                case 2:
                    printStatistic();
                    break;
                case 3:
                    changeTarget();
                    break;
                default:
                    System.out.println(">>> Некорректная команда");
            }

            printMenu(); //печатаем меню ещё раз перед завершением предыдущего действия.
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя.
            scanner.nextLine();
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1. Добавить количество шагов за определённый день");
        System.out.println("2. Посмотреть статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Выход");
    }

    public static void saveSteps(Scanner scanner, StepTracker tracker) {
        System.out.println("Добавил шаги за день...");
        System.out.println("Введите месяц: ");
        String month = scanner.nextLine();
        System.out.println("Введите день: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите количество шагов: ");
        int steps = scanner.nextInt();
        scanner.nextLine();

        tracker.saveSteps(month, day, steps);
    }

    public static void printStatistic() {
        System.out.println("Вывод статистики...");
    }

    public static void changeTarget() {
        System.out.println("Меняю цель...");
    }
}
//TODO https://github.com/AndrewSukhov/java-sprint1-hw/blob/main/src/Main.java <--справка