package lexer.states;

import lexer.DfaStateEnum;
import lexer.LexerContext;
import lexer.Token;
import lexer.TokenTypeEnum;

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
