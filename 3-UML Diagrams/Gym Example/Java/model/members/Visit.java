package model.members;

/**
 * Visit class.
 *
 * @author Ziang Lu
 */
public class Visit {

    /**
     * Year, month and day of this visit.
     */
    private int year, month, day;

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
        return String.format("%d/%2d/%d", month, day, year);
    }

}
