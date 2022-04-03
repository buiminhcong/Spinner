package com.bmcong2k.spinner_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     private Spinner sp ;
     private RecyclerView recyclerView;
     private Button btnAdd, btnUpdate;
     private EditText edtTen, edtThoigian;
     private int[] imgs ={
             R.drawable.facebook_logo,
             R.drawable.github_logo,
             R.drawable.google_logo
     };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(this);
        sp.setAdapter(spinnerAdapter);

        List<Tour> tourList = new ArrayList<>();
        tourList.add(new Tour(R.drawable.google_logo, "Ha Noi- Ninh Binh", "2 ngay 3 dem"));

        TourAdapter adapter = new TourAdapter(tourList, MainActivity.this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtTen.getText().toString();
                String tg = edtThoigian.getText().toString();
                String i = sp.getSelectedItem().toString();
                int img  = R.drawable.facebook_logo;

                try {
                    img = imgs[Integer.parseInt(i)];
                    Tour t = new Tour(img, ten, tg);
                    adapter.addTour(t);

                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Nhap sai", Toast.LENGTH_SHORT).show();
                }


            }
        });

       adapter.setOnMyItemClickLister(new TourAdapter.OnMyItemClickLister() {
           @Override
           public void doSomething(int position) {
//                        btnAdd.setEnabled(false);
//                        btnUpdate.setEnabled(true);
                        Tour t = tourList.get(position);
                        int img_int = t.getImg();
                        for(int i=0; i<imgs.length; i++){
                            if(img_int == imgs[i])
                                sp.setSelection(i);
                        }
                        edtTen.setText(t.getTen());
                        edtThoigian.setText(t.getSogio());

           }
       });


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
    }

    private void initView() {
        sp = findViewById(R.id.spImg);
        recyclerView = findViewById(R.id.recycleview);
        btnAdd = findViewById(R.id.btnThem);
        btnUpdate = findViewById(R.id.btnSua);
        edtTen = findViewById(R.id.edt_ten);
        edtThoigian = findViewById(R.id.edt_thoigian);
    }
}