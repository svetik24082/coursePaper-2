package coursePaper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SingleTask extends Task {  // однократная задача
    public SingleTask(String name, String description,
                      TaskType type, LocalDateTime date,
                      RepeatType repeatType) {
        super(name, description, type, date, repeatType);
    }

    @Override
    public boolean appearsIn(LocalDate localdate) {
        return this.date.toLocalDate().equals(localdate);
    }
}
