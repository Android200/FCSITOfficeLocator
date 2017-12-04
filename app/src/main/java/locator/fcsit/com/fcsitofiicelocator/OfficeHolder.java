package locator.fcsit.com.fcsitofiicelocator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import locator.fcsit.com.fcsitofiicelocator.Deanary.Deanary;
import locator.fcsit.com.fcsitofiicelocator.Exam_Officer.Exam_Officer;
import locator.fcsit.com.fcsitofiicelocator.HOD.HOD;
import locator.fcsit.com.fcsitofiicelocator.Level_Coord.Level_Coord;
import locator.fcsit.com.fcsitofiicelocator.Search_Lecuturers.Search_Lecturer;

public class OfficeHolder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_holder);
        String listnames[]={"Deanary","Head of Departments","Lecturers","Level Coordinator","Exam Officer"};

        ListView others = (ListView) findViewById(R.id.officeholder);
        others.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listnames));

        others.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        startActivity(new Intent(getApplicationContext(), Deanary.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), HOD.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), Search_Lecturer.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), Level_Coord.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), Exam_Officer.class));
                        break;

                }
            }
        });

    }
}
