package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.FireBaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FireBaseService {
    public FireBaseUser authenticate(String idToken) throws IOException, FirebaseAuthException {

        String uid = FirebaseAuth.getInstance().verifyIdToken(idToken).getUid();
        String name = FirebaseAuth.getInstance().verifyIdToken(idToken).getName();
        String email = FirebaseAuth.getInstance().verifyIdToken(idToken).getEmail();

        return new FireBaseUser(uid,name,email);
    }

}
