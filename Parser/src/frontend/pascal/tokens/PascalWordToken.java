package frontend.pascal.tokens;

import frontend.Source;
import frontend.pascal.PascalTokenType;

/**
 * Created by medranomatias on 14/10/2016.
 */
public class PascalWordToken  extends PascalToken{
    /**
     * Constructor.
     *
     * @param source the source from where to fetch the token's characters.
     * @throws Exception if an error occurred.
     */
    public PascalWordToken(Source source) throws Exception {
        super(source);
    }

    @Override
    protected void extract() throws Exception {
        StringBuilder buffer = new StringBuilder();
        char currentChar = currentChar();

        while(Character.isLetterOrDigit(currentChar)){
            buffer.append(currentChar);
            currentChar = nextChar();
        }

        text = buffer.toString();
        type = PascalTokenType.RESERVED_WORDS.contains(text.toLowerCase()) ? PascalTokenType.valueOf(text.toUpperCase()) : PascalTokenType.IDENTIFIER;
    }
}
