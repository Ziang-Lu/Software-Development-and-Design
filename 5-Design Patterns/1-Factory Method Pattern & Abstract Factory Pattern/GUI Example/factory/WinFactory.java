package factory;

import product_button.MyButton;
import product_button.WinButton;

public class WinFactory implements GuiFactory {

    /**
     * Concrete factory method to make a concrete product WinButton instance.
     * @return instantiated MyButton
     */
    @Override
    public MyButton createButton() {
        return new WinButton();
    }

}
