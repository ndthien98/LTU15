public enum Quantifier {
    A,
    E,
    P,
    B,
    T,
    D,
    K,
    G,
    I,
    O;

    public String text(String S, String P) {
        switch (this) {
            case A:
                return "All " + S + " are " + P;
            case E:
                return "No " + S + " are " + P;
            case P:
                return "Almost all " + S + " are " + P;
            case B:
                return "Almost all " + S + " are not " + P;
            case T:
                return "Most " + S + " are " + P;
            case D:
                return "Most " + S + " are not " + P;
            case K:
                return "Many " + S + " are " + P;
            case G:
                return "Many " + S + " are not " + P;
            case I:
                return "Some " + S + " are " + P;
            case O:
                return "Some " + S + " are not " + P;
            default:
                return "invalid quantifier type!";
        }
    }
}
