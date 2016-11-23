package ga.onlyu.recylerviewpojoexample.viewmodel;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ga.onlyu.recylerviewpojoexample.BR;
import ga.onlyu.recylerviewpojoexample.R;
import ga.onlyu.recylerviewpojoexample.adapter.RecyclerBindingAdapter;
import ga.onlyu.recylerviewpojoexample.binding.RecyclerConfiguration;

/**
 * Created by K53SV on 11/22/2016.
 */

public class MainViewModel {
    private Context context;
    public final RecyclerConfiguration recyclerConfiguration = new RecyclerConfiguration();
    private RecyclerBindingAdapter<Item>
            adapter = new RecyclerBindingAdapter<>(R.layout.item_name, BR.item, new ArrayList<>());

    public MainViewModel(Context context) {
        this.context = context;
        initRecycler();
    }

    public void setData(List<Item> datas) {
        adapter.setItems(new ArrayList<>(datas));
    }

    private void initRecycler() {
        LinearLayoutManager layout = new LinearLayoutManager(context);
        recyclerConfiguration.setLayoutManager(layout);
        recyclerConfiguration.setItemAnimator(new DefaultItemAnimator());
        recyclerConfiguration.setItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                //do something
            }
        });

        recyclerConfiguration.setAdapter(adapter);
        adapter.setOnItemClickListener((position, item) -> {
            //do something
        });
    }

}
