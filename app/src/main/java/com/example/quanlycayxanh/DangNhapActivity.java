package com.example.quanlycayxanh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DangNhapActivity extends AppCompatActivity {
    EditText edtEmail, edtPass;
    Button btnDangNhap;
    TextView txtDangKy;
    FirebaseAuth mAuthencation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        mAuthencation = FirebaseAuth.getInstance();

        AnhXa();

        txtDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangNhap();
            }
        });
    }

    private void DangNhap () {
        String email = edtEmail.getText().toString();
        String pass = edtPass.getText().toString();
        mAuthencation.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(DangNhapActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(DangNhapActivity.this, ListSVActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(DangNhapActivity.this, "Tài khoản hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void AnhXa(){
        txtDangKy = findViewById(R.id.textViewDangKy);
        btnDangNhap = findViewById(R.id.buttonDangNhap);

        edtEmail = findViewById(R.id.editTextEmail_DangNhap);
        edtPass = findViewById(R.id.editTextPassword_DangNhap);
    }
}