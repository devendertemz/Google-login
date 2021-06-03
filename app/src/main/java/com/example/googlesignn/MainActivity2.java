package com.example.googlesignn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity2 extends AppCompatActivity {


GoogleSignInClient mGoogleSignInClient;
    Button signout;
    TextView personName,personGivenName,personFamilyName,personEmail,personId;
    ImageView personPhoto;


    String personNamee = "",personGivenNamee = "",personFamilyNamee = "",personEmaill = "",personIdd = "",personPhotoo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        signout=findViewById(R.id.signout);
        personName=findViewById(R.id.personName);
        personGivenName=findViewById(R.id.personGivenName);
        personFamilyName=findViewById(R.id.personFamilyName);
        personEmail=findViewById(R.id.personEmail);
        personId=findViewById(R.id.personId);
        personPhoto=findViewById(R.id.personPhoto);
        if (getIntent()!=null)
        {
            personNamee=getIntent().getExtras().getString("personName");
            personGivenNamee=getIntent().getExtras().getString("personGivenName");
            personFamilyNamee=getIntent().getExtras().getString("personFamilyName");
            personEmaill=getIntent().getExtras().getString("personEmail");
            personIdd=getIntent().getExtras().getString("personId");
            personPhotoo=getIntent().getExtras().getString("personPhoto");



            personName.setText(personNamee);
            personGivenName.setText(personGivenNamee);
            personFamilyName.setText(personFamilyNamee);
            personEmail.setText(personEmaill);
            personId.setText(personIdd);
            try {

                  Toast.makeText(this, personPhotoo.toString()+"", Toast.LENGTH_SHORT).show();
                Log.d("personPhotoo: ",personPhotoo);
                personPhoto.setImageURI(Uri.parse(personPhotoo));
                //   personPhoto.setImageBitmap();


            }catch (Exception e)
            {

            }
        }


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOutt();

            }
        });
    }
    private void signOutt() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(MainActivity2.this, "Logout", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
    }
}