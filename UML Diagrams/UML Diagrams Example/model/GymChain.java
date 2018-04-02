package model;

import java.util.ArrayList;
import java.util.List;

import model.gym.Gym;
import model.members.Member;
import model.members.MembershipLevel;

public class GymChain {

    /**
     * Gyms of this gym chain.
     */
    private List<Gym> gyms;
    /**
     * Members of this gym chain.
     */
    private List<Member> members;

    /**
     * Default constructor.
     */
    public GymChain() {
        gyms = new ArrayList<>();
        members = new ArrayList<>();
    }

    /**
     * Accessor of gyms.
     * @return gyms
     */
    public List<Gym> getGyms() {
        return gyms;
    }

    /**
     * Finds the gym according to the given location name.
     * @param location given location name
     * @return gym if found, null if not found
     */
    public Gym findGym(String location) {
        for (Gym gym : gyms) {
            if (gym.getLocation().toLowerCase().equals(location.toLowerCase())) {
                return gym;
            }
        }
        // Not found
        return null;
    }

    /**
     * Accessor of members.
     * @return members
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * Finds the member according to the given name.
     * @param name given name
     * @return member if found, null if not found
     */
    public Member findMember(String name) {
        for (Member member : members) {
            if (member.getName().toLowerCase().equals(name.toLowerCase())) {
                return member;
            }
        }
        // Not found
        return null;
    }

    /**
     * Determines whether a member can enter a gym.
     * @param memberName name of the member
     * @param gymLocation location name of the gym
     * @return whether the member can enter the gym
     */
    public boolean canMemberEnterGym(String memberName, String gymLocation) {
        Member member = findMember(memberName);
        Gym gym = findGym(gymLocation);
        if ((member == null) || (gym == null)) {
            return false;
        }

        if (member.getLevel() == MembershipLevel.DELUXE) {
            return true;
        }
        return !gym.getClass().getSimpleName().equals("DeluxeGym");
    }

    /**
     * Adds the given gym to this gym chain.
     * @param gym gym to add
     */
    public void addGym(Gym gym) {
        if (gym == null) {
            throw new IllegalArgumentException("The gym should not be null.");
        }
        gyms.add(gym);
    }

    /**
     * Signs up the given member to this gym chain.
     * @param member member to add
     */
    public void signUpMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("The member should not be null.");
        }
        members.add(member);
    }

}
