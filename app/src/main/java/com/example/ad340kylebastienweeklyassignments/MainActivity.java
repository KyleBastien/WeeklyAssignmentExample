package com.example.ad340kylebastienweeklyassignments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener {

    private EditText nameField;
    private EditText emailAddressField;
    private EditText usernameField;
    private TextView dobTextView;
    private int dobYear = 0;
    private int dobMonth = 0;
    private int dobDay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.nameField);
        emailAddressField = findViewById(R.id.emailAddress);
        usernameField = findViewById(R.id.username);
        dobTextView = findViewById(R.id.selectedDateOfBirth);
    }

    public void onSubmit(View view) {
        String name = nameField.getText().toString();
        String emailAddress = emailAddressField.getText().toString();
        String username = usernameField.getText().toString();

        if (name.equals("") || emailAddress.equals("") || username.equals("") || dobYear == 0 || dobMonth == 0 || dobDay == 0) {
            // empty strings are not valid form input show a Toast to the user
            Toast.makeText(getApplicationContext(), getString(R.string.forgot_data_error), Toast.LENGTH_LONG).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            Toast.makeText(getApplicationContext(), getString(R.string.email_address_error), Toast.LENGTH_LONG).show();
            return;
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(dobYear, dobMonth, dobDay);
        int years = Period.between(dateOfBirth, currentDate).getYears();

        if (years < 18) {
            Toast.makeText(getApplicationContext(), getString(R.string.eighteen_error), Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
        intent.putExtra(Constants.USERNAME_KEY, username);
        startActivity(intent);
    }

    public void onDobClick(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constants.SELECTED_DOB, dobTextView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.SELECTED_DOB)) {
            dobTextView.setText(savedInstanceState.getString(Constants.SELECTED_DOB));
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        nameField.setText("");
        usernameField.setText("");
        emailAddressField.setText("");
        dobTextView.setText("");
        dobYear = 0;
        dobDay = 0;
        dobMonth = 0;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        month = month + 1;
        dobYear = year;
        dobMonth = month;
        dobDay = day;
        dobTextView.setText(getString(R.string.date, month, day, year));
    }

    public static class DatePickerFragment extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), (MainActivity) getActivity(), year, month, day);
        }
    }
}