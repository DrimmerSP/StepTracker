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
                    printStatistic(scanner, tracker);
                    break;
                case 3:
                    changeTarget(scanner, tracker);
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
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("╠1. Добавить количество шагов за определённый день ╣");
        System.out.println("╠2. Посмотреть статистику за определённый месяц    ╣");
        System.out.println("╠3. Изменить цель по количеству шагов в день       ╣");
        System.out.println("╠4. Выход                                          ╣");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    public static void saveSteps(Scanner scanner, StepTracker tracker) {
        System.out.println("Добавть шаги за день...");
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

    public static void printStatistic(Scanner scanner, StepTracker tracker) {
        System.out.println("Введите месяц: ");
        String month = scanner.nextLine();
        System.out.println("┌───────────────────────────────────────────────—→");
        System.out.printf("├-Вывод статистики за <%s>:%n", month);
        System.out.println("└↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        tracker.printStatistic(month);
    }

    public static void changeTarget(Scanner scanner, StepTracker tracker) {
        System.out.println("Меняю цель...");
        System.out.println("Введите новую цель в шагах: ");
        int targetStepsCount = scanner.nextInt();
        scanner.nextLine();
        tracker.changeTarget(targetStepsCount);
    }
}
