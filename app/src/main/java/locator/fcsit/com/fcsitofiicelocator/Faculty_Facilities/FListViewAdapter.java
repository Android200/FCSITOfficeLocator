package locator.fcsit.com.fcsitofiicelocator.Faculty_Facilities;

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
 * Created by Umar Saidu Auna on 11/06/2017.
 */

public class FListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<FPopulation> Fpopulationlist = null;
    private ArrayList<FPopulation> arraylist;

    public FListViewAdapter(Context context,List<FPopulation> Fpopulationlist) {
        mContext = context;
        this.Fpopulationlist = Fpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<FPopulation>();
        this.arraylist.addAll(Fpopulationlist);
    }

    public class ViewHolder {
        TextView Fnumber;
        TextView Fname;
        TextView Fmap;
        ImageView Fphoto;
    }

    @Override
    public int getCount() {
        return Fpopulationlist.size();
    }

    @Override
    public FPopulation getItem(int position) {
        return Fpopulationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final FListViewAdapter.ViewHolder holder;
        if (view == null) {
            holder = new FListViewAdapter.ViewHolder();
            view = inflater.inflate(R.layout.flistview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.Fnumber = (TextView) view.findViewById(R.id.fnumber);
            holder.Fname = (TextView) view.findViewById(R.id.fname);
            holder.Fmap = (TextView) view.findViewById(R.id.fmap);
            // Locate the ImageView in listview_item.xml
            holder.Fphoto = (ImageView) view.findViewById(R.id.fphoto);
            view.setTag(holder);
        } else {
            holder = (FListViewAdapter.ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.Fnumber.setText(Fpopulationlist.get(position).getFnumber());
        holder.Fname.setText(Fpopulationlist.get(position).getFname());
        holder.Fmap .setText(Fpopulationlist.get(position).getFMap());
        // Set the results into ImageView
        holder.Fphoto.setImageResource(Fpopulationlist.get(position).getFPhoto());
        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Send single item click data to FSingleItemView Class
                Intent intent = new Intent(mContext, FSingleItemView.class);
                // Pass all data Facility number
                intent.putExtra("fnumber",(Fpopulationlist.get(position).getFnumber()));
                // Pass all data Facility name
                intent.putExtra("fname",(Fpopulationlist.get(position).getFname()));
                // Pass all data Facility map
                intent.putExtra("fmap",(Fpopulationlist.get(position).getFMap()));
                // Pass all data Facility Photo
                intent.putExtra("fphoto",(Fpopulationlist.get(position).getFPhoto()));
                // Start DSingleItemView Class
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    // Filter Class
    public void Ffilter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        Fpopulationlist.clear();
        if (charText.length() == 0) {
            Fpopulationlist.addAll(arraylist);
        } else {
            for (FPopulation Fp : arraylist) {
                if (Fp.getFname().toLowerCase(Locale.getDefault()).contains(charText)) {
                    Fpopulationlist.add(Fp);
                } else if (Fp.getFMap().toLowerCase(Locale.getDefault()).contains(charText)){
                    Fpopulationlist.add(Fp);
                } else if (Fp.getFnumber().toLowerCase(Locale.getDefault()).contains(charText)){
                    Fpopulationlist.add(Fp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
