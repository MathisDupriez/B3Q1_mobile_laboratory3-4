package be.com.learn.adminsys.laboratoire3et4.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import be.com.learn.adminsys.laboratoire3et4.R;
import be.com.learn.adminsys.laboratoire3et4.models.Crime;
import be.com.learn.adminsys.laboratoire3et4.models.CrimeLab;

public class ManualCrimeListActivity extends AppCompatActivity {
    private LinearLayout mContainer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_crime_list);
        mContainer = (LinearLayout) findViewById(R.id.crime_list);
        updateUI();
    }
    private void updateUI() {
        mContainer.removeAllViews();
        CrimeLab lab = CrimeLab.get();
        for (final Crime crime : lab.getCrimes()) {
            View crimeView = getCrimeView(crime);
            mContainer.addView(crimeView);
        }
    }
    private View getCrimeView(Crime crime) {
        View columnForCrime = getLayoutInflater().inflate(R.layout.activity_list_item_crime, null);
        ((TextView) columnForCrime.findViewById(R.id.crime_title)).setText(crime.getTitle());
        ((TextView) columnForCrime.findViewById(R.id.crime_date)).setText(crime.getDate().toString());
        setClickOnCrimeView(crime, columnForCrime);
        return columnForCrime;
    }
    /*
     * Renvoie un TextView avec le texte text
     */
    private TextView getTextView(String text) {
        TextView textView = new TextView(getApplicationContext());
        textView.setText(text);
        textView.setLayoutParams(new FrameLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return textView;
    }
    private void setClickOnCrimeView(final Crime crime, View columnForCrime) {
        columnForCrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CrimeActivity.class);
                intent.putExtra(CrimerFragment.CRIME_ID, crime.getId());
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }
}

