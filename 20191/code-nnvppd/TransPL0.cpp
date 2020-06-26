#include <stdio.h>
#include <ctype.h>
#include <cstring>
#include <string>
FILE *f;
using namespace std;

// constant
const int MAX_IDENT_LENGTH = 30;
const int MAX_LIST_KEYWORD_LENGTH = 15;

// definition of struct
typedef enum
{
    NONE = 0, // Error while parse
    IDENT,
    NUMBER,
    BEGIN,
    CALL,
    CONST,
    DO,
    ELSE,
    END,
    FOR,
    IF,
    ODD,
    PROCEDURE,
    PROGRAM,
    THEN,
    TO,
    VAR,
    WHILE,
    PLUS,
    MINUS,
    TIMES,
    SLASH,
    EQU,
    NEQ,
    LSS,
    LEQ,
    GTR,
    GEQ,
    LPARENT,
    RPARENT,
    LBRACK,
    RBRACK,
    PERIOD,
    COMMA,
    SEMICOLON,
    ASSIGN,
    PERCENT
} TokenType;

typedef struct
{
    TokenType type;
    string name;
} Keyword;

// table
Keyword listKeyword[MAX_LIST_KEYWORD_LENGTH] = {
    {
        BEGIN,
        "BEGIN",
    },
    {
        END,
        "END",
    },
    {
        IF,
        "IF",
    },
    {
        THEN,
        "THEN",
    },
    {
        WHILE,
        "WHILE",
    },
    {
        DO,
        "DO",
    },
    {
        CALL,
        "CALL",
    },
    {
        ODD,
        "ODD",
    },
    {
        TO,
        "TO",
    },
    {
        CONST,
        "CONST",
    },
    {
        VAR,
        "VAR",
    },
    {
        PROCEDURE,
        "PROCEDURE",
    },
    {
        PROGRAM,
        "PROGRAM",
    },
    {
        ELSE,
        "ELSE",
    },
    {
        FOR,
        "FOR",
    },
};
char TokenString[40][10] = {
    "NONE",
    "IDENT",
    "NUMBER",
    "BEGIN",
    "CALL",
    "CONST",
    "DO",
    "ELSE",
    "END",
    "FOR",
    "IF",
    "ODD",
    "PROCEDURE",
    "PROGRAM",
    "THEN",
    "TO",
    "VAR",
    "WHILE",
    "PLUS",
    "MINUS",
    "TIMES",
    "SLASH",
    "EQU",
    "NEQ",
    "LSS",
    "LEQ",
    "GTR",
    "GEQ",
    "LPARENT",
    "RPARENT",
    "LBRACK",
    "RBRACK",
    "PERIOD",
    "COMMA",
    "SEMICOLON",
    "ASSIGN",
    "PERCENT",
};

// declare variables
TokenType token;
int Num;
char Id[MAX_IDENT_LENGTH + 1];
char Ch;

TokenType listToken[1000];
int pointer = 0;

// declare function
TokenType checkKeyword();
char getCh();
TokenType getToken();

void Error(int);
void factor();
void term();
void expression();
void condition();
void statement();
void block();
void program();

// functions' body
TokenType checkKeyword()
{
    for (int i = 0; i < MAX_LIST_KEYWORD_LENGTH; i++)
    {
        if (listKeyword[i].name.compare(Id) == 0)
        {
            return listKeyword[i].type;
        }
    }
    return IDENT;
};

char getCh()
{
    char c = fgetc(f);
    // printf("GETCHAR: %c\n", c);
    return toupper(c);
};

TokenType getToken()
{

    while (Ch == ' ' || Ch == '\n' || Ch == '\t')
        Ch = getCh();
    if (isalpha(Ch))
    {
        int l = 0;
        do
        {
            Id[l++] = Ch;
            Ch = getCh();

        } while (isalpha(Ch) || isdigit(Ch));
        Id[l] = '\0';
        return checkKeyword();
    }
    else if (isdigit(Ch))
    {
        Num = 0;
        do
        {
            Num = Num * 10 + (Ch - '0');
            Ch = getCh();
        } while (isdigit(Ch));
        printf("read number: %d\n", Num);
        return NUMBER;
    }
    else if (Ch == ':')
    {
        Ch = getCh();
        if (Ch == '=')
        {
            Ch = getCh();
            return ASSIGN;
        }
        else
            return NONE;
    }
    else if (Ch == '+')
    {
        Ch = getCh();
        return PLUS;
    }
    else if (Ch == '-')
    {
        Ch = getCh();
        return MINUS;
    }
    else if (Ch == '*')
    {
        Ch = getCh();
        return TIMES;
    }
    else if (Ch == '/')
    {
        Ch = getCh();
        return SLASH;
    }
    else if (Ch == '%')
    {
        Ch = getCh();
        return PERCENT;
    }
    else if (Ch == '(')
    {
        Ch = getCh();
        return LPARENT;
    }
    else if (Ch == ')')
    {
        Ch = getCh();
        return RPARENT;
    }
    else if (Ch == '[')
    {
        Ch = getCh();
        return LBRACK;
    }
    else if (Ch == ']')
    {
        Ch = getCh();
        return RBRACK;
    }
    else if (Ch == '.')
    {
        Ch = getCh();
        return PERIOD;
    }
    else if (Ch == ';')
    {
        Ch = getCh();
        return SEMICOLON;
    }
    else if (Ch == ',')
    {
        Ch = getCh();
        return COMMA;
    }
    else if (Ch == '>')
    {
        Ch = getCh();
        if (Ch == '=')
        {
            Ch = getCh();
            return GEQ;
        }
        return GTR;
    }
    else if (Ch == '<')
    {
        Ch = getCh();
        if (Ch == '=')
        {
            Ch = getCh();
            return LEQ;
        }
        else if (Ch == '>')
        {
            Ch = getCh();
            return NEQ;
        }
        return LSS;
    }
    else if (Ch == '=')
    {
        Ch = getCh();
        return EQU;
    }
    else
        return NONE;
};
void Error(int errCode)
{
    switch (errCode)
    {
    case 0:
        printf("No error!\n");
        break;
    default:
        printf("Error code: %d\n", errCode);
        break;
    }
    printf("Tokenstring: %s\n", TokenString[token]);
    token = getToken();
    printf("Tokenstring: %s\n", TokenString[token]);
    for (size_t i = 0; i < 20; i++)
    {
        printf("%c", getCh());
    }

    exit(errCode);
}

