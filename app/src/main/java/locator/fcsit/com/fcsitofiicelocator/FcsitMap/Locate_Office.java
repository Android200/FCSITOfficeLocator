package locator.fcsit.com.fcsitofiicelocator.FcsitMap;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import locator.fcsit.com.fcsitofiicelocator.R;

public class Locate_Office extends FragmentActivity implements OnMapReadyCallback {
    private AutoCompleteTextView actv;
    private List<MyItem> items = new ArrayList<>();
    private List<String> offices = new ArrayList<>();
    private String m;
    private ArrayList<getmarkerfromstring> users=new ArrayList<>();
    private GoogleMap mMap;
    FrameLayout snack;
    private static final int REQUEST_CALL_LOCATION = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate__office);
        int permission = ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    Locate_Office.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CALL_LOCATION);
        }
        actv=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        actv.setDropDownBackgroundResource(R.color.stroke_color);
        LocationRequest mlocationrequest = new LocationRequest();
        mlocationrequest.setInterval(1000);
        mlocationrequest.setFastestInterval(1000);
        mlocationrequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    private void initCamera() {
        CameraPosition position = CameraPosition.builder()
                .target(new LatLng(11.975145,8.425210))
                .zoom(18f)
                .bearing(0.0f)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(position), null);

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setTrafficEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);

        try {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
            mMap.getUiSettings().setMapToolbarEnabled(true);
        }
        catch (SecurityException e)
        {
            Log.d("Security exception","location not enabled");
            Toast.makeText(getApplicationContext(),"Locaton not Enabled",Toast.LENGTH_SHORT).show();
        }

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    private void setUpMap() {
        initCamera();
        final ClusterManager<MyItem> mClusterManager = new ClusterManager<>(getApplicationContext(), mMap);
        mMap.setOnCameraIdleListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        mClusterManager
                .setOnClusterClickListener(new ClusterManager.OnClusterClickListener<MyItem>() {
                    @Override
                    public boolean onClusterClick(final Cluster<MyItem> cluster) {
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                cluster.getPosition(), (float) Math.floor(mMap
                                        .getCameraPosition().zoom + 2)), 300,
                                null);

                        return true;
                    }
                });
        try {
            InputStream inputstream = getResources().getAssets().open("map.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
            m = reader.toString();
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line);
            }
            m = total.toString();
        } catch (IOException ex) {
            Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
        }
        new Thread(){
            @Override
            public void run() {


                try {
                    JSONObject jsonObject = new JSONObject(m);
                    JSONArray jsonArray = jsonObject.optJSONArray("map");
                    int arraylength = jsonArray.length();

                    for (int i = 0; i < arraylength; i++) {

                        JSONObject jsonChildNode = jsonArray.getJSONObject(i);
                        String title = jsonChildNode.optString("title");
                        String subtitle = jsonChildNode.optString("subtitle");
                        String floor = jsonChildNode.optString("floor");
                        double lat1 = jsonChildNode.optDouble("latitude");
                        double lng1 = jsonChildNode.optDouble("longitude");
                        items.add(new MyItem(lat1, lng1, title, subtitle, floor) {
                            @Override
                            public String getSnippet() {
                                return null;
                            }
                        });
                        offices.add(title);
                        offices.add(subtitle);
                        getmarkerfromstring user = new getmarkerfromstring();
                        user.setLat(lat1);
                        user.setLng(lng1);
                        user.setName(title);
                        users.add(user);
                        getmarkerfromstring user2 = new getmarkerfromstring();
                        user2.setLat(lat1);
                        user2.setLng(lng1);
                        user2.setName(subtitle);
                        users.add(user2);

                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mClusterManager.addItems(items);
                            mClusterManager.setRenderer(new MyClusterRenderer(getApplicationContext(), mMap, mClusterManager));
                            mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItem>() {
                                @Override
                                public boolean onClusterItemClick(MyItem myItem) {
                                    Toast.makeText(getApplicationContext(), myItem.getfloor() + " Floor",Toast.LENGTH_SHORT).show();

                                    return false;
                                }
                            });
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        ArrayAdapter<String> adapter= new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item,offices);
        actv.setAdapter(adapter);

        actv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Location when user clicks the autocomplete
                actv.setText("");
            }
        });

        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                //... your stuff
                View scene = Locate_Office.this.getCurrentFocus();
                if (scene != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(scene.getWindowToken(), 0);
                }
                String s=parent.getItemAtPosition(position).toString();
                int pos= offices.indexOf(s);
                LatLng lng=new LatLng(users.get(pos).getLat(),users.get(pos).getLng());
                mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lng,(float)Math.floor(mMap.getCameraPosition().zoom+8)));
            }
        });

    }
    @Override
    public void onMapReady(GoogleMap map) {
        if (map != null) {
            mMap = map;
            setUpMap();
        }
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
        mMap.setIndoorEnabled(true);

    }
}
