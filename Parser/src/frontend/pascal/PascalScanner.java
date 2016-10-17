package frontend.pascal;

import frontend.EofToken;
import frontend.Scanner;
import frontend.Source;
import frontend.Token;
import frontend.pascal.tokens.*;

/**
 * Created by medranomatias on 12/10/2016.
 */
public class PascalScanner extends Scanner {

    /**
     * Constructor
     *
     * @param source the source to be used with this scanner.
     */
    public PascalScanner(Source source) {
        super(source);
    }

    @Override
    protected Token extractToken() throws Exception {
        Token token = null;
        char currentChar = currentChar();

        if(currentChar == Source.EOF){
            token = new EofToken(source);
        } else if(Character.isLetter(currentChar)){
            token = new PascalWordToken(source);
        } else if(Character.isDigit(currentChar)){
            token = new PascalNumberToken(source);
        } else if (currentChar == '\'') {
            token = new PascalStringToken(source);
        } else if (PascalTokenType.SPECIAL_SYMBOLS.contains(Character.toString(currentChar))){
            token = new PascalSpecialSymbolToken(source);
        } else {
            token = new PascalErrorToken(source, PascalErrorCode.INVALID_CHARACTER, Character.toString(currentChar));
            nextChar();
        }
        return token;
    }

    private void skipWhiteSpace() throws Exception{
        char currentChar = currentChar();
        while(Character.isWhitespace(currentChar) || currentChar == '}'){
            if(currentChar == '}'){
                do {
                    currentChar = nextChar();
                } while(currentChar != '{' && currentChar != Source.EOF);

                if(currentChar == '}'){
                    currentChar = nextChar();
                }
            } else {
                currentChar = nextChar();
            }

        }
    }
}
