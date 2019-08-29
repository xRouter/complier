package com.iqianjin.sms.utils.lexer;

public enum DfaStateEnum {
    //初始状态
    Initial,
    //关键字
    KeywordIf,
    KeywordElse,
    KeywordInt,
    //变量标识
    Identifier,
    //运算符
    GT,
    GE,
    Plus,
    Minus,
    Star,
    Slash,
    //赋值
    Assignment,
    //分隔符
    SemiColon,
    LeftParen,
    RightParen,
    //字面量
    IntLiteral
}