void factor()
{
    if (token == IDENT)
    {
        token = getToken();
        if (token == LBRACK)
        {
            token = getToken();
            expression();
            if (token == RBRACK)
            {
                token = getToken();
            }
            else
            {
                printf("Thieu ]\n");
                Error(3);
            }
        }
    }
    else if (token == LPARENT)
    {
        token = getToken();
        expression();
        if (token == RPARENT)
        {
            token = getToken();
        }
        else
        {
            printf("Thieu )\n");
            Error(4);
        }
    }
    else if (token == NUMBER)
    {
        token = getToken();
    }
    else
    {
        printf("Sai cu phap toan hang!\n");
        Error(2);
    }
};
void term()
{
    factor();
    while (token == TIMES || token == SLASH)
    {
        token = getToken();
        factor();
    };
};
void expression()
{
    if (token == PLUS || token == MINUS)
    {
        token = getToken();
    }
    term();
    while (token == PLUS || token == MINUS)
    {
        token = getToken();
        term();
    }
};
void condition()
{
    if (token == ODD)
    {
        token = getToken();
        expression();
    }
    else
    {
        expression();
        if (token == LEQ || token == NEQ || token == EQU || LSS == token || GTR == token || GEQ == token)
        {
            printf("truoc khi lay token %s",TokenString[token]);
            token = getToken();
            
            printf("sau khi lay token %s",TokenString[token]);
            expression();
        }
        else
        {
            printf("Loi dieu kien\n");
            Error(1); // condition error
        }
    }
};
void statement()
{
    switch (token)
    {
    case IDENT:
        token = getToken();
        if (token == LBRACK)
        {
            token = getToken();
            expression();
            if (token == RBRACK)
            {
                token = getToken();
            }
            else
            {
                printf("Thieu ]]\n");
                Error(15);
            }
        }
        if (token == ASSIGN)
        {
            token = getToken();
            expression();
        }
        else
        {
            printf("Thieu :=\n");
            Error(16);
        }
        break;
    case CALL:
        token = getToken();
        if (token == IDENT)
        {
            token = getToken();
            if (token == LPARENT)
            {
                token = getToken();
                expression();
                while (token == COMMA)
                {
                    expression();
                    token = getToken();
                }
                if (token == RPARENT)
                {
                    token = getToken();
                }
                else
                {
                    printf("Thieu dong ngoac ) \n");
                    Error(18);
                }
            }
        }
        else
        {
            printf("Missing identity at call\n");
            Error(17);
        }
        break;
    case BEGIN:
        token = getToken();
        statement();
        while (token == SEMICOLON)
        {
            token = getToken();
            statement();
        }
        if (token == END)
        {
            token = getToken();
        }
        else
        {
            printf("Thieu END\n");
            Error(18);
        }
        break;
    case IF:
        token = getToken();
        condition();
        if (token == THEN)
        {
            token = getToken();
            statement();
            if (token == ELSE)
            {
                token = getToken();
                statement();
            }
        }
        break;
    case WHILE:
        token = getToken();
        condition();
        if (token == DO)
        {
            token = getToken();
            statement();
        }
        else
        {
            printf("Thieu DO-WHILE\n");
            Error(19);
        }
        break;
    case FOR:
        token = getToken();
        if (token == IDENT)
        {
            token = getToken();
            if (token == ASSIGN)
            {
                token = getToken();
                expression();
                if (token == TO)
                {
                    token = getToken();
                    expression();
                    if (token == DO)
                    {
                        token = getToken();
                        statement();
                    }
                    else
                    {
                        printf("thieu DO-for\n");
                        Error(20);
                    }
                }
                else
                {
                    printf("thieu TO-for\n");
                    Error(21);
                }
            }
            else
            {
                printf("thieu :=-for\n");
                Error(22);
            }
        }
        else
        {
            printf("thieu dinh danh o vong for\n");
            Error(23);
        }
        break;

    default:
        break;
    }
};
void block()
{
    while (true)
    {
        switch (token)
        {
        case CONST:
            token = getToken();
            if (token == IDENT)
            {
                token = getToken();
                if (token == EQU)
                {
                    token = getToken();
                    if (token == NUMBER)
                    {
                        token = getToken();
                        while (token == COMMA)
                        {
                            token = getToken();
                            if (token == IDENT)
                            {
                                token = getToken();
                                if (token == EQU)
                                {
                                    token = getToken();
                                    if (token == NUMBER)
                                    {
                                        token = getToken();
                                    }
                                    else
                                    {
                                        printf("Thieu number\n");
                                        Error(44);
                                    }
                                }
                                else
                                {
                                    printf("Thieu =\n");
                                    Error(45);
                                }
                            }
                            else
                            {
                                printf("Thieu identity\n");
                                Error(46);
                            }
                        }
                        if (token == SEMICOLON)
                        {
                            token = getToken();
                        }
                        else
                        {
                            printf("Thieu dau semicolon\n ");
                            Error(50);
                        }
                    }
                    else
                    {
                        printf("Thieu number\n");
                        Error(41);
                    }
                }
                else
                {
                    printf("Thieu =\n");
                    Error(42);
                }
            }
            else
            {
                printf("Thieu identity\n");
                Error(43);
            }
            break;
        case VAR:
            token = getToken();
            if (token == IDENT)
            {
                token = getToken();
                if (token == LBRACK)
                {
                    token = getToken();
                    if (token == NUMBER)
                    {
                        token = getToken();
                        if (token == RBRACK)
                        {
                            token = getToken();
                        }
                        else
                        {
                            printf("Thieu ]\n");
                            Error(36);
                        }
                    }
                    else
                    {
                        printf("Thieu number\n");
                        Error(37);
                    }
                }
                while (token == COMMA)
                {
                    token = getToken();
                    if (token == IDENT)
                    {
                        token = getToken();
                        if (token == LBRACK)
                        {
                            token = getToken();
                            if (token == NUMBER)
                            {
                                token = getToken();
                                if (token == RBRACK)
                                {
                                    token = getToken();
                                }
                                else
                                {
                                    printf("Thieu ]\n");
                                    Error(38);
                                }
                            }
                            else
                            {
                                printf("Thieu number\n");
                                Error(39);
                            }
                        }
                    }
                }
                if (token == SEMICOLON)
                {
                    token = getToken();
                }
                else
                {
                    printf("Thieu cham phay\n");
                    Error(40);
                }
            }
            else
            {
                printf("Thieu identity\n");
                Error(38);
            }
            break;
        case PROCEDURE:
            token = getToken();
            if (token == IDENT)
            {
                token = getToken();
                if (token == LPARENT)
                {
                    token = getToken();
                    if (token == VAR)
                        token = getToken();
                    else if (token == IDENT)
                        token = getToken();
                    else
                    {
                        printf("Thieu identity hoac var\n");
                        Error(32);
                    }
                    while (token == SEMICOLON)
                    {
                        token = getToken();
                        if (token == VAR)
                            token = getToken();
                        else if (token == IDENT)
                            token = getToken();
                        else
                        {
                            printf("Thieu identity\n");
                            Error(32);
                        }
                    }
                    if (token == RPARENT)
                    {
                        token = getToken();
                    }
                    else
                    {
                        printf("Thieu dong ngoac\n");
                        Error(33);
                    }
                }
            }
            else
            {
                printf("Missing identity\n");
                Error(30);
            }
            if (token == SEMICOLON)
            {
                token = getToken();
                block();
                if (token == SEMICOLON)
                {
                    token = getToken();
                }
                else
                {
                    printf("thieu cham phay\n");
                    Error(34);
                }
            }
            else
            {
                printf("thieu cham phay\n");
                Error(35);
            }
            break;
        case BEGIN:
            token = getToken();
            statement();
            while (token == SEMICOLON)
            {
                token = getToken();
                statement();
            }
            if (token == END)
            {
                token = getToken();
                return;
            }
            else
            {
                printf("Thieu END\n");
                Error(26);
            }
            break;
        default:
            printf("loi block");
            Error(27);
            break;
        }
    }
}
void program()
{
    if (token == PROGRAM)
    {
        token = getToken();
        if (token = IDENT)
        {
            token = getToken();
            if (token == SEMICOLON)
            {
                token = getToken();
                block();
                if (token == PERIOD)
                {
                    printf("Successfully\n");
                }
                else
                {
                    printf("Thieu dau PERIOD\n");
                    Error(6);
                }
            }
            else
            {
                printf("Thieu ;\n");
                Error(7);
            }
        }
        else
        {
            printf("Thieu ten chuong trinh\n");
            Error(8);
        }
    }
    else
    {
        printf("PROGRAM keyword missing\n");
        Error(9);
    }
};

int main()
{
    f = fopen("MyProgram.plz", "rt");
    Ch = ' ';
    token = getToken();
    program();
    fclose(f);
}