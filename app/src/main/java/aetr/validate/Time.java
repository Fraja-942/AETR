package aetr.validate;

public enum Time {
    DAY, DAYregular, DAYreduced, DAYpart, WEEK, WEEKregular, WEEKreduced;
    public long val() {
        long l = 60 * 60 * 1000;
        switch(this) {
            case DAY: return l * 24;
            case DAYregular: return l * 11;
            case DAYreduced: return l * 9;
            case DAYpart: return l * 3;
            case WEEK: return l * 7 * 24;
            case WEEKregular: return l * 45;
            case WEEKreduced: return l * 24;
        }
        return 0;
    }
}
