package factory_creator;

import product_document.FancyLetter;
import product_document.FancyResume;
import product_document.Letter;
import product_document.Resume;

/**
 * Concrete factory FancyDocumentCreator class.
 *
 * @author Ziang Lu
 */
public class FancyDocumentCreator implements DocumentCreator {

    /**
     * Concrete factory method to make a concrete product FancyLetter instance.
     * @return instantiated Letter
     */
    @Override
    public Letter createLetter() {
        return new FancyLetter();
    }

    /**
     * Concrete factory method to make a concrete product FancyResume instance.
     * @return instantiated Resume
     */
    @Override
    public Resume createResume() {
        return new FancyResume();
    }

}
