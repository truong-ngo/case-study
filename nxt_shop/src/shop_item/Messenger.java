package shop_item;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Messenger implements Serializable {
    private static final long serialVersionUID = 42L;
    private String message;
    private LocalDateTime time;

    public Messenger(String message, LocalDateTime time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
