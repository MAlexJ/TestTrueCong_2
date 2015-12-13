package com.trueconf.videochat.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class LoginFEAR724tEST extends ActivityInstrumentationTestCase2 {
  	private Solo solo;
  	
  	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.trueconf.gui.activities.Login";

    private static Class<?> launcherActivityClass;
    static{
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }
  	
  	@SuppressWarnings("unchecked")
    public LoginFEAR724tEST() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

  	public void setUp() throws Exception {
        super.setUp();
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
  	}
  
	public void testRun() {
        //Wait for activity: 'com.trueconf.gui.activities.Login'
		solo.waitForActivity("Login", 2000);
        //Click on Have an account? Log In
		solo.clickOnView(solo.getView("tv_is_have_account"));
        //Click on Empty Text View
		solo.clickOnView(solo.getView("et_videochat_id"));
        //Enter the text: 'fear724'
		solo.clearEditText((android.widget.EditText) solo.getView("et_videochat_id"));
		solo.enterText((android.widget.EditText) solo.getView("et_videochat_id"), "fear724");
        //Enter the text: '2687484'
		solo.clearEditText((android.widget.EditText) solo.getView("et_password"));
		solo.enterText((android.widget.EditText) solo.getView("et_password"), "2687484");
        //Press next button
		solo.pressSoftKeyboardNextButton();
        //Click on Login
		solo.clickOnView(solo.getView("btn_login_ll"));
        //Wait for activity: 'com.trueconf.gui.activities.ContactTabs'
		solo.sleep(20000);
		assertTrue("ContactTabs is not found!", solo.waitForActivity("ContactTabs"));
	}
}
