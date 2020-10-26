import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;
import java.util.Arrays;

public class Syllogism {
    SyllogismClause firstPremise;
    SyllogismClause secondPremise;
    SyllogismClause conclusion;
    Figure figure;
    boolean[] validation;

    Syllogism(SyllogismClause firstPremise, SyllogismClause secondPremise, SyllogismClause conclusion, Figure figure) {
        this.firstPremise = firstPremise;
        this.secondPremise = secondPremise;
        this.conclusion = conclusion;
        this.figure = figure;
    }

    void set(boolean[] validation) {
        if (validation == null || validation.length != 6) {
            throw new IllegalArgumentException("invalid validation");
        }
        this.validation = validation;
    }

    boolean valid() {
        if (this.validation == null) {
            throw new IndexOutOfBoundsException("invalid validation");
        }
        for (boolean b : this.validation) {
            if (!b) return false;
        }
        return true;
    }

    int getFirstPremiseMiddleFormulaDistributionIndices() {
        switch (figure) {
            case Figure1:
            case Figure3:
                return firstPremise.DISubject;
            case Figure2:
            case Figure4:
                return firstPremise.DIPredicate;
            default:
                return Integer.MIN_VALUE;
        }
    }

    int getSecondPremiseMiddleFormulaDistributionIndices() {
        switch (figure) {
            case Figure1:
            case Figure2:
                return secondPremise.DIPredicate;
            case Figure4:
            case Figure3:
                return secondPremise.DISubject;
            default:
                return Integer.MIN_VALUE;
        }
    }

    int getPremiseSubjectDistributionIndices() {
        switch (figure) {
            case Figure1:
            case Figure2:
                return secondPremise.DISubject;
            case Figure3:
            case Figure4:
                return secondPremise.DIPredicate;
            default:
                return Integer.MIN_VALUE;
        }
    }

    int getPremisePredicateDistributionIndices() {
        switch (figure) {
            case Figure1:
            case Figure3:
                return firstPremise.DIPredicate;
            case Figure4:
            case Figure2:
                return firstPremise.DISubject;
            default:
                return Integer.MIN_VALUE;
        }
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            boolean b = validation[i];
            if (b) {
                tmp.append("T");
            } else {
                tmp.append("F");
            }
        }
        return String.format("%s-%-3s : %s", firstPremise.quantifier + "" + secondPremise.quantifier + "" + conclusion.quantifier, figure.toString(), tmp);
    }
}
