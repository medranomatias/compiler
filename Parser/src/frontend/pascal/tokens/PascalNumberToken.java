package frontend.pascal.tokens;

import frontend.Source;

/**
 * Created by medranomatias on 14/10/2016.
 */
public class PascalNumberToken extends PascalToken {
    /**
     * Constructor.
     *
     * @param source the source from where to fetch the token's characters.
     * @throws Exception if an error occurred.
     */
    public PascalNumberToken(Source source) throws Exception {
        super(source);
    }
}
