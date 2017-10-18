package example.com.fragment.controllers;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import example.com.fragment.R;

/**
 * Created by muhammad.sohail on 10/17/2017.
 */

public class HelloFragment extends Fragment implements View.OnClickListener, SaveData {
    TextView helloTv;
    String txt = "";
    Button openFragment;
    SaveData saveData;
    FormFragment formFragment = new FormFragment();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hello_fragment, container, false);
        // Initializing UI components
        initUI(rootView);


        return rootView;
    }

    private void initUI(View view) {

        helloTv = (TextView) view.findViewById(R.id.hello);
        openFragment = (Button) view.findViewById(R.id.openFragment);
        openFragment.setOnClickListener(this);
        txt = getArguments().getString("text");
        helloTv.append(txt);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.openFragment:
                Bundle bundle = new Bundle();
                bundle.putString("dialog_fragment", "john");
                formFragment.setArguments(bundle);
                formFragment.setCallBack(this);
                getFragmentManager()
                        .beginTransaction()
                        .add(R.id.frame_container, formFragment
                        ).addToBackStack(null)
                        .commit();
                //   this.saveData.Save();
                //  this.getActivity().getFragmentManager().popBackStack();
                break;
        }
    }

    public void setCallBack(SaveData saveData) {
        this.saveData = saveData;
    }

    @Override
    public void Save() {
        Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Save(String name) {
        Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();

    }
}
