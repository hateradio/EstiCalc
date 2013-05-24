package EstiCalc;

/**
 *
 * An Estimated Time of Arrival (ETA) Calculator for data sizes
 */
public class EstiCalc {

    private Time time = new Time();
    private double size;
    private double modSize;
    private double rate;
    private double modRate;

    /**
     * Outputs a text message
     * @return
     */
    public String message() {
        time.setSeconds((int) Math.round(modSize / modRate));

        if (time.getSeconds() <= 0) {
            return "Nothing to calculate.";
        } else {
            return "It should take about " + String.format("%s %s %s.",
                    plurals(time.getHour(), "hour"),
                    plurals(time.getMinute(), "minute"),
                    plurals(time.getSecond(), "second"));
        }
    }

    /**
     * Sets the rate with a modifier
     * @param rate
     * @param modifier
     * @return EstiCalc
     */
    public EstiCalc setRate(double rate, int modifier) {
        this.rate = rate;
        modRate = rateModifier(modifier);
        return this;
    }

    /**
     * Sets the size with a modifier
     * @param size
     * @param modifier
     * @return EstiCalc
     */
    public EstiCalc setSize(double size, int modifier) {
        this.size = size;
        modSize = sizeModifier(modifier);
        return this;
    }

    /**
     * Receives a modifier from a JComboBox
     * @param type
     * @return
     */
    private double sizeModifier(int type) {
        if (type == 1) {
            return size * 1024;
        }
        if (type == 2) {
            return size * 1024 * 1024;
        }
        return size;
    }

    /**
     * Receives a modifier from a JComboBox
     * @param type
     * @return 
     */
    private double rateModifier(int type) {
        if (type == 0) {
            return rate / 8;
        }
        if (type == 1) {
            return rate / 8 * 1000;
        }
        return rate;
    }

    @Override
    public String toString() {
        return String.format("size: %f, rate: %f, modS: %f, modR: %f",
                size, rate, modSize, modRate);
    }

    /**
     * Returns an integer followed by an S, as a pluralized word
     *
     * @param amount
     * @param word
     * @return word
     */
    private static String plurals(int amount, String word) {
        if (amount > 0) {
            return String.format("%d %s", amount, amount == 1 ? word : word + "s");
        } else {
            return "";
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator.style();
        new Calculator().setVisible(true);
    }
}
