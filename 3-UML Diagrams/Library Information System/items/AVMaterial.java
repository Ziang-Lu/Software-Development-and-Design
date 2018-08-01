package items;

public class AVMaterial extends LoanableItem {

    /**
     * Loan length.
     */
    private static final int LOAN_LENGTH = 2 * DAYS_PER_WEEK;

    /**
     * Constructor with parameters.
     * @param title title of the A/V material
     * @param value value of this A/V material
     */
    public AVMaterial(String title, double value) {
        super(title, value);
    }

    @Override
    protected int getLoanLength() {
        return LOAN_LENGTH;
    }

}
