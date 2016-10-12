package backend.compiler;


import backend.Backend;
import intermediate.ICode;
import intermediate.SymTab;
import message.Message;
import message.MessageType;

/**
 * <h1>CodeGenerator</h1>
 *
 * <p>The code generator for a compiler back end.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class CodeGenerator extends Backend
{
    /**
     * Process the intermediate code and the symbol table generated by the
     * parser to generate machine-language instructions.
     * @param iCode the intermediate code.
     * @param symTab the symbol table.
     * @throws Exception if an error occurred.
     */
    public void process(ICode iCode, SymTab symTab)
        throws Exception
    {
        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime)/1000f;
        int instructionCount = 0;

        // Send the compiler summary message.
        sendMessage(new Message(MessageType.COMPILER_SUMMARY,
                                new Number[] {instructionCount,
                                              elapsedTime}));
    }
}
