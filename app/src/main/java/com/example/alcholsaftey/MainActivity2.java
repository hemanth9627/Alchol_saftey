package com.example.alcholsaftey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity2 extends AppCompatActivity {
    Button add;
    AlertDialog dialog;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        add = findViewById(R.id.add);
        layout = findViewById(R.id.container);

        buildDialog();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        addCard("Farhan","Friend","6305656162");
        addCard("Karthika","Friend","9392836969");
        addCard("Hitesh","Friend","6303146386");

    }
    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog, null);

        final EditText name = view.findViewById(R.id.nameEdit);
        final EditText rel = view.findViewById(R.id.relEdit);
        final EditText phno = view.findViewById(R.id.mobEdit);

        builder.setView(view);
        builder.setTitle("Enter details")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addCard(name.getText().toString(),rel.getText().toString(),phno.getText().toString());
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        dialog = builder.create();
    }
    public void addCard(String name, String rel, String phno) {
        final View view = getLayoutInflater().inflate(R.layout.card, null);

        TextView nameView = view.findViewById(R.id.name);
        TextView relation = view.findViewById(R.id.rel);
        //TextView mobno = view.findViewById(R.id.mbno);
        Button delete = view.findViewById(R.id.delete);
        Button edit = view.findViewById(R.id.edit);

        nameView.setText(name);
        relation.setText(rel);
        //mobno.setText(phno);
        sender.add(name,rel,phno);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeView(view);sender.rem(name,phno);
            }
        });

        layout.addView(view);
    }

}