package android.example.com;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getInfo();
    }


    private void getInfo(){
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String s = "App name: "+getString(R.string.app_name)+"\nPackage name: "+packageInfo.applicationInfo.packageName+"\nSdkVersion : "+packageInfo.applicationInfo.targetSdkVersion+ "\nMinVersion : "+packageInfo.applicationInfo.minSdkVersion;
            ((TextView)findViewById(R.id.tv)).setText(s);
        }
        catch (PackageManager.NameNotFoundException e) {
            Log.e("Error: ", e.getMessage());
        }
    }
}


