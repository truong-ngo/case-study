package shop_item;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class ChatSession implements Serializable {
    private static final long serialVersionUID = 42L;
    private User chatID;
    String messageType;
    private List<ChatBox> notification;
    private List<ChatBox> inbox;
    private List<ChatBox> outbox;

    public class ChatBox {
        private String messageSent;
        private LocalDateTime time;
    }
}
