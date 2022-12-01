package game.bombParty.Class;

public class Time {

    private int time;

    private int ss, th, hd, cpt;

    public Time() {
        this.reset();
    }

    private void reset() {
        this.ss = 0;
        this.th = 0;
        this.hd = 0;
        this.cpt = this.time * 100;

    }

    public void update() {
        --this.cpt;
        this.ss = this.cpt % 10;
        this.th = (this.cpt / 10) % 10;
        this.hd = (this.cpt / 100) % 10;
    }

    public String getTime() {
        return String.format("%02d:%d%d", this.ss, this.th, this.hd);
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isFinished() {
        return this.cpt == 0;
    }
}
