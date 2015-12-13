package com.trueconf.videochat.test;

import com.robotium.solo.*;
import android.test.ActivityInstrumentationTestCase2;


public class RunTest2 extends ActivityInstrumentationTestCase2 {
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
  	
  	public RunTest2() throws ClassNotFoundException {
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
        //Set default small timeout to 11881 milliseconds
		Timeout.setSmallTimeout(11881);
        //Click on Sign up for TrueConf
		solo.clickOnView(solo.getView("tv_registrate"));
        //Wait for activity: 'com.trueconf.gui.activities.Register'
		assertTrue("Register is not found!", solo.waitForActivity("Register"));
        //Click on person-reg-login
		solo.clickOnWebElement(By.id("person-reg-login"));
        //Clear text in person-reg-login
		solo.clearTextInWebElement(By.id("person-reg-login"));
        //Enter text in person-reg-login
		solo.enterTextInWebElement(By.id("person-reg-login"), "alexmaximovj");
        //Set default small timeout to 13909 milliseconds
		Timeout.setSmallTimeout(13909);
        //Click on SPAN
		solo.clickOnWebElement(By.tagName("SPAN"));
        //Clear text in SPAN
		solo.clearTextInWebElement(By.tagName("SPAN"));
        //Enter text in SPAN
		solo.enterTextInWebElement(By.tagName("SPAN"), "undefined");
        //Click on reg_wrapper
		solo.clickOnWebElement(By.id("reg_wrapper"));
		solo.sleep(1000);
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
        //Wait for dialog
		solo.waitForDialogToOpen(5000);
        //Wait for dialog to close
		solo.waitForDialogToClose(5000);
        //Click on Golubinsky, Yury urixx LinearLayout LinearLayout LinearLayout
		solo.clickInList(1, 0);
        //Click on ImageView
		solo.clickOnView(solo.getView(android.widget.ImageView.class, 13));
		solo.sleep(1000);
        //Wait for activity: 'com.trueconf.gui.activities.UserProfile'
		assertTrue("UserProfile is not found!", solo.waitForActivity("UserProfile"));
        //Press menu back key
		solo.goBack();
        //Click on HomeView
		solo.clickOnView(solo.getView(android.widget.FrameLayout.class, 13));
        //Scroll to Logout LinearLayout
		android.widget.ListView listView0 = (android.widget.ListView) solo.getView(android.widget.ListView.class, 2);
		solo.scrollListToLine(listView0, 2);
        //Click on Logout LinearLayout
		solo.clickOnText(java.util.regex.Pattern.quote("Logout"));
        //Wait for activity: 'com.trueconf.gui.activities.Login'
		assertTrue("Login is not found!", solo.waitForActivity("Login"));
	}
}
