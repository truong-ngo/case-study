package manager;

import io_file.IOFile;
import shop_item.ChatSession;
import shop_item.User;

import java.util.List;

public class ChatManager {
    private static ChatManager instance;
    public List<ChatSession> chatSessionList;
    private final String path = "src/file/chat_sessions";
    private final IOFile<ChatSession> ioFile;

    private ChatManager() {
        ioFile = new IOFile<>();
        chatSessionList = ioFile.readFile(path);
    }

    public static ChatManager getInstance() {
        if (instance == null) {
            instance = new ChatManager();
        }
        return instance;
    }

    public void add(ChatSession chatSession) {
        chatSessionList.add(chatSession);
        saveSessionList();
    }

    public void saveSessionList() {
        ioFile.writeToFile(chatSessionList, path);
    }

    public void readSessionList() {
        chatSessionList = ioFile.readFile(path);
    }

    public ChatSession getSessionByUsers(User userOne, User userTwo) {
        for (ChatSession chatSession : chatSessionList) {
            boolean conditionOne = chatSession.getUserOne().getUserName().equals(userOne.getUserName()) &&
                                   chatSession.getUserTwo().getUserName().equals(userTwo.getUserName());
            boolean conditionTwo = chatSession.getUserOne().getUserName().equals(userOne.getUserName()) &&
                                   chatSession.getUserOne().getUserName().equals(userTwo.getUserName());
            if (conditionOne || conditionTwo) {
                return chatSession;
            }
        }
        return null;
    }
}
