package coursePaper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ServiceTask <T extends Tasks> {
    Map<Integer, Tasks> tasks = new HashMap<>();


    public void addTask(Tasks task) {
        tasks.put(task.getId(), task);
    }

    public void printTasks() {
        System.out.println(tasks);
    }

    public void removeTask(String taskName) {
        for (Tasks value : tasks.values()) {
            int i = 0;
            if (value.getName().equals(taskName)) {
                i = value.getId();
            }
            tasks.remove(i);
        }
    }

    public Collection<Tasks> getTasksForDay(LocalDate localDate) {
        List<Tasks> tasksForDay = new ArrayList<>();
        for (Tasks task : tasks.values()) {
            if (task.appearsIn(localDate)) {
                tasksForDay.add(task);
            }
        }
        return tasksForDay;
    }



    }

