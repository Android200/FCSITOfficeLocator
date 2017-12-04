package locator.fcsit.com.fcsitofiicelocator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import locator.fcsit.com.fcsitofiicelocator.Faculty_Facilities.Faculty_facilities;
import locator.fcsit.com.fcsitofiicelocator.FcsitMap.Locate_Office;
import locator.fcsit.com.fcsitofiicelocator.Search_Lecuturers.Search_Lecturer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<grid_model> list = getList();

        final CustomAdapter adapter = new CustomAdapter(this, R.layout.grid_model, list);

        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = null;
                if (position == 0) {
                    myIntent = new Intent(MainActivity.this,Locate_Office.class);
                }else if(position == 1){
                    myIntent = new Intent(MainActivity.this,OfficeHolder.class);
                }else if(position ==2){
                    myIntent = new Intent(MainActivity.this,Faculty_facilities.class);
                }else if(position == 3){
                    myIntent = new Intent(MainActivity.this,FCSIT_staffs.class);
                }
                startActivity(myIntent);
            }
        });
    }

    public ArrayList<grid_model> getList() {
        ArrayList<grid_model> list = new ArrayList<grid_model>();
        list.add(new grid_model("Locate Office", R.drawable.locate_offices));
        list.add(new grid_model("Search Lecturers", R.drawable.search_lecturers));
        list.add(new grid_model("Faculty Facilities", R.drawable.facility));
        list.add(new grid_model("FCSIT Staffs", R.drawable.abouts));

        return list;
    }
    class CustomAdapter extends ArrayAdapter<grid_model> implements ListAdapter {

        private LayoutInflater inflater;

        private int resource;

        public CustomAdapter(Context context, int resource, List<grid_model> data) {
            super(context, resource, data);
            inflater = LayoutInflater.from(context);
            this.resource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(resource, parent, false);
            }

            grid_model itempos = getItem(position);

            TextView tv = (TextView) convertView.findViewById(R.id.tv_test);
            tv.setText(itempos.name);

            ImageView iv = (ImageView) convertView.findViewById(R.id.iv_image);
            iv.setImageResource(itempos.drawableRes);

            return convertView;
        }

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
                AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
                alertbox.setTitle("FCSIT Office Locator");
                alertbox.setIcon(R.drawable.umaricon);
                alertbox.setMessage("Umar Saidu Auna\n\nCST/14/COM/01097\n\nComputer Science");
                alertbox.setCancelable(false);
                alertbox.setNeutralButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertbox.setNegativeButton("Close", null);
                alertbox.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
