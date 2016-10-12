package message;

/**
 * <h1>Message</h1>
 *
 * <p>Message format</p>
 */
public class Message {
    /**
     *
     */
    private Object body;
    /**
     *
     */
    private MessageType type;

    /**
     * Constructor
     * @param type the message body
     * @param body the message type
     */
    public Message(MessageType type, Object body) {
        this.body = body;
        this.type = type;
    }
}
