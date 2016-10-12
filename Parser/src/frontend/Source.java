package frontend;

import message.*;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * <h1>Source</h1>
 *
 * <p>The framework class that represents the source program.</p>
 */
public class Source implements MessageProducer{
    /**
     * End-of-Line character
     */
    public static final char EOL = '\n';
    /**
     * End-of-File character
     */
    public static final char EOF = (char) 0;
    /**
     * Reader for the source program
     */
    private BufferedReader reader;
    /**
     * Source line
     */
    private String line;
    /**
     * current source line number
     */
    private int lineNum;
    /**
     * Current source line position
     */
    private int currentPos;
    /**
     * message handler delegate
     */
    protected static MessageHandler messageHandler;

    static {
        messageHandler = new MessageHandler();
    }

    /**
     * Constructor
     * @param reader the reader for the source program
     * @throws IOException if an I/O error occurred.
     */
    public Source(BufferedReader reader) throws IOException{
        this.lineNum = 0;
        this.currentPos = -2;
        this.reader = reader;
    }

    /**
     * Return the source character at the current position
     * @return the source character at the current position
     * @throws Exception if and error occurred.
     */
    public char currentChar() throws Exception{
        // First Time?
        if(currentPos == -2){
            readLine();
            return nextChar();
            // At end of File?
        } else if (line == null){
            return EOF;
            // At end of line?
        } else if(currentPos == -1 || currentPos == line.length()){
            return EOL;
            // Need to read the next line?
        } else if(currentPos > line.length()){
            readLine();
            return nextChar();
            // Return the character at the current position
        } else {
            return line.charAt(currentPos);
        }
    }

    /**
     * Consume the current source character and return the next character.
     * @return the next source character
     * @throws Exception if an error occurred.
     */
    public char nextChar() throws Exception{
        ++ currentPos;
        return currentChar();
    }

    /**
     * Return the source program following the current character without consuming the current character.
     * @return the following character
     * @throws Exception if an error occurred.
     */
    public char peekChar() throws Exception{
        currentChar();
        if(line == null){
            return EOF;
        }
        int nextPos = currentPos + 1;
        return nextPos < line.length() ? line.charAt(nextPos) : EOL;
    }

    private void readLine() throws Exception{
        line = reader.readLine();
        currentPos = -1;
        if(line != null){
            ++ lineNum;
        }
        if(line != null){
            messageHandler.sendMessage(new Message(MessageType.SOURCE_LINE, new Object[]{lineNum, line}));
        }
    }

    /**
     * Close the source
     * @throws Exception if an error occurred.
     */
    public void close() throws Exception {
        if(reader != null){
            try{
                reader.close();
            } catch (Exception e){
                e.printStackTrace();
                throw e;
            }
        }
    }

    public int getLineNum() {
        return lineNum;
    }

    public int getPosition() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    @Override
    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    @Override
    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    @Override
    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}
