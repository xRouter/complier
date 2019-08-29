package lexer.states;

import lexer.DfaStateEnum;
import lexer.LexerContext;
import lexer.TokenTypeEnum;

public class DfaStatePlus extends DfaState {

    public DfaStatePlus(LexerContext context) {
        super(context);
    }

    public void accept(char ch) {
        if (ch == '+') {
            context.getCurToken().setTokenType(TokenTypeEnum.Plus);
            context.getCurToken().append(ch);
            context.toState(DfaStateEnum.Initial).newToken();
            return;
        }
        throw new RuntimeException("not support");
    }
}
