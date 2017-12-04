package locator.fcsit.com.fcsitofiicelocator.Level_Coord;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import locator.fcsit.com.fcsitofiicelocator.R;

public class Level_Coord extends AppCompatActivity {

    // Declare Variables
    ListView list;
    LListViewAdapter adapter;
    EditText editsearch;
    String[] office;
    String[] lecturers;
    String[] phone;
    String[] email;
    String[] map;
    int[] photo;
    ArrayList<LPopulation> arraylist = new ArrayList<LPopulation>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_coord);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Generate sample data
        office = new String[] {"R1-21 (Ground Floor)","R2-05 (Ground Floor FCSIT Extension)","R1-19 (Ground Floor)","R1-24 (First Floor)"};

        lecturers = new String[] {"Mahmoud Yusuf - 100 Level","Ahmad Abba Datti - 200 Level","Mubarak Umar - 300 Level","Jamil Aliyu Galadanci - 400 Level"};

        phone = new String[] { "08183969048", "08183969048","08183969048", "08183969048",};

        email = new String[] { "shmuhammad.cs@buk.edu.ng", "shmuhammad.csc@buk.edu.ng", "asali.cs@buk.edu.ng","smtanimu.cs@buk.edu.ng"};

        photo= new int[] { R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image};

        map = new String[] {"http://maps.google.com/?q=11.975051,8.424818&hl=en&gl=gb","http://maps.google.com/?q=11.975236,8.425386&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975103,8.424858&hl=en&gl=gb","http://maps.google.com/?q=11.975001,8.424775&hl=en&gl=gb"};


        // Locate the ListView in activity_search_lecturer.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < office.length; i++) {

            LPopulation p = new LPopulation(office[i], lecturers[i],
                    phone[i],email[i],map[i],photo[i]);
            // Binds all strings into an array
            arraylist.add(p);
        }

        // Pass results to DListViewAdapter Class
        adapter = new LListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });


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
