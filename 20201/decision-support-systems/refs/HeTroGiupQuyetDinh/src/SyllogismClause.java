public class SyllogismClause {
    Quantifier quantifier;
    Quantity quantity;
    Quality quality;
    int DISubject;
    int DIPredicate;

    public SyllogismClause(Quantifier quantifier, Quantity quantity, Quality quality, int DISubject, int DIPredicate) {
        this.quantifier = quantifier;
        this.quantity = quantity;
        this.quality = quality;
        this.DISubject = DISubject;
        this.DIPredicate = DIPredicate;
    }
}
