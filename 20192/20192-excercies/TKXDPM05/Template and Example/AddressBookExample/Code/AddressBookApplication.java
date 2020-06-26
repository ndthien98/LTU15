/*
 * AddressBookApplication.java
 *
 * Main program for address book application
 *
 * Copyright (c) 2001, 2003, 2005 - Russell C. Bjork
 *
 */

import java.awt.Frame;
import java.awt.event.WindowEvent;

// The next line is only needed on the Mac platform - comment out
// if compiling on some other platform (but comment back in and recompile
// before moving final version to server)

import com.apple.eawt.*;

/** Main class for the Address Book example
 */
public class AddressBookApplication
{
    /** Main method for program
     */    
    public static void main(String [] args)
    {
		FileSystem fileSystem = new FileSystem();
		AddressBookController controller = new AddressBookController(fileSystem);
		AddressBookGUI gui = new AddressBookGUI(controller, new AddressBook());
		gui.show();
				
		// Register a Mac quit handler - comment out if compiling on some
		// other platform (but comment back in and recompile
		// before moving final version to server)
		
		com.apple.eawt.Application application = 
			com.apple.eawt.Application.getApplication();
		application.addApplicationListener(new ApplicationAdapter() {
			public void handleQuit(ApplicationEvent e)
			{
				e.setHandled(false);
				quitApplication();
			}
		});		
    }
    
    /** Terminate the application (unless cancelled by the user)
     */
    public static void quitApplication()
    {
		// When the user requests to quit the application, any open
		// windows must be closed
		Frame [] openWindows = Frame.getFrames();
		for (int i = 0; i < openWindows.length; i ++)
		{
			// Attempt to close any window that belongs to this program
			
			if (openWindows[i] instanceof AddressBookGUI)
			{
				openWindows[i].dispatchEvent(new WindowEvent(
								 openWindows[i], 
								 WindowEvent.WINDOW_CLOSING));
								 
                // If the window is still showing, this means that this attempt 
                // to close the window was cancelled by the user - so abort the
                // quit operation
                
 				if (openWindows[i].isShowing())
                    return;
			}
		}

		// If we get here, all open windows have been successfully closed 
		// (i.e. the user has not cancelled an offer to save any of them).
		// Thus, the application can terminate.
		
		System.exit(0);
	}
}

	
