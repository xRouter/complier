package com.iqianjin.sms.utils.lexer.states;

import com.iqianjin.sms.utils.lexer.DfaStateEnum;
import com.iqianjin.sms.utils.lexer.LexerContext;
import com.iqianjin.sms.utils.lexer.TokenTypeEnum;

public class DfaStateMinus extends DfaState {

    public DfaStateMinus(LexerContext context) {
        super(context);
    }

    @Override
    public void accept(char ch) {
        if (ch == '-') {
            context.getCurToken().setTokenType(TokenTypeEnum.Minus);
            context.getCurToken().append(ch);
            context.toState(DfaStateEnum.Initial);
            context.newToken(TokenTypeEnum.Minus);
            return;
        }
        throw new RuntimeException("Not Support!");
    }
}
