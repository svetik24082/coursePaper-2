package coursePaper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {  // ежемесячное задание
    public MonthlyTask(String name, String description,
                       TaskType type, LocalDateTime date,
                       RepeatType repeatType) {
        super(name, description, type, date, repeatType);
    }

    public boolean appearsIn(LocalDate localDate) {
        var date = this.date.toLocalDate();
        return date.equals(localDate) || date.isBefore(localDate)
                && date.getDayOfMonth() == localDate.getDayOfMonth();
    }
}

