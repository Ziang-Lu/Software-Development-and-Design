package model.gym;

import java.util.ArrayList;
import java.util.List;

import model.members.Member;

public class FitnessClass {

    /**
     * Maximum capacity.
     */
    private static final int MAX_CAPACITY = 25;

    /**
     * Name of this fitness class.
     */
    private final String name;
    /**
     * Date of this fitness class.
     */
    private final String classDate;
    /**
     * Registered members of this fitness class.
     */
    private final List<Member> registered;

    /**
     * Constructor with parameter.
     * @param name name of the fitness class
     * @param classDate date of the fitness class
     */
    public FitnessClass(String name, String classDate) {
        this.name = name;
        this.classDate = classDate;
        registered = new ArrayList<>();
    }

    /**
     * Accessor of name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor of classDate.
     * @return classDate
     */
    public String getClassDate() {
        return classDate;
    }

    /**
     * Accessor of registeredMembers.
     * @return registeredMember
     */
    public List<Member> getRegisteredMembers() {
        return registered;
    }

    /**
     * Registers the given member to this fitness class.
     * @param member member to register
     */
    public void registerMember(Member member) {
        if (registered.indexOf(member) >= 0) {
            System.out.println("Sorry, but you seem to have registered the class");
            return;
        }
        if (registered.size() >= MAX_CAPACITY) {
            System.out.println("Sorry, but the class is full");
            return;
        }
        registered.add(member);
    }

    /**
     * Removes the given member from this fitness class.
     * @param member member to remove
     */
    public void removeMember(Member member) {
        int memberIdx = registered.indexOf(member);
        if (memberIdx < 0) {
            System.out.println("Sorry, but you seem to have not registered the class");
            return;
        }
        registered.remove(memberIdx);
    }

}
