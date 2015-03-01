package bionic.steps;

import bionic.pages.AbstractPage;
import bionic.support.Browser;

/**
 * Created by andrey on 24.02.15.
 */
public class AbstractUser {

    Browser window;
    
    protected AbstractUser(Browser window) {
        this.window = window;
    }

    public Browser getWindow() {
        return window;
    }

    protected void returnDriverFrom(AbstractPage page) {
        window = page.getWindow();
    }
}
