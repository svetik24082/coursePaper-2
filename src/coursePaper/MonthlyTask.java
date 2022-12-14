package coursePaper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Tasks{  // ежемесячное задание
    public MonthlyTask(String name, String description, TaskType type, LocalDateTime date, RepeatType repeatType) {
        super(name, description, type, date, repeatType);
    }
    public boolean appearsIn(LocalDate localDate) {
        return  this.date.toLocalDate().equals(localDate) ||
                this.date.toLocalDate().isBefore(localDate) &&
                        this.date.toLocalDate().getDayOfMonth()
                                == localDate.getDayOfMonth();
    }
}

