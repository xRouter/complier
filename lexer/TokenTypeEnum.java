package com.iqianjin.sms.utils.lexer;

/**
 * Token的类型
 */
public enum TokenTypeEnum {
    Plus,   // +
    Minus,  // -
    Star,   // *
    Slash,  // /

    GE,     // >=
    GT,     // >
    EQ,     // ==
    LE,     // <=
    LT,     // <

    SemiColon, // ;
    LeftParen, // (
    RightParen,// )

    Assignment,// =

    KeywordIf,
    KeywordElse,
    KeywordInt,

    Identifier,     //标识符

    IntLiteral,     //整型字面量
    StringLiteral   //字符串字面量
}
