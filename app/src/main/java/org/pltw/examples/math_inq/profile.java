package org.pltw.examples.math_inq;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 1005269 on 4/20/2017.
 */
public class profile extends AppCompatActivity {

    private String userEmail, name = "";
    private TextView Email;
    private String TAG = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(profile.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        /*
        userEmail = Backendless.UserService.CurrentUser().getEmail();

        for (int i=0; i<userEmail.length(); i++){
            if (userEmail.charAt(i) == '@')
                break;
            else
                name += userEmail.charAt(i);
        }

        Email = (TextView) findViewById(R.id.textView6);
        Email.setText(name);
    */
    }


    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(150,150));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.ic_group_black_24dp, R.drawable.ic_menu_camera,
                R.drawable.ic_menu_gallery, R.drawable.common_ic_googleplayservices,
                R.drawable.ic_menu_send, R.drawable.ic_menu_send,
        };
    }

}