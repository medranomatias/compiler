package message;

/**
 * Created by medranomatias on 11/10/2016.
 */
public enum MessageType {
    SOURCE_LINE,
    SYNTAX_ERROR,
    PARSER_SUMMARY,
    INTERPRETER_SUMMARY,
    COMPILER_SUMMARY,
    MISCELLANEOUS,
    TOKEN,
    ASSIGN,
    FETCH,
    BREAKPOINT,
    RUNTIME_ERROR
}
