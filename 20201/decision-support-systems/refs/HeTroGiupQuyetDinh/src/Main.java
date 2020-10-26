import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // khoi tao rule
        Rules.RulesOfDistribution.R1 rule1 = new Rules.RulesOfDistribution.R1();
        Rules.RulesOfDistribution.R2 rule2 = new Rules.RulesOfDistribution.R2();
        Rules.RulesOfQuality.R3 rule3 = new Rules.RulesOfQuality.R3();
        Rules.RulesOfQuality.R4 rule4 = new Rules.RulesOfQuality.R4();
        Rules.RulesOfQuantity.R5 rule5 = new Rules.RulesOfQuantity.R5();
        Rules.RulesOfQuantity.R6 rule6 = new Rules.RulesOfQuantity.R6();
        // khoi tao figure
        ArrayList<Figure> figures = new ArrayList<>();
        figures.add(Figure.Figure1);
        figures.add(Figure.Figure2);
        figures.add(Figure.Figure3);
        figures.add(Figure.Figure4);
        // khoi tao 12 menh de co ban
        ArrayList<SyllogismClause> syllogismClauses = new ArrayList<>();
        syllogismClauses.add(new SyllogismClause(Quantifier.A, Quantity.Universal, Quality.Affirmative, DI.DI5, DI.DI1));
        syllogismClauses.add(new SyllogismClause(Quantifier.E, Quantity.Universal, Quality.Negative, DI.DI5, DI.DI5));
        syllogismClauses.add(new SyllogismClause(Quantifier.P, Quantity.Predominant, Quality.Affirmative, DI.DI4, DI.DI1));
        syllogismClauses.add(new SyllogismClause(Quantifier.B, Quantity.Predominant, Quality.Negative, DI.DI4, DI.DI5));
        syllogismClauses.add(new SyllogismClause(Quantifier.T, Quantity.Majority, Quality.Affirmative, DI.DI3, DI.DI1));
        syllogismClauses.add(new SyllogismClause(Quantifier.D, Quantity.Majority, Quality.Negative, DI.DI3, DI.DI5));
        syllogismClauses.add(new SyllogismClause(Quantifier.K, Quantity.Common, Quality.Affirmative, DI.DI2, DI.DI1));
        syllogismClauses.add(new SyllogismClause(Quantifier.G, Quantity.Common, Quality.Negative, DI.DI2, DI.DI5));
        syllogismClauses.add(new SyllogismClause(Quantifier.I, Quantity.Particular, Quality.Affirmative, DI.DI1, DI.DI1));
        syllogismClauses.add(new SyllogismClause(Quantifier.O, Quantity.Particular, Quality.Negative, DI.DI1, DI.DI5));
        // khoi tao tap du lieu tam doan luan co so
        // 4000 possible generalized syllogisms
        ArrayList<Syllogism> syllogisms = new ArrayList<>();
        ArrayList<Syllogism> correctSyllogisms = new ArrayList<>();
        for(SyllogismClause firstPremise : syllogismClauses) {
            for(SyllogismClause secondPremise : syllogismClauses) {
                for(SyllogismClause conclusion : syllogismClauses) {
                    for(Figure figure : figures) {
                        Syllogism syllogism = new Syllogism(firstPremise, secondPremise, conclusion, figure);
                        boolean r1 = rule1.check(syllogism);
                        boolean r2 = rule2.check(syllogism);
                        boolean r3 = rule3.check(syllogism);
                        boolean r4 = rule4.check(syllogism);
                        boolean r5 = rule5.check(syllogism);
                        boolean r6 = rule6.check(syllogism);
                        syllogism.set(new boolean[]{r1, r2, r3, r4, r5, r6});
                        syllogisms.add(syllogism);
                        if(r1 && r2 && r3 && r4 && r5 && r6) {
                            correctSyllogisms.add(syllogism);
                        }
                    }
                }
            }
        }
        for(Syllogism syllogism : correctSyllogisms) {
            System.out.println(syllogism);
        }
        System.out.println("Correct syllogisms count: " + correctSyllogisms.size());
    }
}
