package EstiCalc;

/**
 * Time class encapsulates hours, minutes, and seconds
 */
public class Time {

    private int hour, minute, second, seconds;

    public Time() {
        this(0);
    }

    /**
     * Create a new time class
     *
     * @param seconds
     */
    public Time(int seconds) {
        setSeconds(seconds);
    }

    /**
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * @return the second
     */
    public int getSecond() {
        return second;
    }

    /**
     * @return the seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * @param seconds the seconds to set - only positive integers
     */
    final public void setSeconds(int seconds) {
        this.seconds = seconds > 0 ? seconds : 0;
        hour = seconds / 3600 % 60;
        minute = seconds / 60 % 60;
        second = seconds % 60;
    }
}
