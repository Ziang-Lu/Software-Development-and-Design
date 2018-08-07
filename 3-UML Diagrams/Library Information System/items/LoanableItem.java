package items;

import java.util.Calendar;
import java.util.Date;

/**
 * Abstract loanable item class.
 *
 * @author Ziang Lu
 */
public abstract class LoanableItem extends Item {

    /**
     * Number of days per week.
     */
    protected static final int DAYS_PER_WEEK = 7;

    /**
     * Value of this loanable item.
     */
    private final double value;
    /**
     * Whether this loanable item has been checked out.
     */
    private boolean checkedOut;
    /**
     * Due date of this loanable item.
     */
    private Date dueDate;
    /**
     * Whether this loanable item has been renewed.
     */
    private boolean renewed;

    /**
     * Constructor with parameter.
     * @param title title of the item
     * @param value value of the item
     */
    public LoanableItem(String title, double value) {
        super(title);
        this.value = value;
        checkedOut = false;
        dueDate = null;
        renewed = false;
    }

    /**
     * Accessor of value.
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     * Accessor of checkedOut.
     * @return checkedOut
     */
    public boolean isCheckedOut() {
        return checkedOut;
    }

    /**
     * Accessor of dueDate.
     * @return
     */
    public Date getDueDate() {
        return dueDate;
    }

    public boolean isRenewed() {
        return renewed;
    }

    /**
     * Checks out this item.
     */
    public void checkOut() {
        checkedOut = true;
        setDueDate();
        renewed = false;
    }

    /**
     * Private helper method to set the due date when checking out.
     */
    private void setDueDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int loanLength = getLoanLength();
        calendar.add(Calendar.DAY_OF_YEAR, loanLength);
        dueDate = calendar.getTime();
    }

    /**
     * Helper method to get the loan length of this item.
     * @return loan length
     */
    protected abstract int getLoanLength();

    /**
     * Renews this item.
     */
    public void renew() {
        checkedOut = true;
        setDueDate();
        renewed = true;
    }

    /**
     * Checks in this item.
     */
    public void checkIn() {
        checkedOut = false;
        dueDate = null;
        renewed = false;
    }

}
