package lexer.states;

import lexer.DfaStateEnum;
import lexer.LexerContext;
import lexer.TokenTypeEnum;

public class DfaStateGT extends DfaState {

    public DfaStateGT(LexerContext context) {
        super(context);
    }

    public void accept(char ch) {
        if (ch == '>') { //第一个字符是>
            context.getCurToken().setTokenType(TokenTypeEnum.GT);
            context.getCurToken().append(ch);
            return;
        }
        if (ch == '=') {
            context.toState(DfaStateEnum.GE).accept(ch);
            return;
        }
        throw new RuntimeException("not support!");
    }
}
