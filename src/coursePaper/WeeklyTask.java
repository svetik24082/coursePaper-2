package coursePaper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {  // еженеделььное задание
    public WeeklyTask(String name, String description, TaskType type,
                      LocalDateTime date, RepeatType repeatType) {
        super(name, description, type, date, repeatType);
    }

    public boolean appearsIn(LocalDate localDate) {
        var date = this.date.toLocalDate();
        return date.equals(localDate) ||
                date.isBefore(localDate) &&
                        date.getDayOfWeek().equals(localDate.getDayOfWeek());
    }
}
