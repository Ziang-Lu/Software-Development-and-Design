package model.gym;

import java.util.ArrayList;
import java.util.List;

import model.cardio.CardioMachine;
import model.members.Member;
import model.weights.Weight;

public class Gym {

    /**
     * Location name of this gym.
     */
    private final String location;
    /**
     * Weights in this gym.
     */
    private final List<Weight> weights;
    /**
     * Cardio machines in this gym.
     */
    private final List<CardioMachine> cardioMachines;
    /**
     * Fitness classes of this gym.
     */
    private final List<FitnessClass> classes;
    /**
     * Whether this gym has a pool.
     */
    private final boolean hasPool;

    /**
     * Constructor with parameter.
     * @param location location name of the gym
     * @param hasPool whether the gym has a pool
     */
    public Gym(String location, boolean hasPool) {
        this.location = location;
        weights = new ArrayList<>();
        cardioMachines = new ArrayList<>();
        classes = new ArrayList<>();
        this.hasPool = hasPool;
    }

    /**
     * Accessor of location.
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Accessor of weights.
     * @return weights
     */
    public List<Weight> getWeights() {
        return weights;
    }

    /**
     * Accessor of cardioMachines.
     * @return cardioMachines
     */
    public List<CardioMachine> getCardioMachines() {
        return cardioMachines;
    }

    /**
     * Accessor of classes.
     * @return classes
     */
    public List<FitnessClass> getClasses() {
        return classes;
    }

    /**
     * Accessor of hasPool.
     * @return hasPool
     */
    public boolean hasPool() {
        return hasPool;
    }

    /**
     * Adds the given weight to this gym
     * @param weight weight to add
     */
    public void addWeight(Weight weight) {
        if (weight == null) {
            throw new IllegalArgumentException("The weight should not be null");
        }
        weights.add(weight);
    }

    /**
     * Adds the given cardio machine to this gym.
     * @param machine cardio machine to add
     */
    public void addCardioMachine(CardioMachine machine) {
        if (machine == null) {
            throw new IllegalArgumentException("The cardio machine should not be null");
        }
        cardioMachines.add(machine);
    }

    /**
     * Adds the given fitness class to this gym.
     * @param cls fitness class to add
     */
    public void addFitnessClass(FitnessClass cls) {
        if (cls == null) {
            throw new IllegalArgumentException("The fitness class should not be null");
        }
        classes.add(cls);
    }

    /**
     * Guids the given member through workout.
     * @param member member to guide
     */
    public void guideMemberThroughWorkout(Member member) {
        String memberName = member.getName();
        for (Weight weight : weights) {
            System.out.println(memberName + " is lifting " + weight.getWeight() + " pounds");
        }
        for (CardioMachine cardioMachine : cardioMachines) {
            System.out.println(memberName + " is exercising on " + cardioMachine.getClass().getSimpleName() + " at "
                    + cardioMachine.getSpeed() + " speed for " + cardioMachine.getMinutes() + " minutes " + " at level "
                    + cardioMachine.getLevel());
        }
        for (FitnessClass cls : classes) {
            cls.registerMember(member);
            System.out.println(memberName + " is registered for " + cls.getName() + " on " + cls.getClassDate());
        }
    }

}
