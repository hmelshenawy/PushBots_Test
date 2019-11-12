package com.haitham.pushbots_test;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class mFireBase_Instance extends FirebaseMessagingService {

    private final String TAG = "mFireBase_Instance";

    @Override
    public void onNewToken(String token) {

        super.onNewToken(token);

        // this method will be called automatically when the android creat the token for the first time

        Log.d(TAG, "Refreshed token: " + token);
        System.out.println("token" + token);

    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // this method will be called when receiving a message for the server

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            System.out.println("Message title is:: " + remoteMessage.getNotification().getTitle());
        }
    }
}
