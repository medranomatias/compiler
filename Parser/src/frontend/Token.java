package frontend;

/**
 *
 */
public class Token {
    /**
     * language-specific token type
     */
    protected TokenType type;
    /**
     * token text
     */
    protected String text;
    /**
     * token value
     */
    protected Object value;
    /**
     * source
     */
    protected Source source;
    /**
     * line number of the token's source line
     */
    protected int lineNum;
    /**
     * position of the first token character
     */
    protected int position;

    /**
     * Constructor
     * @param source the source from where to fetch the token's characters
     */
    public Token(Source source) throws Exception {
        this.source = source;
        this.lineNum = source.getLineNum();
        this.position = source.getPosition();

        extract();
    }

    /**
     * Default method of extract only one-character tokens form the source. Subclasses can override this method to
     * construct language-specific token. After extracting the token, the current source line position will be one beyond
     * the last token character
     * @throws  Exception if an error occurred.
     */
    protected void extract() throws Exception{
        text = Character.toString(currentChar());
        value = null;
        nextChar();
    }


    /**
     * Call the source's currentChar() method.
     * @return the current character from the source
     * @throws Exception if an error occurred.
     */
    protected char currentChar() throws Exception {
        return source.currentChar();
    }

    /**
     * Call the source's nextChar() method.
     * @return the next character from the source after moving forward
     * @throws Exception if an error occurred
     */
    protected char nextChar() throws Exception {
        return source.nextChar();
    }

    /**
     *
     * @return
     * @throws Exception
     */
    protected char peekChar() throws Exception {
        return source.peekChar();
    }

    /**
     * Getter
     * @return the token type
     */
    public TokenType getType()
    {
        return type;
    }

    /**
     * Getter.
     * @return the token text.
     */
    public String getText()
    {
        return text;
    }

    /**
     * Getter.
     * @return the token value.
     */
    public Object getValue()
    {
        return value;
    }

    /**
     * Getter.
     * @return the source line number.
     */
    public int getLineNumber()
    {
        return lineNum;
    }

    /**
     * Getter.
     * @return the position.
     */
    public int getPosition()
    {
        return position;
    }
}
