package locator.fcsit.com.fcsitofiicelocator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_Screen extends AppCompatActivity {
    long Lokaci = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        Timer gudu = new Timer();
        TimerTask ShowSplash = new TimerTask(){
            public void run(){
                finish();
                Intent nextIntent = new Intent(Splash_Screen.this,MainActivity.class);
                startActivity(nextIntent);
            }
        };
        gudu.schedule(ShowSplash, Lokaci);
    }
}
