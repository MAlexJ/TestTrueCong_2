package com.trueconf.videochat.test;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

/***
 * automatic black-box UI tests for Android applications TrueConf
 */

public class TestLoginActivity extends ActivityInstrumentationTestCase2 {
    private Solo solo;
    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.trueconf.gui.activities.Login";
    private static Class<?> launcherActivityClass;

    static {
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Приложение на устройстве не обнаружено", e);
        }
    }

    public TestLoginActivity() throws ClassNotFoundException {
        super(launcherActivityClass);
    }

    //Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation());
        getActivity();
    }

    //After
    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    //Test 1
    public void testLoginActivitySingUp() {
        //Wait for activity: 'com.trueconf.gui.activities.Login'
        solo.waitForActivity("Login", 2000);
        //Set default small timeout to 12000 milliseconds
        Timeout.setSmallTimeout(12000);
        //Click on Sign up for TrueConf
        solo.clickOnView(solo.getView("tv_registrate"));
        assertTrue("Register is not found!", solo.waitForActivity("Register"));
        solo.sleep(5000);
        solo.goBack();
        solo.sleep(2000);
        assertTrue("Login is not found!", solo.waitForActivity("Login"));
    }

    //Test 2
    public void testLoginActivityLoginIn() {
        //Wait for activity: 'com.trueconf.gui.activities.Login'
        solo.waitForActivity("Login", 2000);
        //Set default small timeout to 12000 milliseconds
        Timeout.setSmallTimeout(12000);
        //Click on Have an account Log in
        assertTrue("Login Activity is not found", solo.waitForActivity("Login"));
        solo.clickOnView(solo.getView("tv_is_have_account"));

        solo.sleep(5000);
        assertTrue("Login Activity is not found", solo.waitForActivity("Login"));
        solo.goBack();
    }

    //Test 3
    public void testIsHaveAccount() {
        //Wait for activity: 'com.trueconf.gui.activities.Login'
        solo.waitForActivity("Login", 2000);
        //Set default small timeout to 12000 milliseconds
        Timeout.setSmallTimeout(12000);
        //Click on Have an account Log in
        solo.clickOnView(solo.getView("tv_is_have_account"));
        solo.sleep(5000);
        //Click on Empty Text View
        solo.clickOnView(solo.getView("et_videochat_id"));
        //Enter the text: 'kovalek'
        solo.clearEditText((android.widget.EditText) solo.getView("et_videochat_id"));
        solo.enterText((android.widget.EditText) solo.getView("et_videochat_id"), "kovalek");
        solo.pressSoftKeyboardNextButton();
        //Click on Login
        solo.clickOnView(solo.getView("btn_login_ll"));
        assertFalse("Неверный TrueConf ID или пароль", solo.waitForActivity("ContactTabs"));
        solo.goBack();
    }


}
