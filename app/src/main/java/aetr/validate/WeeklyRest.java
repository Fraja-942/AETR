package aetr.validate;

public class WeeklyRest implements Rest {
    private long t0, t1, w0, w1, prev_t0, prev_t1;

    public WeeklyRest(long t0, long t1, long w0, long w1, long prev_t0, long prev_t1){
        this.t0 = t0;
        this.t1 = t1;
        this.w0 = w0;
        this.w1 = w1;
        this.prev_t0 = prev_t0;
        this.prev_t1 = prev_t1;
    }
    @Override
    public boolean getRegular() {
        return (t1 - t0 >= Time.WEEKregular.val());
    }

    @Override
    public void validate() {
        if(prev_t0 > 0 && prev_t1 >0) {
            if (t0 - prev_t1 > 6 * Time.DAY.val()) {
                throw new WeeklyRestException("Article 8 (6. a.)", new RuntimeException());
            }
            if (t1 > w1) {
                if (prev_t0 < w0 && prev_t1 - prev_t0 + w1 - t0 < Time.WEEKregular.val() + Time.WEEKreduced.val()) {
                    throw new WeeklyRestException("Article 8 (6. a. ii)", new RuntimeException());
                }
                if (prev_t0 < w0 - Time.WEEK.val()) {
                    throw new WeeklyRestException("Article 8 (6. a. ii)", new RuntimeException());
                }
            }
        }
    }

}
