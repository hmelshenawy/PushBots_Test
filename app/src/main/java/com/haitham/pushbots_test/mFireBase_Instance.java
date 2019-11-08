package com.haitham.pushbots_test;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class mFireBase_Instance extends FirebaseMessagingService {

    private final String TAG = "mFireBase_Instance";

    @Override
    public void onNewToken(String token) {

        super.onNewToken(token);

        Log.d(TAG, "Refreshed token: " + token);
        System.out.println("token" + token);

    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            System.out.println("Message title is:: " + remoteMessage.getNotification().getTitle());
        }
    }
}
