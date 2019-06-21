/**
 * Simple message utility.
 *
 * @author Ziang Lu
 */
public class MessageUtil {

    /**
     * Underlying message.
     */
    private String msg;

    /**
     * Constructor with parameter.
     * @param msg message to store
     */
    public MessageUtil(String msg) {
        this.msg = msg;
    }

    /**
     * Prints and returns the underlying message.
     * @return underlying message
     */
    public String printMessage() {
        System.out.println(msg);
        return msg;
    }

}
