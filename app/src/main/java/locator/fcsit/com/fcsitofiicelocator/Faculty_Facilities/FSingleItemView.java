package locator.fcsit.com.fcsitofiicelocator.Faculty_Facilities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import locator.fcsit.com.fcsitofiicelocator.R;

public class FSingleItemView extends AppCompatActivity {
    // Declare Variables
    TextView Ftxtnumber;
    TextView Ftxtname;
    TextView Ftxtmap;

    ImageView Fimgphoto;
    String Fnumber;
    String Fname;
    String Fmap;

    int Fphotos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fsingle_item_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.ftoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Get the intent from DListViewAdapter
        Intent i = getIntent();
        // Get the results of Facility number
        Fnumber = i.getStringExtra("fnumber");
        // Get the results of Facility name
        Fname = i.getStringExtra("fname");
        // Get the results of Facility map
        Fmap = i.getStringExtra("fmap");

        // Get the results of Facility Photo
        Fphotos = i.getIntExtra("fphoto", Fphotos);

        // Locate the TextViews in singleitemview.xml
        Ftxtnumber = (TextView) findViewById(R.id.fnumber);
        Ftxtname = (TextView) findViewById(R.id.fname);
        Ftxtmap = (TextView) findViewById(R.id.fmap);

        // Locate the ImageView in singleitemview.xml
        Fimgphoto = (ImageView) findViewById(R.id.fphotos);

        // Load the results into the TextViews
        Ftxtnumber.setText(Fnumber);
        Ftxtname.setText(Fname);
        Ftxtmap.setText(Fmap);


        // Load the image into the ImageView
        Fimgphoto.setImageResource(Fphotos);


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
