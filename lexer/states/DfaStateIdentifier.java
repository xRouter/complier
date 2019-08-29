package lexer.states;

import lexer.DfaStateEnum;
import lexer.LexerContext;
import lexer.Token;
import lexer.TokenTypeEnum;

public class DfaStateIdentifier extends DfaState {

    public DfaStateIdentifier(LexerContext context) {
        super(context);
    }

    public void accept(char ch){
        if(Token.isAlpha(ch) || Token.isDigit(ch)){
            context.getCurToken().setTokenType(TokenTypeEnum.Identifier);
            context.getCurToken().append(ch);
            return;
        }
        context.toState(DfaStateEnum.Initial).newToken().accept(ch);
    }
}
