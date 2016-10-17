package frontend.pascal.tokens;

import frontend.Source;

import static frontend.pascal.PascalErrorCode.UNEXPECTED_EOF;
import static frontend.pascal.PascalTokenType.ERROR;
import static frontend.pascal.PascalTokenType.STRING;

/**
 * Created by medranomatias on 14/10/2016.
 */
public class PascalStringToken extends PascalToken {
    /**
     *
     */
    private static char SINGLE_QUOTE = '\'';
    /**
     *
     */
    private static char WHITE_SPACE = ' ';

    /**
     * Constructor.
     *
     * @param source the source from where to fetch the token's characters.
     * @throws Exception if an error occurred.
     */
    public PascalStringToken(Source source) throws Exception {
        super(source);
    }

    @Override
    protected void extract() throws Exception {
        StringBuilder textBuffer = new StringBuilder();
        StringBuilder valueBuffer = new StringBuilder();

        char currentChar = nextChar();
        textBuffer.append(SINGLE_QUOTE);

        do {
            if(Character.isWhitespace(currentChar)){
                textBuffer.append(WHITE_SPACE);
            }
            if(currentChar != SINGLE_QUOTE && currentChar != Source.EOF){
                textBuffer.append(currentChar);
                valueBuffer.append(currentChar);
                currentChar = nextChar();
            }
            if(currentChar == SINGLE_QUOTE){
                while(currentChar == SINGLE_QUOTE && peekChar() == SINGLE_QUOTE){
                    textBuffer.append("''");
                    valueBuffer.append(currentChar);
                    currentChar = nextChar();
                    currentChar = nextChar();
                }
            }
        } while(currentChar != SINGLE_QUOTE && currentChar != Source.EOF);
        if(currentChar == SINGLE_QUOTE){
            nextChar();
            textBuffer.append(SINGLE_QUOTE);

            type = STRING;
            value = valueBuffer.toString();
        } else {
            type = ERROR;
            value = UNEXPECTED_EOF;
        }
    }
}
