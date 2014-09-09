package com.drivemode.android.typeface.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.drivemode.android.typeface.TypefaceHelper;

/**
 * @author KeithYokoma
 */
public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Hoge").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Fuga").setTabListener(this));

        ListView lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, getResources().getStringArray(R.array.sample_list)) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TypefaceHelper.getInstance().setTypeface((TextView) view, "Isserley-Regular.ttf");
                return view;
            }
        });

        TypefaceHelper.getInstance().setTypeface(this, "Isserley-Regular.ttf");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}
}
