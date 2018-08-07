package library;

import items.AVMaterial;
import items.Book;
import items.Item;
import items.LoanableItem;
import items.Magazine;
import items.ReferenceBook;
import patrons.Patron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Library class.
 *
 * @author Ziang Lu
 */
public class Library {

    /**
     * Next library card number to assign.
     */
    private static int patronCardNum = 0;

    /**
     * Items by title.
     */
    private Map<String, List<Item>> itemsByTitle;
    /**
     * Patrons by library card number.
     */
    private Map<Integer, Patron> patrons;
    /**
     * Titles of the pending requests.
     */
    private List<String> pendingRequests;

    /**
     * Default constructor.
     */
    public Library() {
        itemsByTitle = new HashMap<>();
        patrons = new HashMap<>();
    }

    /**
     * Private helper method the given item.
     * @param newItem item to add
     */
    private void addItem(Item newItem) {
        String title = newItem.getTitle();
        List<Item> items = itemsByTitle.getOrDefault(title, new ArrayList<>());
        items.add(newItem);
        itemsByTitle.put(title, items);
    }

    /**
     * Adds a new book.
     * @param title title of the book
     * @param value value of the book
     * @param bestSeller whether the book to add is a best-seller
     */
    public void addBook(String title, double value, boolean bestSeller) {
        Book newBook = new Book(title, value, bestSeller);
        addItem(newBook);
    }

    /**
     * Adds a new A/V material.
     * @param title title of the A/V material
     * @param value value of the A/V material
     */
    public void addAVMaterial(String title, double value) {
        AVMaterial newAVMaterial = new AVMaterial(title, value);
        addItem(newAVMaterial);
    }

    /**
     * Adds a new reference book.
     * @param title title of the reference book
     */
    public void addReferenceBook(String title) {
        ReferenceBook newReferenceBook = new ReferenceBook(title);
        addItem(newReferenceBook);
    }

    /**
     * Adds a new magazine.
     * @param title title of the magazine
     */
    public void addMagazine(String title) {
        Magazine newMagazine = new Magazine(title);
        addItem(newMagazine);
    }

    /**
     * Registers a new patron.
     * @param name name of the patron
     * @param age age of the patron
     * @param phoneNum phone number of the patron
     * @param addr address of the patron
     * @return newly registered patron
     */
    public Patron registerPatron(String name, int age, long phoneNum, String addr) {
        Patron newPatron = new Patron(patronCardNum, name, age);
        newPatron.setPhoneNum(phoneNum);
        newPatron.setAddr(addr);
        patrons.put(patronCardNum, newPatron);
        ++patronCardNum;
        return newPatron;
    }

    /**
     * Lets the given patron requests an item with the given title.
     * @param title title of the item to request
     * @return requested item if available, null if not
     */
    public LoanableItem itemRequested(String title) {
        if (!itemsByTitle.containsKey(title)) {
            return null;
        }
        List<Item> titledItems = itemsByTitle.get(title);
        for (Item titledItem : titledItems) {
            if (titledItem instanceof LoanableItem) {
                LoanableItem titledLoanable = (LoanableItem) titledItem;
                if (!titledLoanable.isCheckedOut()) {
                    titledLoanable.checkOut();
                    return titledLoanable;
                }
            }
        }
        pendingRequests.add(title);
        return null;
    }

    /**
     * Lets the given item to be renewed.
     * @param item item to renew
     * @return whether the item is successfully renewed
     */
    public boolean itemRenewed(Item item) {
        LoanableItem loanable = (LoanableItem) item;
        // An item can only be renewed once.
        if (loanable.isRenewed()) {
            return false;
        }
        // If there is a pending request for this item, it cannot be renewed.
        String title = item.getTitle();
        for (String pendingRequest : pendingRequests) {
            if (pendingRequest.equals(title)) {
                return false;
            }
        }
        ((LoanableItem) item).renew();
        return true;
    }

    /**
     * Lets the given item to be returned.
     * @param item item to return
     */
    public void itemReturned(Item item) {
        ((LoanableItem) item).checkIn();
        // Remove the corresponding pending request if there is one
        pendingRequests.remove(item.getTitle());
    }

    /**
     * Gets the checked out items by the given patron.
     * @param cardNum library card number of the patron
     * @return checked out items by the patron
     */
    public List<Item> getPatronItems(int cardNum) {
        Patron patron = patrons.get(cardNum);
        if (patron == null) {
            return new ArrayList<>();
        }
        return patron.getMyItems();
    }

    /**
     * Calculates the overdue fine of the given patron.
     * @param cardNum library card number of the patron
     * @return overdue fine of the patron
     */
    public double calcOverdueFine(int cardNum) {
        Patron patron = patrons.get(cardNum);
        if (patron == null) {
            return 0.0;
        }
        return patron.calcOverdueFine();
    }

}
