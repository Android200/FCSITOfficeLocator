package locator.fcsit.com.fcsitofiicelocator.Search_Lecuturers;

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

public class Search_Lecturer extends AppCompatActivity {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] office;
    String[] lecturers;
    String[] phone;
    String[] email;
    String[] map;
    int[] photo;
    ArrayList<Population> arraylist = new ArrayList<Population>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__lecturer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Generate sample data
        office = new String[] {"R1-01 (Ground Floor)","R1-02 (Ground Floor)","R1-03 (Ground Floor)","R1-04 (Ground Floor)","R1-05 (Ground Floor)","R1-06 (Ground Floor)","R1-08 (Ground Floor)","R1-09 (Ground Floor)",
                             "R1-10 (Ground Floor)","R1-11 (Ground Floor)","R1-14 (Ground Floor)","R1-16 (Ground Floor)","R1-17 (Ground Floor)","R1-18 (Ground Floor)","R1-19 (Ground Floor)","R1-20 (Ground Floor)",
                             "R1-21 (Ground Floor)","R1-22 (Ground Floor)","R1-23 (Ground Floor)","R1-24 (First Floor)","R1-26 (First Floor)","R1-27 (First Floor)","R1-28 (First Floor)","R1-29 (First Floor)",
                             "R1-30 (First Floor)","R1-35 (First Floor)","R1-36 (First Floor)","R1-37 (First Floor)","R1-38 (First Floor)","R1-39 (First Floor)","R1-40 (First Floor)","R1-42 (First Floor)","R1-46 (Second Floor)",
                             "R1-47 (Second Floor)","R1-48 (Second Floor)","R1-49 (Second Floor)","R1-50 (Second Floor)","R1-51 (Second Floor)","R1-52 (Second Floor)","R1-54 (Second Floor)","R1-55 (Second Floor)","R1-56 (Second Floor)",
                             "R1-57 (Second Floor)","R1-58 (Second Floor)","R1-59 (Second Floor)","R1-61 (Second Floor)","R2-05 (Ground Floor FCSIT Extention)","R2-32 (First Floor FCSIT Extention)"};

        lecturers = new String[] {"Shamsuddeen Hassan Muhammad","Misbahu Sariffudeen","Kabir Umar","Muhammad Hassan","Rasheed Abubakar Rasheed","Maryam Ibrahim Mukhtar","Saratu Yusuf Ilu",
                                "Secretary Software Engineering","Bashir Shehu Galadanci","Abdulrazaq Hassan Abba","Abbullahi Baffa","Hafsat Kabir Ahmed","Auwal Shehu Ali","Murja Sani Gadanya",
                                "Mubarak Umar","Khalid Haruna","Mahmoud Yusuf","Bello Shehu Bello","Sagir Tanimu Musa","Jamil Aliyu Galadanci","Salisu Barodo","Hadiza Kabir Umar","Aminu Bello Usman",
                                "Naima Hafiz Abubakar","Muhammad Yahuza Bello","HOD, Information Technology","Secretary, Information Technology","Asst. Prof. Abdulwahab Lawan","Mustapha Abubakar Ahmed",
                                "Jafar Zubairu Maitama","Ibrahim Sadiq Ahmad","Sadiq Muhammad","Deputy Dean","Examination Office","Faculty Officer","Dean FCSIT","Secretary FCSIT","Sub-Dean Academic","Sub Dean Facilities",
                                "HOD Computer Science","Secretary, Computer Science","Habiba Kakudi","Baffa Sani","Sana Abdullahi Mu'az","Mansur Babagana","David Airehrour","Ahmad Abba Datti","Saminu Aliyu"};

        phone = new String[] { "08183969048", "08183969048",
                "08183969048", "08183969048", "08183969048", "08183969048","08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048",
                "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048",
                "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048"
                , "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048", "08183969048"};

        email = new String[] { "shmuhammad.cs@buk.edu.ng", "shmuhammad.csc@buk.edu.ng", "asali.cs@buk.edu.ng",
                "smtanimu.cs@buk.edu.ng", "shmuhammad.csc@buk.edu.ng", "asali.cs@buk.edu.ng","smtanimu.cs@buk.edu.ng", "shmuhammad.csc@buk.edu.ng",
                "asali.cs@buk.edu.ng", "smtanimu.cs@buk.edu.ng", "smtanimu.cs@buk.edu.ng", "smtanimu.cs@buk.edu.ng",
                "smtanimu.cs@buk.edu.ng", "smtanimu.cs@buk.edu.ng", "smtanimu.cs@buk.edu.ng", "smtanimu.cs@buk.edu.ng","smtanimu.cs@buk.edu.ng", "smtanimu.cs@buk.edu.ng",
                "smtanimu.cs@buk.edu.ng","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com"
                ,"smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com"
                ,"smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com"
                ,"smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com","smttanimu@gmail.com"};

        photo= new int[] { R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image,
                R.drawable.image, R.drawable.image, R.drawable.image,R.drawable.image, R.drawable.image,
                R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image,R.drawable.image, R.drawable.image,
                R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image
                , R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image
                , R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image
                , R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image};

        map = new String[] {"http://maps.google.com/?q=11.974661,8.425187&hl=en&gl=gb","http://maps.google.com/?q=11.974677,8.425216&hl=en&gl=gb","http://maps.google.com/?q=11.974709,8.425241&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.974726,8.425257&hl=en&gl=gb","http://maps.google.com/?q=11.974748,8.425289&hl=en&gl=gb","http://maps.google.com/?q=11.974827,8.425335&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.974999,8.425296&hl=en&gl=gb","http://maps.google.com/?q=11.975034,8.425310&hl=en&gl=gb","http://maps.google.com/?q=11.975095,8.425284&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975177,8.425096&hl=en&gl=gb","http://maps.google.com/?q=11.975175,8.425068&hl=en&gl=gb","http://maps.google.com/?q=11.975145,8.424944&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975146,8.424922&hl=en&gl=gb","http://maps.google.com/?q=11.975103,8.424858&hl=en&gl=gb","http://maps.google.com/?q=11.975075,8.424836&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975051,8.424818&hl=en&gl=gb","http://maps.google.com/?q=11.975026,8.424793&hl=en&gl=gb","http://maps.google.com/?q=11.975001,8.424775&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975001,8.424775&hl=en&gl=gb","http://maps.google.com/?q=11.975108,8.424861&hl=en&gl=gb","http://maps.google.com/?q=11.975139,8.424911&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975154,8.424945&hl=en&gl=gb","http://maps.google.com/?q=11.975168,8.425048&hl=en&gl=gb","http://maps.google.com/?q=11.975169,8.425078&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975050,8.425282&hl=en&gl=gb","http://maps.google.com/?q=11.975037,8.425279&hl=en&gl=gb","http://maps.google.com/?q=11.975003,8.425279&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.974899,8.425284&hl=en&gl=gb","http://maps.google.com/?q=11.974865,8.425280&hl=en&gl=gb","http://maps.google.com/?q=11.974783,8.425233&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.974695,8.425171&hl=en&gl=gb","http://maps.google.com/?q=11.974853,8.425285&hl=en&gl=gb","http://maps.google.com/?q=11.974893,8.425291&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.974977,8.425289&hl=en&gl=gb","http://maps.google.com/?q=11.974998,8.425287&hl=en&gl=gb","http://maps.google.com/?q=11.975032,8.425288&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975082,8.425269&hl=en&gl=gb","http://maps.google.com/?q=11.975095,8.425256&hl=en&gl=gb","http://maps.google.com/?q=11.975181,8.425121&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975176,8.425075&hl=en&gl=gb","http://maps.google.com/?q=11.975172,8.425044&hl=en&gl=gb","http://maps.google.com/?q=11.975165,8.424937&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975151,8.424906&hl=en&gl=gb","http://maps.google.com/?q=11.975107,8.424844&hl=en&gl=gb","http://maps.google.com/?q=11.975006,8.424770&hl=en&gl=gb",
                            "http://maps.google.com/?q=11.975006,8.424770&hl=en&gl=gb","http://maps.google.com/?q=11.975236,8.425386&hl=en&gl=gb","http://maps.google.com/?q=11.975457,8.425687&hl=en&gl=gb"};


        // Locate the ListView in activity_search_lecturer.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < office.length; i++) {

            Population p = new Population(office[i], lecturers[i],
                    phone[i],email[i],map[i],photo[i]);
            // Binds all strings into an array
            arraylist.add(p);
        }

        // Pass results to DListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

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
