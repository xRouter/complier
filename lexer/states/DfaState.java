package com.iqianjin.sms.utils.lexer.states;

import com.iqianjin.sms.utils.lexer.LexerContext;

public abstract class DfaState {

    protected LexerContext context;

    public DfaState(LexerContext context){
        this.context = context;
    }

    /**
     * 要么当前状态接受
     * 要么新建状态&让新状态接受
     * @param ch
     */
    public abstract void accept(char ch);
}
