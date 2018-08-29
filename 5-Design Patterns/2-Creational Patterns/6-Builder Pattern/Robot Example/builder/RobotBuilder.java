package builder;

import robot.Robot;

/**
 * Abstract RobotBuilder interface that works as an abstract factory and
 * defines how to build a robot by creating and assembling all of its parts.
 *
 * @author Ziang Lu
 */
public interface RobotBuilder {

    /**
     * Builds a robot's head.
     */
    void buildRobotHead();

    /**
     * Builds a robot's torso.
     */
    void buildRobotTorso();

    /**
     * Builds a robot's arms.
     */
    void buildRobotArms();

    /**
     * Builds a robot's legs.
     */
    void buildRobotLegs();

    /**
     * Returns the finished robot.
     * @return finished robot
     */
    Robot getRobot();

}
