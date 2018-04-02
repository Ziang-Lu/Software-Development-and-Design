package model.members;

import model.members.MembershipLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Member {

    /**
     * Name of this member.
     */
    private final String name;
    /**
     * Membership level of this member.
     */
    private MembershipLevel myLevel;
    /**
     * Visit records of this member.
     */
    private final List<Visit> visitRecords;

    /**
     * Constructor with parameter.
     * @param name name of the member
     */
    public Member(String name) {
        this.name = name;
        myLevel = MembershipLevel.BASIC;
        visitRecords = new ArrayList<>();
    }

    /**
     * Accessor of name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor of myLevel.
     * @return myLevel
     */
    public MembershipLevel getLevel() {
        return myLevel;
    }

    /**
     * Accessor of visitRecords.
     * @return visitRecords
     */
    public List<Visit> getVisitHistory() {
        return visitRecords;
    }

    /**
     * Upgrades this member, if possible.
     */
    public void upgrade() {
        if (myLevel == MembershipLevel.BASIC) {
            myLevel = MembershipLevel.CLASSES;
        } else if (myLevel == MembershipLevel.CLASSES) {
            myLevel = MembershipLevel.DELUXE;
        }
    }

    /**
     * Checks in for this member today.
     */
    public void checkIn() {
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR), month = today.get(Calendar.MONTH) + 1,
                day = today.get(Calendar.DAY_OF_MONTH);
        visitRecords.add(new Visit(year, month, day));
    }

}
