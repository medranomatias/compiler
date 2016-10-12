package frontend;

/**
 * Created by medranomatias on 11/10/2016.
 */
public class EofToken extends Token{
    /**
     * Constructor
     *
     * @param source the source from where to fetch the token's characters
     */
    public EofToken(Source source) throws Exception {
        super(source);
    }

    @Override
    protected void extract() throws Exception {

    }
}
