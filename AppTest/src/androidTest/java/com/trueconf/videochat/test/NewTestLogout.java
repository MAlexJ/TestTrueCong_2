package com.trueconf.videochat.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


@SuppressWarnings("rawtypes")
public class NewTestLogout extends ActivityInstrumentationTestCase2 {
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
    public NewTestLogout() throws ClassNotFoundException {
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
        //Click on Sign up for TrueConf
		solo.clickOnView(solo.getView("tv_registrate"));
        //Wait for activity: 'com.trueconf.gui.activities.Register'
		assertTrue("Register is not found!", solo.waitForActivity("Register"));
        //Press menu back key
		solo.goBack();
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
		assertTrue("ContactTabs is not found!", solo.waitForActivity("ContactTabs"));
        //Set default small timeout to 12769 milliseconds
		Timeout.setSmallTimeout(12769);
        //Scroll to 1st ListView
//		android.widget.ListView listView0 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 0);
//		solo.scrollListToLine(listView0, 0);
        //Scroll to Logout fear724@trueconf.com
		android.widget.ListView listView1 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 2);
		solo.scrollListToLine(listView1, 2);
        //Click on Logout fear724@trueconf.com
		solo.clickOnText(java.util.regex.Pattern.quote("Logout"));
        //Wait for activity: 'com.trueconf.gui.activities.Login'
		solo.sleep(2000);
		assertTrue("Login is not found!", solo.waitForActivity("Login"));
	}
}
