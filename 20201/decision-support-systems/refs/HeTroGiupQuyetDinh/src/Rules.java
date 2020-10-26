class Rules {
    public interface Rule {
        boolean check(Syllogism syllogism);
    }

    static class RulesOfDistribution {
        public static class R1 implements Rule {
            @Override
            public boolean check(Syllogism syllogism) {
                int DIs = syllogism.getFirstPremiseMiddleFormulaDistributionIndices() +
                        syllogism.getSecondPremiseMiddleFormulaDistributionIndices();
                return DIs > 5;
            }
        }

        public static class R2 implements Rule {
            @Override
            public boolean check(Syllogism syllogism) {
                if (syllogism.getPremiseSubjectDistributionIndices() < syllogism.conclusion.DISubject) {
                    return false;
                }
                return syllogism.getPremisePredicateDistributionIndices() >= syllogism.conclusion.DIPredicate;
            }
        }
    }

    static class RulesOfQuality {
        public static class R3 implements Rule {
            @Override
            public boolean check(Syllogism syllogism) {
                return syllogism.firstPremise.quality == Quality.Affirmative || syllogism.secondPremise.quality == Quality.Affirmative;
            }
        }

        public static class R4 implements Rule {
            @Override
            public boolean check(Syllogism syllogism) {
                int count = 0;
                if(syllogism.conclusion.quality == Quality.Negative) count++;
                if(syllogism.firstPremise.quality == Quality.Negative) count++;
                if(syllogism.secondPremise.quality == Quality.Negative) count++;
                return count != 1;
            }
        }
    }

    static class RulesOfQuantity {
        public static class R5 implements Rule {
            @Override
            public boolean check(Syllogism syllogism) {
                return true;
            }
        }

        public static class R6 implements Rule {
            @Override
            public boolean check(Syllogism syllogism) {
                return true;
            }
        }
    }
}
