package com.InicioUsuario.repaso.Service.Impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.remoteconfig.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    @Autowired
    private Firestore firestore;

    public String saveUser(User user) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionsApiFuture =
                firestore.collection("users").document(user.getName()).set(user);

        return collectionsApiFuture.get().getUpdateTime().toString();
    }

}
