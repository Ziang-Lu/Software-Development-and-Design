package items;

public class Book extends LoanableItem {

    /**
     * Loan length for normal books.
     */
    private static final int NORMAL_LOAN_LENGTH = 3 * DAYS_PER_WEEK;
    /**
     * Loan length for best-sellers.
     */
    private static final int BEST_SELLER_LOAN_LENGTH = 2 * DAYS_PER_WEEK;

    /**
     * Whether this book is a best-seller.
     */
    private boolean bestSeller;

    /**
     * Constructor with parameters.
     * @param title title of the book
     * @param value value of the book
     * @param bestSeller whether this book is best-seller
     */
    public Book(String title, double value, boolean bestSeller) {
        super(title, value);
        this.bestSeller = bestSeller;
    }

    /**
     * Sets this book to be not a best-seller anymore.
     */
    public void setAsNotBestSeller() {
        bestSeller = false;
    }

    @Override
    protected int getLoanLength() {
        if (bestSeller) {
            return BEST_SELLER_LOAN_LENGTH;
        }
        return NORMAL_LOAN_LENGTH;
    }

}
