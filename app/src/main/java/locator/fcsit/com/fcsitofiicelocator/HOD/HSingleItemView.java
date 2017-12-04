package locator.fcsit.com.fcsitofiicelocator.HOD;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import locator.fcsit.com.fcsitofiicelocator.R;

public class HSingleItemView extends AppCompatActivity {
    // Declare Variables
    TextView txtoffice;
    TextView txtlectures;
    TextView txtphone;
    TextView txtemail;
    TextView txtmap;
    ImageView imgphoto;
    String office;
    String lecturer;
    String phone;
    String email;
    String map;
    int photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsingle_item_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Get the intent from DListViewAdapter
        Intent i = getIntent();
        // Get the results of office
        office = i.getStringExtra("office");
        // Get the results of lecturer
        lecturer = i.getStringExtra("lecturer");
        // Get the results of phone
        phone = i.getStringExtra("phone");
        //Get the results of email
        email = i.getStringExtra("email");
        //Get the results of map
        map = i.getStringExtra("map");
        // Get the results of photo
        photo = i.getIntExtra("photo", photo);

        // Locate the TextViews in singleitemview.xml
        txtoffice = (TextView) findViewById(R.id.office);
        txtlectures = (TextView) findViewById(R.id.lecturer);
        txtphone = (TextView) findViewById(R.id.phone);
        txtemail = (TextView)findViewById(R.id.email);
        txtmap = (TextView)findViewById(R.id.map);

        // Locate the ImageView in singleitemview.xml
        imgphoto = (ImageView) findViewById(R.id.photos);

        // Load the results into the TextViews
        txtoffice.setText(office);
        txtlectures.setText(lecturer);
        txtphone.setText(phone);
        txtemail.setText(email);
        txtmap.setText(map);

        // Load the image into the ImageView
        imgphoto.setImageResource(photo);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.about:
                Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
