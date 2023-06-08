package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name: Nguyen Duc Khoa", "Hospital Name: Cho Ray", "Exp : 10yrs", "Mobile No: 0989645371","800"},
                    {"Doctor Name: Le Trong Tien", "Hospital Name: Thong Nhat", "Exp : 12yrs", "Mobile No: 0916587536","900"},
                    {"Doctor Name: Do Phuc Khanh", "Hospital Name: Quan Y 175", "Exp : 8yrs", "Mobile No: 0996287354","600"},
                    {"Doctor Name: Pham Quang Khang", "Hospital Name: Dai Hoc Y Duoc", "Exp : 15yrs", "Mobile No: 0919264928","1200"},
                    {"Doctor Name: Vo Anh Tuong", "Hospital Name: Nhiet Doi", "Exp : 14yrs", "Mobile No: 0912387695","1000"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name: Truong Ba Dien", "Hospital Name: An Binh", "Exp : 10yrs", "Mobile No: 0989645371","800"},
                    {"Doctor Name: Le Tin", "Hospital Name: Binh Dan", "Exp : 12yrs", "Mobile No: 0916587536","900"},
                    {"Doctor Name: Do Minh An", "Hospital Name: Chan Thuong Chinh Hinh", "Exp : 8yrs", "Mobile No: 0996287354","600"},
                    {"Doctor Name: Nguyen Duc Anh", "Hospital Name: Da Lieu", "Exp : 15yrs", "Mobile No: 0919264928","1200"},
                    {"Doctor Name: Vo Trung Tin", "Hospital Name: Da Khoa Sai Gon", "Exp : 14yrs", "Mobile No: 0912387695","1000"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name: Nguyen Hoang Luan", "Hospital Name: Da Khoa Cu Chi", "Exp : 10yrs", "Mobile No: 0989645371","800"},
                    {"Doctor Name: Pham Quoc Cuong", "Hospital Name: Da Khoa Hoc Mon", "Exp : 12yrs", "Mobile No: 0916587536","900"},
                    {"Doctor Name: Nguyen Viet Tien", "Hospital Name: Da Khoa Thu Duc", "Exp : 8yrs", "Mobile No: 0996287354","600"},
                    {"Doctor Name: Cao Hoang Duc", "Hospital Name: Hung Vuong", "Exp : 15yrs", "Mobile No: 0919264928","1200"},
                    {"Doctor Name: Le Thong Thai", "Hospital Name: Mat", "Exp : 14yrs", "Mobile No: 0912387695","1000"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name: Nguyen Duy Nam", "Hospital Name: Nguyen Trai", "Exp : 10yrs", "Mobile No: 0989645371","800"},
                    {"Doctor Name: Nguyen Cao Tien", "Hospital Name: Nguyen Tri Phuong", "Exp : 12yrs", "Mobile No: 0916587536","900"},
                    {"Doctor Name: Nguyen Minh Khoa", "Hospital Name: Nhan Dan 115", "Exp : 8yrs", "Mobile No: 0996287354","600"},
                    {"Doctor Name: Do Sy Minh", "Hospital Name: Gia Dinh", "Exp : 15yrs", "Mobile No: 0919264928","1200"},
                    {"Doctor Name: Le Anh Vy", "Hospital Name: Nhi Dong 1", "Exp : 14yrs", "Mobile No: 0912387695","1000"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name: Nguyen Duc Khoa", "Hospital Name: Nhi Dong 2", "Exp : 10yrs", "Mobile No: 0989645371","800"},
                    {"Doctor Name: Le Trong Tien", "Hospital Name: Nhi Dong Thanh Pho", "Exp : 12yrs", "Mobile No: 0916587536","900"},
                    {"Doctor Name: Do Phuc Khanh", "Hospital Name: Pham Ngoc Thach", "Exp : 8yrs", "Mobile No: 0996287354","600"},
                    {"Doctor Name: Pham Quang Khang", "Hospital Name: Trung Vuong", "Exp : 15yrs", "Mobile No: 0919264928","1200"},
                    {"Doctor Name: Vo Anh Tuong", "Hospital Name: Cao Thang", "Exp : 14yrs", "Mobile No: 0912387695","1000"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewODTitle);
        btn = findViewById(R.id.buttonODBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}