import coursePaper.*;


import java.security.Provider;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static coursePaper.TaskType.PERSONAL;


public class Main {
    private final static DateTimeFormatter TASK_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final static ServiceTask<Task> serviceTask = new ServiceTask<>();


    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    scanner.reset();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            // todo: обрабатываем пункт меню 2
                            System.out.println(" Введите название задачи, которую вы хотите удалить");
                            String taskName = scanner.next();
                            serviceTask.removeTask(taskName);
                            break;
                        case 3:
                            // todo: обрабатываем пункт меню 3
                            System.out.print("Введите дату, задачи на которую хотите получить: ");
                            LocalDate date = LocalDate.parse(scanner.next(), FORMAT);
                            System.out.println(serviceTask.getTasksForDay(LocalDate.from(date)));
                            break;
                        case 4:
                            serviceTask.printTasks();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");



                }
            }
        }
        printMenu();
    }

    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу\n2. Удалить задачу\n3. Получить задачу на указанный день\n0. Выход");
    }


    private static void inputTask(Scanner scanner) {

        // todo
        String taskName = readString("Введите название задачи", scanner);
        System.out.print("Введите тип повторяемости задачи: ");
        RepeatType repeatType = readTaskRepeatType(scanner);
        String description = readString("Введите описание задачи", scanner);
        LocalDateTime date = readTaskDate(scanner);
        System.out.print("Введите тип задачи: ");
        TaskType type = readTaskType(scanner);
        switch (repeatType) {
            case SINGLE:
                serviceTask.addTask(new SingleTask(taskName, description, type, date, repeatType));
                break;
            case DAILY:
                serviceTask.addTask(new DailyTask(taskName, description, type, date, repeatType));
                break;
            case WEEKLY:
                serviceTask.addTask(new WeeklyTask(taskName, description, type, date, repeatType));
                break;
            case MONTHLY:
                serviceTask.addTask(new MonthlyTask(taskName, description, type, date, repeatType));
                break;
            case ANNUAL:
                serviceTask.addTask(new AnnualTask(taskName, description, type, date, repeatType));
                break;
        }
    }

    private static TaskType readTaskType(Scanner scanner) {
        System.out.println(" Выберите тип задач\n1. Персолнальная\n 2. Рабочая");
        while (true) {
            try {
                System.out.println(" Введите тип задачи:");

                int taskTypeSelector = scanner.nextInt();

                switch (taskTypeSelector) {
                    case 1:
                        return PERSONAL;
                    case 2:
                        return TaskType.WORK;
                    default:
                        System.out.println(" Введен неправильный тип задачи");
                }
            } catch (Exception e) {
                System.out.println(" Введен неправильный тип задачи");
                //scanner.nextLine();

            }
        }

    }

    private static LocalDateTime readTaskDate(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите дату и время выполнения задачи: ");
                String dateTimeToken = scanner.nextLine();
                return LocalDateTime.parse(dateTimeToken, TASK_DATE_TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println(" Введены неправельные дата и время. Повторите ввод");
            }
        }
    }

    public static RepeatType readTaskRepeatType(Scanner scanner) {
        System.out.println("Повторяемость задачи\n1. Разовая \n2. Ежедневная \n3. Еженедельная \n4. Ежемесячная \n5. Ежегодная");
        while (true) {
            try {
                System.out.println("Введите тип повторяемости задачи:");
                int taskRepeatTypeSelector = scanner.nextInt();
                switch (taskRepeatTypeSelector) {
                    case 1:
                        return RepeatType.SINGLE;
                    case 2:
                        return RepeatType.DAILY;
                    case 3:
                        return RepeatType.WEEKLY;
                    case 4:
                        return RepeatType.MONTHLY;
                    case 5:
                        return RepeatType.ANNUAL;
                    default:
                        System.out.println("Введен неправильный тип повторяемости задачи");
                }
            } catch (Exception e) {
                System.out.println("Введен неправильный тип повторяемости задачи");
            }
        }
    }

    public static String readString(String message, Scanner scanner) {
        while (true) {
            try {
                System.out.println(message);
                String string = scanner.nextLine();
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Необходимо заполнить поле");
            }
        }


    }
    }












