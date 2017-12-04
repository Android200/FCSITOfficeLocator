package locator.fcsit.com.fcsitofiicelocator.Faculty_Facilities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Faculty_facilities extends AppCompatActivity {
    // Declare Variables
    ListView Flist;
    FListViewAdapter Fadapter;
    EditText Feditsearch;
    String[] Fnumber;
    String[] Fname;
    String[] Fmap;
    int[] Fphoto;
    ArrayList<FPopulation> arraylist = new ArrayList<FPopulation>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Generate sample data
        Fnumber = new String[] {"GF-1 (Ground Floor)","GF-2 (Ground Floor)","R1-12/13 (Ground Floor)","R1-0 (Ground Floor)","R1-0 (Ground Floor)",
                              "GF-3 (Ground Floor)","GF-4 (FCSIT)","R1-25 (First Floor)","FF-1 (First Floor)","FF-2 (First Floor)","R1-32 (First Floor)",
                              "FF-3 (First Floor)","FF-4 (First Floor)","R1-41 (First Floor)","R1-50 (Second Floor)","SF-1 (Second Floor)","SF-2 (Second Floor)",
                              "R1-53 (Second Floor)","SF-3 (Second Floor)","SF-4 (Second Floor)","R1-44 (Second Floor)","R2-06 (Ground Floor FCSIT Extension)",
                              "R2-18 (Ground Floor FCSIT Extension)","R2-20 (Ground Floor FCSIT Extension)","R2-15 (Ground Floor FCSIT Extension)","R3-01 (Ground Floor FCSIT Extension)",
                              "R3-02 (Ground Floor FCSIT Extension)","R4-01 (Ground Floor FCSIT Extension)","R4-02 (Ground Floor FCSIT Extension)","R4-03 (Ground Floor FCSIT Exttension",
                              "R4-04 (Ground Floor FCSIT Extension)"};

        Fname = new String[] {"Staff Rest Room","PG Female Rest Room","Software Engineering Research Lab","Staff Rest Room","UG Female Rest Room",
                                 "Faculty Store","CIT Theatre","Mobile Technology & Postgraduate Research Lab","Staff Rest Room","UG Female Rest Room",
                                 "Networking Lab II","Staff Rest Room","UG Male Rest Room","Networking Lab I","Postgraduate Class A","Staff Rest Room",
                                 "PG Male Rest Room","Conference Room","Staff Rest Room","UG Male Rest Room","Postgraduate Class B","Simulation Lab",
                                 "MSSN-FCSIT Office","NACOSS Secretariat","Theatre A","L3 Laboratory","L4 Laboratory","Lecture Room 1","Lecture Room 2",
                                 "Lecture Room 3","Lecture Room 4"};

        Fmap = new String[] {"http://maps.google.com/?q=11.975139,8.424898&hl=en&gl=gb","http://maps.google.com/?q=11.975139,8.424898&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.975094,8.425267&hl=en&gl=gb","http://maps.google.com/?q=11.974796,8.425323&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.974766,8.425302&hl=en&gl=gb","http://maps.google.com/?q=11.974845,8.425331&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.974810,8.424953&hl=en&gl=gb","http://maps.google.com/?q=11.975021,8.424795&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.975119,8.424871&hl=en&gl=gb","http://maps.google.com/?q=11.975135,8.424886&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.975103,8.425241&hl=en&gl=gb","http://maps.google.com/?q=11.974836,8.425281&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.974805,8.425260&hl=en&gl=gb","http://maps.google.com/?q=11.974758,8.425215&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.975037,8.424797&hl=en&gl=gb","http://maps.google.com/?q=11.975123,8.424875&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.975136,8.424886&hl=en&gl=gb","http://maps.google.com/?q=11.975105,8.425249&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.974839,8.425283&hl=en&gl=gb","http://maps.google.com/?q=11.974801,8.425275&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.974708,8.425192&hl=en&gl=gb","http://maps.google.com/?q=11.975251,8.425398&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.975443,8.425425&hl=en&gl=gb","http://maps.google.com/?q=11.975479,8.425473&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.975368,8.425488&hl=en&gl=gb","http://maps.google.com/?q=11.975449,8.426052&hl=en&gl=gb",
                                    "http://maps.google.com/?q=11.975527,8.426130&hl=en&gl=gb","","","",""};
        Fphoto = new int[] { R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image,
                R.drawable.image, R.drawable.image, R.drawable.image,R.drawable.image, R.drawable.image,
                R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image,R.drawable.image, R.drawable.image,
                R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image
                , R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image};

        // Locate the ListView in activity_search_lecturer.xml
        Flist = (ListView) findViewById(R.id.Flistview);

        for (int i = 0; i < Fnumber.length; i++) {

            FPopulation Fp = new FPopulation(Fnumber[i], Fname[i],
                    Fmap[i], Fphoto[i]);
            // Binds all strings into an array
            arraylist.add(Fp);
        }

        // Pass results to DListViewAdapter Class
        Fadapter = new FListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        Flist.setAdapter(Fadapter);

        // Locate the EditText in listview_main.xml
        Feditsearch = (EditText) findViewById(R.id.Fsearch);

        // Capture Text in EditText
        Feditsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = Feditsearch.getText().toString().toLowerCase(Locale.getDefault());
                Fadapter.Ffilter(text);
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
