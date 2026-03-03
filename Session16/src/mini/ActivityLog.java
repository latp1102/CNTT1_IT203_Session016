package mini;

import java.time.LocalDateTime;

public class ActivityLog {
    private String action;
    private LocalDateTime time;
    public ActivityLog(String action) {
        this.action = action;
        this.time = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "[" + time + "] " + action;
    }
}
