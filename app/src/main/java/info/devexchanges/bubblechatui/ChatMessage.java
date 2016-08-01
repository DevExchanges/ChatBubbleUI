package info.devexchanges.bubblechatui;

public class ChatMessage {

    private boolean isMine;
    private String message;

    public ChatMessage(String message, boolean isMine) {
        this.isMine = isMine;
        this.message = message;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
