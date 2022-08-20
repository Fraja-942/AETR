package aetr.validate;

public enum Time {
    DAY, DAY_REGULAR, DAY_REDUCED, DAY_PART, WEEK, WEEK_REGULAR, WEEK_REDUCED;
    public long val() {
        long l = 60 * 60 * 1000;
        switch(this) {
            case DAY: return l * 24;
            case DAY_REGULAR: return l * 11;
            case DAY_REDUCED: return l * 9;
            case DAY_PART: return l * 3;
            case WEEK: return l * 7 * 24;
            case WEEK_REGULAR: return l * 45;
            case WEEK_REDUCED: return l * 24;
        }
        return 0;
    }
}
