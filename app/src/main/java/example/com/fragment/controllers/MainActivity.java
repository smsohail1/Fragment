package example.com.fragment.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import example.com.fragment.R;

public class MainActivity extends AppCompatActivity {

    HelloFragment helloFragment = new HelloFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = new Bundle();
        bundle.putString("text", "world");
        helloFragment.setArguments(bundle);
        // helloFragment.setCallBack(this);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_container, helloFragment
                ).commit();
    }

//    @Override
//    public void Save() {
//        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
//    }
}
