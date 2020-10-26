public enum  Figure {
    Figure1,
    Figure2,
    Figure3,
    Figure4;

    @Override
    public String toString() {
        switch (this) {
            case Figure1:
                return "I";
            case Figure2:
                return "II";
            case Figure3:
                return "III";
            case Figure4:
                return "IV";
            default:
                return "";
        }
    };
}
