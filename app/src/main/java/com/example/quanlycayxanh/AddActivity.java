package com.example.quanlycayxanh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    EditText txtTenKhoaHoc, txtTenThuongGoi, txtDacTinh, txtMauLa;
    Button btnBack, btnSave;
    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mData = FirebaseDatabase.getInstance().getReference();

        AnhXa();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add();
            }
        });
    }

    private void Add(){
        CayXanh cx = new CayXanh();
        cx.tenKhoaHoc = txtTenKhoaHoc.getText().toString();
        cx.tenThuongGoi = txtTenThuongGoi.getText().toString();
        cx.dacTinh = txtDacTinh.getText().toString();
        cx.mauLa = txtMauLa.getText().toString();

        mData.child("CayXanh").push().setValue(cx);
    }

    private void AnhXa(){
        txtTenKhoaHoc = findViewById(R.id.editTenKhoaHoc_AddOrEdit);
        txtTenThuongGoi = findViewById(R.id.editTenThuongGoi_AddOrEdit);
        txtDacTinh = findViewById(R.id.editDacTinh_AddOrEdit);
        txtMauLa = findViewById(R.id.editMauLa_AddOrEdit);
        btnBack = findViewById(R.id.buttonBack);
        btnSave = findViewById(R.id.buttonSave);
    }
}