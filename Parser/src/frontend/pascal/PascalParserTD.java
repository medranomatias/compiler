package frontend.pascal;

import frontend.EofToken;
import frontend.Parser;
import frontend.Scanner;
import frontend.Token;
import message.Message;
import message.MessageType;

/**
 * Created by medranomatias on 12/10/2016.
 */
public class PascalParserTD extends Parser {

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

        }
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000F;
        sendMessage(new Message(MessageType.PARSER_SUMMARY, new Object[]{token.getLineNumber(), getErrorCount(), elapsedTime}));
    }

    @Override
    public int getErrorCount() {
        return 0;
    }
}
