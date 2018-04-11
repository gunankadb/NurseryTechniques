package com.treepedia.meghalaya.nurserytechniques;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.treepedia.meghalaya.nurserytechniques.R;

import java.util.ArrayList;

public class DisplayActivity extends Activity {
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        final ArrayList<String> selected_tree = getIntent().getStringArrayListExtra("selected_tree");

        try{
            final ListView lv_display = (ListView) findViewById(R.id.lv_display);
            mImageView = (ImageView) findViewById(R.id.imageViewId);
            final String imageID = "i"+ (String)selected_tree.toArray()[0] ;
            mImageView.setImageResource(getResources().getIdentifier(imageID, "drawable", getPackageName()));

            final String[] headings = Constant.TREE_FIELDS ;
            //headings[TREE_FIELDS_COUNT];
            try
            {
                final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, selected_tree)
                {
                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                        // Get the current item from ListView
                        View view = super.getView(position, convertView, parent);
                        // Initialize a TextView for ListView each Item
                        TextView tv1 = (TextView) view.findViewById(android.R.id.text1);
                        TextView tv2 = (TextView) view.findViewById(android.R.id.text2);
                    if (position < Constant.TREE_FIELDS_COUNT )
                    {
                        final String tree_test = (String) selected_tree.toArray()[1];
                        if (tree_test.contains ("Nursery"))
                        {
                            tv1.setText(" ");
                            if (position != 0) {
                                tv2.setText((String) selected_tree.toArray()[position]);
                            }
                        }
                        else
                        {
                            tv1.setText(headings[position]);
                            tv2.setText((String) selected_tree.toArray()[position]);
                        }
                    }
                    else
                    {
                        tv1.setText("");
                        tv2.setText("");
                    }
                    // Generate ListView Item using TextView
                    tv1.setTextColor(Color.parseColor(Constant.TEXT_FONT_COLOR));
                    tv2.setTextColor(Color.BLACK);
                    return view;
                };
                };
                // DataBind ListView with items from ArrayAdapter
                lv_display.setAdapter(arrayAdapter);
            }catch(Exception e){
                System.out.println(e);
                // Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            System.out.println(e);
            // Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
        }

    }
}
