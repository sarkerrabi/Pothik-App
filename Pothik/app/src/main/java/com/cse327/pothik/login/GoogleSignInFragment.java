package com.cse327.pothik.login;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cse327.pothik.MainActivity;
import com.cse327.pothik.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import static android.content.ContentValues.TAG;


public class GoogleSignInFragment extends Fragment implements View.OnClickListener {

    private final int GOOGLE_SIGN_IN_REQUEST_CODE =0;
    private final String WEB_CLIENT_ID = "341057443761-acaitauo9uvf4mj3m1hdkpkfhh5an7ei.apps.googleusercontent.com";


    SignInButton signInButton;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private GoogleApiClient mGoogleApiClient; // for google sign in

    public GoogleSignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_google_sign_in, container, false);
        initFBAuthentication();
       // initFBAuthState();
        initFBGoogleSignIn();

        signInButton = view.findViewById(R.id.sign_in_button);

        signInButton.setOnClickListener(this);






        return view;
    }
    private void initFBAuthentication() {
//        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthStateListener != null) {
//            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    //    mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_button:
                signIn();
                break;

        }
    }

    private void signOut() {
        if (mFirebaseAuth != null) {
//            mFirebaseAuth.signOut();
        }

    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, GOOGLE_SIGN_IN_REQUEST_CODE);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GOOGLE_SIGN_IN_REQUEST_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
              //  firebaseAuthWithGoogle(account);
            } else {
                Toast.makeText(getActivity().getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();
            }
        }

    }
/*    private void initFBAuthState() {
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                String message;
                if (firebaseUser != null) {
                    message = "onAuthStateChanged signed in : " + firebaseUser.getUid();
                } else {
                    message = "onAuthStateChanged signed out";
                }
                Toast.makeText(getActivity().getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        };
    }*/


    private void initFBGoogleSignIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(WEB_CLIENT_ID)
                .requestEmail()
                .build();

        Context context = getContext();
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(getActivity(), new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(getActivity().getApplicationContext(),connectionResult.getErrorMessage(),Toast.LENGTH_SHORT).show();
                    }
                }).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();
    }

/*    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String message;
                        if (task.isSuccessful()) {
                            message = "success firebaseAuthWithGoogle";
                            //                            start next Activity

                            Intent intent = new Intent(getActivity().getApplicationContext(),MainActivity.class);

                            getActivity().finish();
                            startActivity(intent);



                        } else {
                            message = "fail firebaseAuthWithGoogle";
                        }
                        Toast.makeText(getActivity().getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity().getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }*/
}

