package sg.edu.rp.c346.id22015127.demodynamiclistviewcolourlist;

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

    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    Button btnRmv;
    Button btnChg;
    ListView lvColour;
    ArrayList<String> alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRmv = findViewById(R.id.buttonRemoveItem);
        btnChg = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);
        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");
        ArrayAdapter aaColour = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColor = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, newColor);
                lvColour.setAdapter(aaColour);
                aaColour.notifyDataSetChanged();
            }
        });
        btnRmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                lvColour.setAdapter(aaColour);
                aaColour.notifyDataSetChanged();
            }
        });
        btnChg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColor = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos, newColor);
                lvColour.setAdapter(aaColour);
                aaColour.notifyDataSetChanged();
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();

            }
        });
    }
}