package frontend;

import intermediate.ICode;
import intermediate.SymTab;
import message.Message;
import message.MessageHandler;
import message.MessageListener;
import message.MessageProducer;

/**
 * <h1>Parser</h1>
 *
 * <p>A language-independent framework class. This abstract parser class will be implemented by languague-specific
 * subclasses</p>
 */
public abstract class Parser implements MessageProducer{
    /**
     * Generated symbol table
     */
    protected static SymTab symTab;
    /**
     * message handler delegate
     */
    protected static MessageHandler messageHandler;

    static {
        symTab = null;
        messageHandler = new MessageHandler();
    }

    /**
     * Scanner used with this parser
     */
    protected Scanner scanner;
    /**
     * intermediate code generated by this parser
     */
    protected ICode iCode;

    /**
     * Constructor
     * @param scanner the scanner to be used with this parser
     */
    protected Parser(Scanner scanner) {
        this.scanner = scanner;
        this.iCode = null;
    }

    public SymTab getSymTab() {
        return symTab;
    }

    /**
     * Parse a source program and generate the intermediate code and the symbol table. To be implemented by a
     * language-specific parser subclass
     * @throws Exception if an error occurred
     */
    public abstract void parse() throws Exception;

    /**
     * Return the number of syntax errors found by te parser. To be implemented by a language-specific parser subclass.
     * @return the error count.
     */
    public abstract int getErrorCount();

    /**
     * Call the scanner's currentToken() method.
     * @return the current token.
     */
    public Token currentToken(){
        return scanner.currentToken();
    }

    /**
     * Call the scanner's nextToken() method.
     * @return the next token
     * @throws Exception if an error ocurred.
     */
    public Token nextToken() throws Exception{
        return scanner.nextToken();
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

    public ICode getICode() {
        return iCode;
    }
}
