package locator.fcsit.com.fcsitofiicelocator.Search_Lecuturers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import locator.fcsit.com.fcsitofiicelocator.R;

/**
 * Created by Umar Saidu Auna on 09/06/2017.
 */

public class ListViewAdapter extends BaseAdapter {
    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Population> populationlist = null;
    private ArrayList<Population> arraylist;

    public ListViewAdapter(Context context,
                           List<Population> populationlist) {
        mContext = context;
        this.populationlist = populationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Population>();
        this.arraylist.addAll(populationlist);
    }

    public class ViewHolder {
        TextView office;
        TextView lecturers;
        TextView phone;
        TextView email;
        TextView map;
        ImageView photo;
    }

    @Override
    public int getCount() {
        return populationlist.size();
    }

    @Override
    public Population getItem(int position) {
        return populationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.office = (TextView) view.findViewById(R.id.office);
            holder.lecturers = (TextView) view.findViewById(R.id.lecturers);
            holder.phone = (TextView) view.findViewById(R.id.phone);
            holder.email = (TextView) view.findViewById(R.id.emailitem);
            holder.map = (TextView)view.findViewById(R.id.maplist);
            // Locate the ImageView in listview_item.xml
            holder.photo = (ImageView) view.findViewById(R.id.photo);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.office.setText(populationlist.get(position).getOffice());
        holder.lecturers.setText(populationlist.get(position).getLecturer());
        holder.phone.setText(populationlist.get(position).getPhone());
        holder.email.setText(populationlist.get(position).getEmail());
        holder.map.setText(populationlist.get(position).getMap());
        // Set the results into ImageView
        holder.photo.setImageResource(populationlist.get(position).getPhoto());
        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to DSingleItemView Class
                Intent intent = new Intent(mContext, SingleItemView.class);
                // Pass all data officce
                intent.putExtra("office",(populationlist.get(position).getOffice()));
                // Pass all data lecturer
                intent.putExtra("lecturer",(populationlist.get(position).getLecturer()));
                // Pass all data phone
                intent.putExtra("phone",(populationlist.get(position).getPhone()));
                //pass all data email
                intent.putExtra("email",(populationlist.get(position).getEmail()));
                // Pass all data map
                intent.putExtra("map",(populationlist.get(position).getMap()));
                // Pass all data flag
                intent.putExtra("photo",(populationlist.get(position).getPhoto()));
                // Start DSingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        populationlist.clear();
        if (charText.length() == 0) {
            populationlist.addAll(arraylist);
        } else {
            for (Population p : arraylist) {
                if (p.getLecturer().toLowerCase(Locale.getDefault()).contains(charText)) {
                    populationlist.add(p);
                } else if (p.getPhone().toLowerCase(Locale.getDefault()).contains(charText)){
                    populationlist.add(p);
                } else if (p.getOffice().toLowerCase(Locale.getDefault()).contains(charText)){
                    populationlist.add(p);
                }
            }
        }
        notifyDataSetChanged();
    }
}
