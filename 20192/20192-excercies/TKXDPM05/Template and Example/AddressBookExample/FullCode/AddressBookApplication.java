/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.apple.eawt.Application
 *  com.apple.eawt.ApplicationAdapter
 *  com.apple.eawt.ApplicationEvent
 *  com.apple.eawt.ApplicationListener
 */
import com.apple.eawt.Application;
import com.apple.eawt.ApplicationAdapter;
import com.apple.eawt.ApplicationEvent;
import com.apple.eawt.ApplicationListener;
import java.awt.AWTEvent;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowEvent;

public class AddressBookApplication {
    public static void main(String[] arrstring) {
        FileSystem fileSystem = new FileSystem();
        AddressBookController addressBookController = new AddressBookController(fileSystem);
        AddressBookGUI addressBookGUI = new AddressBookGUI(addressBookController, new AddressBook());
        addressBookGUI.show();
        Application application = Application.getApplication();
        application.addApplicationListener((ApplicationListener)new ApplicationAdapter(){

            public void handleQuit(ApplicationEvent applicationEvent) {
                applicationEvent.setHandled(false);
                AddressBookApplication.quitApplication();
            }
        });
    }

    public static void quitApplication() {
        Frame[] arrframe = Frame.getFrames();
        for (int i = 0; i < arrframe.length; ++i) {
            if (!(arrframe[i] instanceof AddressBookGUI)) continue;
            arrframe[i].dispatchEvent(new WindowEvent(arrframe[i], 201));
            if (!arrframe[i].isShowing()) continue;
            return;
        }
        System.exit(0);
    }

}

