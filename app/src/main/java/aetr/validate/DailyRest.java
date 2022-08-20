package aetr.validate;

public class DailyRest implements Rest {
    private long t0, t1, dt, prev_t1;

    public DailyRest(long t0, long t1, long dt, long prev_t1){
        this.t0 = t0;
        this.t1 = t1;
        this.dt = dt;
        this.prev_t1 = prev_t1;
    }

    @Override
    public boolean getRegular() {
        return (t1 - t0 - dt >= Time.DAY_REGULAR.val());
    }

    @Override
    public void validate() {
        if(t1 - t0 - dt >= Time.DAY.val()){
            throw new DailyRestException("Article 1 (o) i, (p) ii", new RuntimeException());
        }
        if(prev_t1 > 0  && t0 - prev_t1 > Time.DAY.val() - Time.DAY_REDUCED.val()){
            throw new DailyRestException("Article 8 (2)", new RuntimeException());
        }
        if(dt > Time.DAY.val() - Time.DAY_REGULAR.val()){
            throw new DailyRestException("Article 1 (o) i", new RuntimeException());
        }
    }
}
