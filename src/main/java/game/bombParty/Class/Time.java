package game.bombParty.Class;

public class Time {

    public int time;
    private int seconde;

    public Time() {

    }

    public Time(int time) {
        this.setTime(time);
    }

    public void update() {
        --this.seconde;
    }

    public void reset() {
        this.seconde = this.time;
    }

    public String getTime() {
        return String.valueOf(this.seconde);
    }

    public void setTime(int time) {
        this.time = time;
        this.reset();
    }

    public boolean isFinished() {
        return this.seconde == 0;
    }
}
