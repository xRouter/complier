package com.iqianjin.sms.utils.lexer.states;

import com.iqianjin.sms.utils.lexer.DfaStateEnum;
import com.iqianjin.sms.utils.lexer.LexerContext;
import com.iqianjin.sms.utils.lexer.Token;
import com.iqianjin.sms.utils.lexer.TokenTypeEnum;

public class DfaStateIntLiteral extends DfaState {

    public DfaStateIntLiteral(LexerContext context) {
        super(context);
    }

    public void accept(char ch){
        if(Token.isDigit(ch)){
            context.getCurToken().setTokenType(TokenTypeEnum.IntLiteral);
            context.getCurToken().append(ch);
            return;
        }
        context.toState(DfaStateEnum.Initial).newToken().accept(ch);
    }
}
