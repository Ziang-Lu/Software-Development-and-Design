package factory_creator;

import product_document.Letter;
import product_document.ModernLetter;
import product_document.ModernResume;
import product_document.Resume;

/**
 * Concrete factory ModernDocumentCreator class.
 *
 * @author Ziang Lu
 */
public class ModernDocumentCreator implements DocumentCreator {

    /**
     * Concrete factory method to make a concrete product ModernLetter instance.
     * @return instantiated Letter
     */
    @Override
    public Letter createLetter() {
        return new ModernLetter();
    }

    /**
     * Concrete factory method to make a concrete product ModernResume instance.
     * @return instantiated Letter
     */
    @Override
    public Resume createResume() {
        return new ModernResume();
    }

}
