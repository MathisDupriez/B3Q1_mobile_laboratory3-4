package be.com.learn.adminsys.laboratoire3et4.controllers;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.UUID;

import be.com.learn.adminsys.laboratoire3et4.R;
import be.com.learn.adminsys.laboratoire3et4.models.Crime;
import be.com.learn.adminsys.laboratoire3et4.models.CrimeLab;

public class CrimerFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDatebutton;
    private CheckBox mSolvedCheckBox;
    public static final String CRIME_ID = "crime_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crime_id = (UUID) getActivity().getIntent().getSerializableExtra(CRIME_ID);
        mCrime = CrimeLab.get().getCrime(crime_id);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // inflate the fragment_crime view
        View v = inflater.inflate(R.layout.fragment_crime,container,false);

        // setting the textview
        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        //set the listener of the textFiled
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // do nothing
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
                // do nothing, everything’s done in onTextChanged
            }
        });

        //set the crime title
        mTitleField.setText(mCrime.getTitle());

        //the button date
        mDatebutton = (Button) v.findViewById(R.id.crime_date);
        //set the text of the button date
        mDatebutton.setText(mCrime.getDate().toString());
        //disable the button date
        mDatebutton.setEnabled(false); //readonly
        //set the checkbox

        mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
        //set the value of the checkbox if the crime is solved
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        //set the methode when something is done with the checkbox
        mSolvedCheckBox.setOnCheckedChangeListener(
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean
                        isChecked) {
                    mCrime.setSolved(isChecked);
                }
            }
        );
        return v;
    }
}
