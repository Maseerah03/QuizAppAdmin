package com.example.quizappadmin.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizappadmin.QuestionActivity;
import com.example.quizappadmin.R;

public class GrideAdapter extends BaseAdapter {

    public int sets =0;
    private String category;
    private String key;

    private GridListener listener;

    public GrideAdapter(int sets,String category,String key,GridListener listener) {
        this.sets = sets;
        this.category = category;
        this.key = key;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return sets+1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view1;

        if(convertView==null) {

            view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sets,parent,false);

        }
        else {

            view1 = convertView;
        }

        if(position==0) {

            ((TextView)view1.findViewById(R.id.setName)).setText("+");

        }
        else {

            ((TextView)view1.findViewById(R.id.setName)).setText(String.valueOf(position));

        }

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(position==0){

                    listener.addSets();
                }
                else {

                    Intent intent = new Intent(parent.getContext(), QuestionActivity.class);
                    intent.putExtra("setNum",position);
                    intent.putExtra("categoryName",category);
                    parent.getContext().startActivity(intent);
                }
            }
        });

        return view1;
    }

    public interface GridListener{

        public void addSets();
    }


}
