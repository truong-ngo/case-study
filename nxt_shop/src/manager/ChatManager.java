package manager;

import input.Input;
import io_file.IOFile;
import printer.Printer;
import shop_item.ChatSession;
import shop_item.Messenger;
import shop_item.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ChatManager {
    private static ChatManager instance;
    public List<ChatSession> chatSessionList;
    private final String path = "C:\\Learning\\Case-study\\file\\chats";
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
            boolean conditionOne = chatSession.getUserOne().getUsername().equals(userOne.getUsername()) &&
                                   chatSession.getUserTwo().getUsername().equals(userTwo.getUsername());
            boolean conditionTwo = chatSession.getUserOne().getUsername().equals(userOne.getUsername()) &&
                                   chatSession.getUserOne().getUsername().equals(userTwo.getUsername());
            if (conditionOne || conditionTwo) {
                return chatSession;
            }
        }
        return null;
    }

    public void runChatSession(Scanner scanner, Printer printer, Input input, User userOne, User userTwo, ChatSession chatSession) {
        printer.chat.enterMessage();
        String message = scanner.nextLine();
        String notifyMess = input.bill.notificationFromUser(userOne);
        if (!message.equals("")) {
            LocalDateTime time = LocalDateTime.now();
            message = userOne.getUsername() + ": " + message;
            Messenger messenger = new Messenger(message, time);
            chatSession.addMessenger(messenger);
            Messenger notify = new Messenger(notifyMess, time);
            userTwo.getNotification().add(notify);
            printer.success.actionSuccessfully("Sent message");
        } else {
            printer.error.actionFailed("Sent message");
        }
    }
}
