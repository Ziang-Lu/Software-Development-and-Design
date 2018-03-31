package model.weights;

public class WeightMachine extends Weight {

    /**
     * Muscle group that this weight machine targets.
     */
    private String muscleGroup;

    /**
     * Constructor with parameter.
     * @param pounds weight of the weight machine
     * @param muscleGroup muscle group that the weight machine targets
     */
    public WeightMachine(int pounds, String muscleGroup) {
        // We asusme that pounds is positive.
        super(pounds);
        this.muscleGroup = muscleGroup;
    }

    @Override
    public int getWeight() {
        return pounds;
    }

    /**
     * Accessor of muscleGroup.
     * @return muscleGroup
     */
    public String getMuscleGroup() {
        return muscleGroup;
    }

}
