package model.members;

public class Visit {

    /**
     * Year of this visit.
     */
    private int year;
    /**
     * Month of this visit.
     */
    private int month;
    /**
     * Day of this visit.
     */
    private int day;

    /**
     * Constructor with parameter.
     * @param year year of the visit
     * @param month month of the visit
     * @param day day of the visit
     */
    public Visit(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        String monthStr = prettyFormat(month);
        String dayStr = prettyFormat(day);
        return monthStr + "/" + dayStr + "/" + year;
    }

    /**
     * Returns a pretty format of the given number.
     * @param n given number
     * @return pretty format of the given number
     */
    private String prettyFormat(int n) {
        if (n < 10) {
            return "0" + String.valueOf(n);
        } else {
            return String.valueOf(n);
        }
    }

}
