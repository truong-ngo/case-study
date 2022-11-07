package manager;

import io_file.IOFile;
import shop_item.ChatSession;

import java.util.List;

public class UserChatManager {
    private final List<ChatSession> chatSessionList;
    private final String path = "src/file/user-chat-session-list";
    private final IOFile<ChatSession> ioFile;

    public UserChatManager() {
        ioFile = new IOFile<>();
        chatSessionList = ioFile.readFile(path);
    }
}
