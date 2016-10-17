package frontend.pascal;

import frontend.*;
import message.Message;
import message.MessageType;

/**
 * Created by medranomatias on 12/10/2016.
 */
public class PascalParserTD extends Parser {
    /**
     *
     */
    protected static PascalErrorHandler errorHandler = new PascalErrorHandler();
    /**
     * Constructor
     *
     * @param scanner the scanner to be used with this parser
     */
    public PascalParserTD(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void parse() throws Exception {
        Token token = null;

        long startTime = System.currentTimeMillis();

        while(!((token = nextToken()) instanceof EofToken)){
            TokenType tokenType = token.getType();
            if(tokenType != PascalTokenType.ERROR){
                sendMessage(new Message(MessageType.TOKEN, new Object[]{
                        token.getLineNumber(),
                        token.getPosition(),
                        tokenType,
                        token.getText(),
                        token.getValue()}));
            } else {
                errorHandler.flag(token, (PascalErrorCode) token.getValue(), this);
            }
        }
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000F;
        sendMessage(new Message(MessageType.PARSER_SUMMARY, new Number[]{token.getLineNumber(), getErrorCount(), elapsedTime}));
    }

    @Override
    public int getErrorCount() {
        return errorHandler.getErrorCount();
    }
}
