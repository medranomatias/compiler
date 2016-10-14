package frontend.pascal.tokens;

import frontend.Source;
import frontend.pascal.PascalErrorCode;

import static frontend.pascal.PascalTokenType.ERROR;

/**
 * Created by medranomatias on 13/10/2016.
 */
public class PascalErrorToken extends PascalToken{
    /**
     * Constructor.
     *
     * @param source the source from where to fetch the token's characters.
     * @throws Exception if an error occurred.
     */
    public PascalErrorToken(Source source, PascalErrorCode errorCode, String tokenText) throws Exception {
        super(source);
        this.text = tokenText;
        this.type = ERROR;
        this.value = errorCode;
    }

    @Override
    protected void extract() throws Exception {

    }
}
