package shop_item;

import java.time.LocalDateTime;
import java.util.List;

public class AdminChartSession {
    private User admin;
    private List<ChatSession> chatSessions;
    private AdminChatBox inbox;
    private AdminChatBox outbox;

    public class AdminChatBox {
        private User userSent;
        private String message;
        private LocalDateTime time;
    }
}
