package com.mr.admin.scrolling_toolbarapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity {

    RecyclerView recyclerView_dataRV;
    TextView nameTV,castTV,emailTV,phoneTV,cityTV,countryTV;

    private Recycler_View_data adpter;
    ArrayList<Data_items> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView_dataRV=findViewById(R.id.recyclerView_dataRV);

        recyclerView_dataRV.setLayoutManager(new LinearLayoutManager(ScrollingActivity.this));
        adpter=new Recycler_View_data(ScrollingActivity.this,data);
        recyclerView_dataRV.setAdapter(adpter);
        recyclerView_dataRV.setHasFixedSize(true);
        recyclerView_dataRV.setItemAnimator(new DefaultItemAnimator());

        Data_Adpter();

    }

    private class Recycler_View_data extends RecyclerView.Adapter<RecyclerView.ViewHolder>
    {
        ArrayList<Data_items> data_list = new ArrayList<>();

        public Recycler_View_data(ScrollingActivity scrollingActivity, ArrayList<Data_items> data_list) {
            this.data_list = data_list;
        }

        private class ViewHolder extends RecyclerView.ViewHolder
        {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                nameTV=itemView.findViewById(R.id.nameTV);
                castTV=itemView.findViewById(R.id.castTV);
                emailTV=itemView.findViewById(R.id.emailTV);
                phoneTV=itemView.findViewById(R.id.phoneTV);
                cityTV=itemView.findViewById(R.id.cityTV);
                countryTV=itemView.findViewById(R.id.countryTV);

            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.data_item,viewGroup,false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            Data_items items=data_list.get(i);

            nameTV.setText(items.getName());
            castTV.setText(items.getCast());
            emailTV.setText(items.getEmail());
            phoneTV.setText(items.getPhone());
            cityTV.setText(items.getCity());
            countryTV.setText(items.getCountry());

        }

        @Override
        public int getItemCount() {
            return data_list.size();
        }
    }

    public void Data_Adpter()
    {
        Data_items data_items=new Data_items("ABC","DEF","hello@abc.com","12141554","New York","U.S.A.");
        data.add(data_items);

        data_items=new Data_items("ABCDEF","BABSBS","abva@asxsn.com","21466","California","U.S.A.");
        data.add(data_items);

        data_items=new Data_items("HELLO","HIII","hello@hiii.com","515462","San Fransisco","U.S.A.");
        data.add(data_items);

        data_items=new Data_items("HII","HELLO","hii@hello.com","2226262","New Delhi","India");
        data.add(data_items);

        data_items=new Data_items("QEDRQDQ","JYG","dsdkms@abc.com","51654856","London","U.K.");
        data.add(data_items);

        data_items=new Data_items("QWERTY","POU","qerty@abc.com","548754415","New York","U.S.A.");
        data.add(data_items);

        data_items=new Data_items("XCV","DEF","hello@abc.com","12141554","New York","U.S.A.");
        data.add(data_items);

        data_items=new Data_items("SDFGHJ","TYHHJKKL","dsadd@dsfrf.com","897655","Paris","France");
        data.add(data_items);

        data_items=new Data_items("NHJH","NNJNJB","sasa@abc.com","7416611313","Mumbai","India");
        data.add(data_items);

        data_items=new Data_items("OPKPJI","BJBB","sxksa@kokm.com","2156561","Bangaluru","India");
        data.add(data_items);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
