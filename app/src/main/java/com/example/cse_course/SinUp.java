package com.example.cse_course;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SinUp extends AppCompatActivity {
    private EditText Sinup_Email,Sinup_Password;
    private Button Sinup_Button,Click_LoginButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Sinup_Email=findViewById(R.id.sinup_email);
        Sinup_Password=findViewById(R.id.sinup_passwword);
        Sinup_Button=findViewById(R.id.sinup_button);
        Click_LoginButton=findViewById(R.id.click_loginpbutton);

        mAuth = FirebaseAuth.getInstance();

        Sinup_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Sinup();
            }
        });
        Click_LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SinUp.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void Sinup() {
        String Email=Sinup_Email.getText().toString().trim();
        String Password=Sinup_Password.getText().toString().trim();

        if(Email.isEmpty()){
            Sinup_Email.setError("Enter Email");
            Sinup_Email.requestFocus();
            return;
        }
        if(Password.isEmpty()){
            Sinup_Password.setError("Enter Password");
            Sinup_Password.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            Sinup_Email.setError("Enter Valid Email Addres");
            Sinup_Email.requestFocus();
            return;
        }
        if (Password.length()<6) {
            Sinup_Password.setError("At least 6 Number");
            Sinup_Password.requestFocus();
        }


        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();
                            Intent intent=new Intent(SinUp.this,HomePage.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);

                        } else {
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(getApplicationContext(),"Already Sign in",Toast.LENGTH_SHORT).show();

                            }else {
                                Toast.makeText(getApplicationContext(),"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }


                        }

                    }
                });
    }
}