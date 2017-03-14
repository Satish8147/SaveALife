package com.example.soraganv.savealife;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.content.pm.ActivityInfo.LAUNCH_SINGLE_TASK;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    public void gotopaytm(View v) throws PackageManager.NameNotFoundException, IllegalAccessException, InstantiationException {
                /*
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found

                }
                */
        PackageManager pm = getPackageManager();


        PackageInfo packageInfo = pm.getPackageInfo("net.one97.paytm", PackageManager.GET_ACTIVITIES);

        ActivityInfo[] activitiesInfos = packageInfo.activities;
        ActivityInfo activityToLaunch = activitiesInfos[1]; //<< activity which want to start
        ActivityInfo activityToLaunch1 = activitiesInfos[2];
       ComponentName compName=new ComponentName(activityToLaunch.applicationInfo.packageName,activityToLaunch.name);
        Intent intent=new Intent(getApplicationContext(),activityToLaunch.name.getClass());
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setComponent(compName);
        startActivityForResult(intent,1);
      /*   FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(Integer.parseInt(activityToLaunch1.name.getClass().newInstance()), null);
        ft.commit();*/
       // activityToLaunch1.launchMode=LAUNCH_SINGLE_TASK;

    }
    public interface FragmentHolder {
        Fragment getFragment();
    }


// Create ComponentName object using packageName and activity name
                /*ComponentName compName=new ComponentName(activityToLaunch.applicationInfo.packageName,activityToLaunch.name);
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add();
                transaction.addToBackStack(null);
                transaction.commit();
                */
             /*   Intent intent=new Intent(getApplicationContext(),activityToLaunch.name.getClass());
                //intent.addCategory(Intent.CATEGORY_LAUNCHER);
               // intent.setFlags(Intent.FLAG_ACTI);
                intent.setComponent(compName);
                startActivity(intent);*/



            /*  final Intent intent = new Intent(Intent.ACTION_MAIN, null);

               intent.addCategory(Intent.CATEGORY_LAUNCHER);

               final ComponentName cn = new ComponentName("net.one97.paytm","net.one97.paytm.AJRAccountActivity");

               intent.setComponent(cn);

              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

               startActivity( intent);


           }
           */

    public void freecharge(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.freecharge.android");
        // launchIntent.fillIn(new Intent(getApplicationContext(),))
        //launchIntent.setAction("PaySendActivity");
        //Intent launchIntent = getPackageManager().getLeanbackLaunchIntentForPackage("net.one97.paytm");
        if (launchIntent != null) {
            startActivity(launchIntent);

        }

    }

}
