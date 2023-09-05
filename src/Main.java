import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вас приветствует счётчик пройденных шагов!");
        Scanner scanner = new Scanner(System.in);
        printMenu();  //todo
        int userInput = scanner.nextInt();

        while (userInput != 0){
            //todo someting

            printMenu(); //печатаем меню ещё раз перед завершением предыдущего действия.
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя.
        }
        System.out.println("Программа завершена");
    }
    public static void printMenu(){

    }
}