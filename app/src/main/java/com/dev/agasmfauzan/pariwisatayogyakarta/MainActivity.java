package com.dev.agasmfauzan.pariwisatayogyakarta;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dev.agasmfauzan.pariwisatayogyakarta.Model.Home;
import com.dev.agasmfauzan.pariwisatayogyakarta.Model.User;
import com.google.android.gms.common.internal.service.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {
    MaterialEditText usernamelogin,passwordlogin;

    MaterialEditText newusername,newpassword,newemail;
    Button btn_sign_up,btn_sign_in;

    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        database=FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        usernamelogin= (MaterialEditText) findViewById( R.id.edtusername );
        passwordlogin= (MaterialEditText) findViewById( R.id.edtpassword );

        btn_sign_in=(Button)findViewById( R.id.btn_sign_in );
        btn_sign_up=(Button)findViewById(R.id. btn_sign_up );

        btn_sign_up.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             showSignUpDialog();
            }
        } );
        btn_sign_in.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(usernamelogin.getText().toString(),passwordlogin.getText().toString());
            }
        } );
    }

    private void signIn(final String user, final String pwd) {
        users.addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child( user ).exists())
                {
                    if (!user.isEmpty())
                    {
                        User login = dataSnapshot.child( user ).getValue(User.class);
                        if (login.getPassword().equals( pwd ))
                        {
                            Intent landinghome = new Intent( MainActivity.this, Home.class );
                            com.dev.agasmfauzan.pariwisatayogyakarta.Common.Common.currentUser=login;
                            startActivity( landinghome );
                            finish();
                        }
                        else
                            Toast.makeText( MainActivity.this,"Salah Password",Toast.LENGTH_SHORT ).show();
                    }
                    else
                    {
                        Toast.makeText( MainActivity.this,"Silahkan Masukan Username!", Toast.LENGTH_SHORT ).show();
                    }
                }
                else
                    Toast.makeText( MainActivity.this,"User tidak ada!",Toast.LENGTH_SHORT ).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
    }

    private void showSignUpDialog() {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder( MainActivity.this );
        alertdialog.setTitle( "Sign Up" );
        alertdialog.setTitle( "Harap isi semua data" );

        LayoutInflater inflater=this.getLayoutInflater();
        View sign_up_layout = inflater.inflate( R.layout.sign_up,null );
        newusername= (MaterialEditText)sign_up_layout.findViewById( R.id.edtnewusername );
        newemail= (MaterialEditText) sign_up_layout.findViewById( R.id.edtnewemail );
        newpassword= (MaterialEditText)sign_up_layout.findViewById( R.id.edtnewpassword );

        alertdialog.setView(sign_up_layout);
        alertdialog.setIcon(R.drawable.ic_account);

        alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });
        alertdialog.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                final User user = new User( newusername.getText().toString(),
                        newpassword.getText().toString(),
                        newemail.getText().toString());
                users.addListenerForSingleValueEvent( new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child( user.getUsername()).exists())
                            Toast.makeText( MainActivity.this, "Username telah dipakai !", Toast.LENGTH_SHORT ).show();
                        else
                        {
                            users.child(user.getUsername()).setValue( user );
                            Toast.makeText( MainActivity.this,"Registrasi berhasil!", Toast.LENGTH_SHORT ).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                } );
                dialogInterface.dismiss();
            }
        } );
        alertdialog.show();
    }
}
