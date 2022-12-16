package coursePaper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {  // ежедневная задача
    public DailyTask(String name, String description,
                     TaskType type, LocalDateTime date,
                     RepeatType repeatType) {
        super(name, description, type, date, repeatType);
    }

    public boolean appearsIn(LocalDate localDate) {
        return this.date.toLocalDate().equals(localDate) ||
                this.date.toLocalDate().isBefore(localDate);
    }
}
