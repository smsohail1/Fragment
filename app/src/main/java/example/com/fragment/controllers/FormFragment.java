package example.com.fragment.controllers;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import example.com.fragment.R;

/**
 * Created by muhammad.sohail on 10/17/2017.
 */

public class FormFragment extends Fragment implements View.OnClickListener {
    EditText nameET;
    TextView argTxt;
    Button closeBtn;
    SaveData saveData;
    String dialogTxt = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.form_fragment, container, false);
        // Initializing UI components
        initUI(rootView);


        return rootView;
    }

    private void initUI(View view) {
        nameET = (EditText) view.findViewById(R.id.nameET);
        argTxt = (TextView) view.findViewById(R.id.argTxt);
        closeBtn = (Button) view.findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(this);
        dialogTxt = getArguments().getString("dialog_fragment");
        argTxt.setText(dialogTxt);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.closeBtn:

                this.saveData.Save(nameET.getText().toString());
                this.getActivity().getFragmentManager().popBackStack();
                break;
        }
    }

    public void setCallBack(SaveData saveData) {
        this.saveData = saveData;
    }
}
