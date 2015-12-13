package com.example.malex.testtruecong_2;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.robotium.solo.Solo;


public class ApplicationTest extends ActivityInstrumentationTestCase2<LoginActivity> {
    private Solo solo;
    private EditText textName;
    private EditText textPassword;
    private LinearLayout button;

    public ApplicationTest() {
        super(LoginActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        //setUp() is run before a test case is started.
        //This is where the solo object is created.
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        //tearDown() is run after a test case has finished.
        //finishOpenedActivities() will finish all the activities that have been opened during the test execution.
        solo.finishOpenedActivities();
    }


    public void testAddNote() throws Exception {
        //Unlock the lock screen
        solo.unlockScreen();
        textName = (EditText) solo.getView(R.id.et_name);
        textPassword = (EditText) solo.getView(R.id.et_password);
        button = (LinearLayout) solo.getView(R.id.btn_login_ll);

        int x = 0;
        while (x < 3) {
            solo.sleep(300); //1sec
            solo.enterText(textName, String.valueOf("text: Alex item=" + x));
            solo.sleep(900); //1sec
            solo.enterText(textPassword, String.valueOf("text: Password item=" + x));
            solo.sleep(900); //1sec
            solo.clickOnView(button, true);
            solo.sleep(900); //1sec
            solo.goBack();
            clearViews(textName, textPassword);
            x++;
        }
    }

    private void clearViews(EditText textName, EditText textPassword) {
        solo.clearEditText(textName);
        solo.clearEditText(textPassword);
    }

}