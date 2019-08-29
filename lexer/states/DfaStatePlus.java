package com.iqianjin.sms.utils.lexer.states;

import com.iqianjin.sms.utils.lexer.DfaStateEnum;
import com.iqianjin.sms.utils.lexer.LexerContext;
import com.iqianjin.sms.utils.lexer.TokenTypeEnum;

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
