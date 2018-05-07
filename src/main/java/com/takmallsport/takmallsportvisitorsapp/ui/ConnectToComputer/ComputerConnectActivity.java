package com.takmallsport.takmallsportvisitorsapp.ui.ConnectToComputer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.util.filetransfer.SocketServer;
import com.takmallsport.takmallsportvisitorsapp.util.filetransfer.httpdServer;

import java.io.IOException;

public class ComputerConnectActivity extends AppCompatActivity {

    TextView textView_ip_address;
    SocketServer socketServer;
    httpdServer httpdServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_connect);
        textView_ip_address = findViewById(R.id.textView_ip_address);
        httpdServer = new httpdServer(8080);
        try {
            httpdServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        socketServer = new SocketServer(this);
        textView_ip_address.setText(socketServer.getIpAddress());
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        httpdServer.stop();
        socketServer.onDestroy();


    }


}
