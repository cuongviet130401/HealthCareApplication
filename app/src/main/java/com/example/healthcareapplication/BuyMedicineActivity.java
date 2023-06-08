package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Uprise-D3 1000IU Capsule", "","","","50"},
                    {"HealthVit Chomium","","","", "200"},
                    {"Dolo 535 Tablet", "","","","343"},
                    {"Feronia -XT Tablet", "","","","223"},
                    {"Croin 242 Advance Tablet", "","","","120"},
            };

    private String[] package_details ={
            "Uprise-D3 1000IU Capsule is a Vitamin D supplement.\n" +
                    "It's used to prevent or treat Vitamin D deficiency, contributing to healthy bones and teeth.\n" +
                    "It's used to prevent or treat Vitamin D deficiency, contributing to healthy bones and teeth.",
            "It's used to prevent or treat Vitamin D deficiency, contributing to healthy bones and teeth.\n" +
                    "It's known to assist in metabolism and storage of carbohydrates, fats, and proteins in the body. \n" +
                    " Each bottle contains 200 units.",
            "Dolo 535 Tablet is a medicine for pain relief.\n" +
                    "It can help alleviate symptoms in conditions like fever, headache, or muscle pain.\n" +
                    "Each package contains 343 tablets, ensuring plentiful supply for pain management.",
            "Feronia -XT Tablet is an iron supplement.\n" +
                    "It is commonly used to treat or prevent anemia by helping the body produce healthy red blood cells.\n" +
                    "Each package contains 223 tablets, aiding in consistent iron supplementation.",
            "Feronia -XT Tablet is an iron supplement.\n" +
                    "It is commonly used to treat or prevent anemia by helping the body produce healthy red blood cells.\n" +
                    "Each package contains 223 tablets, aiding in consistent iron supplementation."
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button bntBack, bntGoToCart;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        bntBack = findViewById(R.id.buttonBMBack);
        bntGoToCart = findViewById(R.id.buttonBMGoToCart);

        bntGoToCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent( BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        bntBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent( BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0; i < packages.length; i++){
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:" + packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}