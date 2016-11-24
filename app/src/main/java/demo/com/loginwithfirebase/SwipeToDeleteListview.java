package demo.com.loginwithfirebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import Animation.AnimationListener;
import Animation.ViewAnimator;

/**
 * Created by mobulous7 on 18/11/16.
 */

public class SwipeToDeleteListview extends AppCompatActivity{

    static SwipeLVAdapter adapter;
    static ListView listView;
    static ArrayList<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_listview);
        for (int i=0;i<12;i++){
            list.add("hello "+i);
        }
        init();
    }

    private void init() {
        listView =(ListView)findViewById(R.id.lv_list1);
        adapter = new SwipeLVAdapter(this,this, R.layout.swipe_lv_item, list);
        listView.setAdapter(adapter);
    }

    public static void notifylist(int pos){
        ArrayList<String> list2=new ArrayList<String>();
        for (int i=0;i<list.size();i++){
            if(i!=pos)
                list2.add(list.get(i));
        }
    }
}
