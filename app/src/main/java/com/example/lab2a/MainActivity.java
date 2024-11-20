package com.example.lab2a;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button;
    private CheckBox checkBox;
    private Switch switchWidget;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_linear); // You can switch between layouts here

        // Initialize views
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        checkBox = findViewById(R.id.checkbox);
        switchWidget = findViewById(R.id.switch_widget);
        imageButton = findViewById(R.id.imageButton);

        // Button click listener
        button.setOnClickListener(v -> {
            String inputText = editText.getText().toString();
            textView.setText(inputText);
            Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
        });

        // Checkbox change listener
        checkBox.setOnCheckedChangeListener((CompoundButton cb, boolean isChecked) -> {
            String state = isChecked ? getString(R.string.on) : getString(R.string.off);
            String message = getString(R.string.checkbox_status, state);

            Snackbar snackbar = Snackbar.make(cb, message, Snackbar.LENGTH_LONG);
            snackbar.setAction(getString(R.string.undo), click -> cb.setChecked(!isChecked));
            snackbar.show();
        });
    }
}