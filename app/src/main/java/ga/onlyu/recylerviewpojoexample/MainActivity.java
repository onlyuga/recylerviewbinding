package ga.onlyu.recylerviewpojoexample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

import ga.onlyu.recylerviewpojoexample.databinding.ActivityMainBinding;
import ga.onlyu.recylerviewpojoexample.viewmodel.Item;
import ga.onlyu.recylerviewpojoexample.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        model = new MainViewModel(this);
        binding.setModel(model);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Item> data = Stream.range(1, 30)
                .map(m -> new Item(m, "ONLYU"))
                .collect(Collectors.toList());
        model.setData(data);
    }
}
