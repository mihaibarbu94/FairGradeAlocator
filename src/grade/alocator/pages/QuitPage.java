package grade.alocator.pages;

import grade.alocator.WriterToFile;

public class QuitPage extends Page {

    /**
     * Creates the Quit Page object stores data to a text file and then exists.
     */
    public QuitPage() {
        WriterToFile.storeDataToTextFile();
        System.exit(0);
    }

    /**
     *  Creates the view of the page by displaying text in the command line.
     *  Here no text in required so we display nothing.
     */
    @Override
    void createView() {}
}
