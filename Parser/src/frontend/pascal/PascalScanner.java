package frontend.pascal;

import frontend.EofToken;
import frontend.Scanner;
import frontend.Source;
import frontend.Token;

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
        Token token;
        char currentChar = currentChar();

        if(currentChar == Source.EOF){
            token = new EofToken(source);
        } else {
            token = new Token(source);
        }
        return token;
    }
}
