package sg.edu.rp.c346.id20004713.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etInput;
    Button btnAdd;
    ListView lvColour;
    EditText etIndexElement;
    Button btnRemove;
    Button btnUpdate;

    ArrayList<String> alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        btnAdd = findViewById(R.id.btnAdd);
        lvColour = findViewById(R.id.lvColour);
        etIndexElement = findViewById(R.id.etPosition);
        btnRemove = findViewById(R.id.btnRemove);
        btnUpdate = findViewById(R.id.btnUpdate);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour  = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos - 1, input);
                aaColour.notifyDataSetChanged();
                etInput.setText("");
                etIndexElement.setText("");
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos - 1);
                aaColour.notifyDataSetChanged();
                etInput.setText("");
                etIndexElement.setText("");
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos - 1, input);
                aaColour.notifyDataSetChanged();
                etInput.setText("");
                etIndexElement.setText("");
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
                etIndexElement.setText("" + (position + 1));
            }
        });
    }
}