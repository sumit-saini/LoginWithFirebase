package demo.com.loginwithfirebase;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import Animation.AnimationListener;
import Animation.ViewAnimator;

/**
 * Created by mobulous7 on 18/11/16.
 */

public class SwipeLVAdapter extends ArrayAdapter<String> implements View.OnClickListener{

    Context context;
    ViewHolder holder = null;
    Activity activity;
    public SwipeLVAdapter(Activity activity,Context context, int resourceId,ArrayList<String> objects) {
        super(context, resourceId, objects);
        this.context = context;
        this.activity=activity;
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()){
            case R.id.textView1:
                ViewAnimator.animate(v).rollOutLeft(activity).duration(3000).onStop(new AnimationListener.Stop() {
                    @Override
                    public void onStop() {
                        int pos=(Integer)v.getTag();
                        SwipeToDeleteListview.notifylist(pos);
                    }
                }).start();
                break;
        }
    }

    private class ViewHolder {
        TextView tv;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        String rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.swipe_lv_item, null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.textView1);
            holder.tv.setOnClickListener(this);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.tv.setText(rowItem);
        holder.tv.setTag(position);
        return convertView;
    }

}