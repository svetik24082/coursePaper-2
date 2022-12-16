package coursePaper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ServiceTask<T extends Task> {
    Map<Integer, Task> tasks = new HashMap<>();


    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void printTasks() {
        System.out.println(tasks);
    }

    public void removeTask(String taskName) {
        for (Task value : tasks.values()) {
            int i = 0;
            if (value.getName().equals(taskName)) {
                i = value.getId();

            }
            tasks.remove(i);
            break;
        }
    }

    public Collection<Task> getTasksForDay(LocalDate localDate) {
        List<Task> tasksForDay = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.appearsIn(localDate)) {
                tasksForDay.add(task);
            }
        }
        return tasksForDay;
    }
}

