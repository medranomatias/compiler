package message;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Message Handler</h1>
 *
 * <p>A helper class to which message producer classes delegate the task of maintaining and notifying listener</p>
 */
public class MessageHandler {
    /**
     * message
     */
    private Message message;
    /**
     * listener list
     */
    private List<MessageListener> listeners;

    public MessageHandler() {
        listeners = new ArrayList<MessageListener>();
    }

    /**
     * Add a listener to the listener list.
     * @param listener the listener to add
     */
    public void addListener(MessageListener listener) {
        listeners.add(listener);
    }

    /**
     * Remove a listener from the listener list
     * @param listener the listener to remove
     */
    public void removeListener(MessageListener listener) {
        listeners.remove(listener);
    }

    /**
     * Notify listeners after setting the message.
     * @param message the message to set.
     */
    public void sendMessage(Message message) {
        this.message = message;
        notifyListeners();
    }

    /**
     * Notify each listener in the listener list by calling the listener's messageReceived() method
     */
    private void notifyListeners(){
        for(MessageListener listener : listeners){
            listener.messageReceived(message);
        }
    }
}
