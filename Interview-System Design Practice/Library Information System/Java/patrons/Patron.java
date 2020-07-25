package patrons;

import items.Item;
import items.LoanableItem;
import library.Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Patron class.
 *
 * @author Ziang Lu
 */
public class Patron {

    /**
     * Library card number assigned to this patron.
     */
    private final int cardNum;
    /**
     * Name of this patron.
     */
    private final String name;
    /**
     * Birthday of this patron.
     */
    private final Date bday;
    /**
     * Phone number of this patron.
     */
    private long phoneNum;
    /**
     * Address of this patron.
     */
    private String addr;
    /**
     * Patron's checked out items by title.
     */
    private Map<String, Item> myItemsByTitle;

    /**
     * Constructor with parameter.
     * @param cardNum library card number assigned to the patron
     * @param name name of the patron
     * @param bday birthday of the patron
     * @param phoneNum phone number of the patron
     */
    public Patron(int cardNum, String name, Date bday, long phoneNum) {
        this.cardNum = cardNum;
        this.name = name;
        this.bday = bday;
        this.phoneNum = phoneNum;
        myItemsByTitle = new HashMap<>();
    }

    /**
     * Accessor of cardNum.
     * @return cardNum
     */
    public int getCardNum() {
        return cardNum;
    }

    /**
     * Accessor of name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Calculates the age of this patron.
     * @return age of the patron
     */
    public int getAge() {
        Date curr = new Date();
        return curr.getYear() - bday.getYear();
    }

    /**
     * Accessor of phoneNum.
     * @return phoneNum
     */
    public long getPhoneNum() {
        return phoneNum;
    }

    /**
     * Accessor of addr.
     * @return addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * Returns the checked out items by this patron as a list.
     * @return checked out items by this patron
     */
    public List<Item> getMyItems() {
        return new ArrayList<>(myItemsByTitle.values());
    }

    /**
     * Mutator of addr.
     * @param addr address to set
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * Requests to the given library for the item with the given title.
     * @param lib library to make the request
     * @param title title of the item to request
     */
    public void requestItem(Library lib, String title) {
        // Children (age 12 or under) can only check out 5 items at a time
        if ((getAge() <= 12) && (myItemsByTitle.values().size() >= 5)) {
            return;
        }

        Item loanable = lib.itemRequested(title);
        if (loanable == null) {
            return;
        }
        myItemsByTitle.put(title, loanable);
    }

    /**
     * Renews the given item to the given library.
     * @param lib library to apply for renew
     * @param title title of the item to renew
     */
    public void renewItem(Library lib, String title) {
        if (!myItemsByTitle.containsKey(title)) {
            return;
        }
        Item item = myItemsByTitle.get(title);
        if (!lib.itemRenewed(item)) {
            returnItem(lib, item);
        }
    }

    /**
     * Private helper method to return the given item to the given library.
     * @param lib library to return to
     * @param item item to return
     */
    private void returnItem(Library lib, Item item) {
        lib.itemReturned(item);
        myItemsByTitle.remove(item.getTitle());
    }

    /**
     * Returns the item with the given title to the given library.
     * @param lib library to return to
     * @param title title of the item to return
     */
    public void returnItem(Library lib, String title) {
        if (!myItemsByTitle.containsKey(title)) {
            return;
        }l
        Item item = myItemsByTitle.get(title);
        returnItem(lib, item);
    }

}
