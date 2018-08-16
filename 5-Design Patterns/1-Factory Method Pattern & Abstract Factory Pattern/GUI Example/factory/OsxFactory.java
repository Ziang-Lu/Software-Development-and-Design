package factory;

import product_button.MyButton;
import product_button.OsxButton;

/**
 * Concrete factory OsxFactory class.
 *
 * @author Ziang Lu
 */
public class OsxFactory implements GuiFactory {

    /**
     * Concrete factory method to make a concrete product OsxButton instance.
     * @return instantiated MyButton
     */
    @Override
    public MyButton createButton() {
        return new OsxButton();
    }

}
