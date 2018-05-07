package com.takmallsport.takmallsportvisitorsapp.util.filetransfer;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.takmallsport.takmallsportvisitorsapp.ui.ConnectToComputer.ComputerConnectActivity;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.file.Files;
import java.util.Enumeration;

/**
 * Created by sahand on 5/5/18.
 */

public class SocketServer {

    ComputerConnectActivity activity;
    ServerSocket serverSocket;
    String message = "";
    static final int socketServerPORT = 13088;
    public SocketServer(ComputerConnectActivity activity) {
        this.activity = activity;
        Thread socketServerThread = new Thread(new SocketServerThread());
        socketServerThread.start();
    }

    public void onDestroy() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private class SocketServerThread extends Thread {

        int count = 0;

        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(socketServerPORT);

                while (true) {
                    Socket socket = serverSocket.accept();
                    count++;
                    message += "#" + count + " from "
                            + socket.getInetAddress() + ":"
                            + socket.getPort() + "\n";

                    activity.runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            Toast.makeText(activity,message,Toast.LENGTH_SHORT).show();
                        }
                    });

                    SocketServerReplyThread socketServerReplyThread = new SocketServerReplyThread(
                            socket, count);
                    socketServerReplyThread.run();

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    private class SocketServerReplyThread extends Thread {

        private Socket hostThreadSocket;
        int cnt;

        SocketServerReplyThread(Socket socket, int c) {
            hostThreadSocket = socket;
            cnt = c;
        }

        @Override
        public void run() {
            OutputStream outputStream;
            String msgReply = "ServerIsOK";

            try {
                outputStream = hostThreadSocket.getOutputStream();
                PrintStream printStream = new PrintStream(outputStream);
                printStream.print(msgReply);
                //printStream.close();

                message += "replayed: " + msgReply + "\n";

                activity.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        //activity.msg.setText(message);
                        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show();
                    }
                });

                while (true) {
                    String message = ReadStringFromSocket(hostThreadSocket);
                    if (message.contains("HelloDev")) {
                        WriteStringToSocket(hostThreadSocket,"HelloToYou");
                    }
                    if (message.contains("WhatIsDeviceName")) {
                        WriteStringToSocket(hostThreadSocket,"#DEVICENAME#"+readDeviceName());
                    }
                    if (message.contains("SendDBFileToAndroid")) {
                        if (!receiveDatabaseFile(hostThreadSocket))
                            WriteStringToSocket(hostThreadSocket,"NoDataBaseFileOnAndroidDevice");
                    }
                    if (message.contains("GetDataBaseFromAndroidDevice")) {
                        sendChangeDatabase(hostThreadSocket);
                    }
                    if (message.contains("#DEVICENAME#")) {
                        writeDeviceName(message.replace("#DEVICENAME#",""));
                    }
                    if (message.contains("CleanAndroidHistory")) {
                        try {
                            new File(Environment.getExternalStorageDirectory() + File.separator + "/" + "change.db").delete();
                            WriteStringToSocket(hostThreadSocket,"CleanAndroidHistoryCompleted");
                        } catch (Exception e) {

                        }
                    }


                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                message += "Something wrong! " + e.toString() + "\n";
            }

            activity.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    //activity.msg.setText(message);
                }
            });
        }

    }

    public String getIpAddress() {
        String ip = "";
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces
                        .nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface
                        .getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress
                            .nextElement();

                    if (inetAddress.isSiteLocalAddress()) {
                        ip +=  inetAddress.getHostAddress() + "\n";
                    }
                }
            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ip += "Something Wrong! " + e.toString() + "\n";
        }
        return ip;
    }
    private String ReadStringFromSocket (Socket socket) {
        try {
            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader bReader = new BufferedReader(reader);
            return bReader.readLine();
        } catch (Exception e) {
            return "";
        }
    }
    private void WriteStringToSocket (Socket socket, String message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        printStream.print(message);
        //printStream.close();
    }

    private void writeDeviceName(String data) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(activity.openFileOutput("devicename.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    private String readDeviceName() {

        String ret = "";

        try {
            InputStream inputStream = activity.openFileInput("devicename.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    private boolean receiveDatabaseFile (Socket socket) {
        // receive file
        try {
            int bytesRead;
            int current = 0;
            byte[] mybytearray = new byte[6022386];
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream(Environment.getExternalStorageDirectory() + File.separator + "/" + "data.db");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray, 0, mybytearray.length);
            current = bytesRead;

            do {
                bytesRead =
                        is.read(mybytearray, current, (mybytearray.length - current));
                if (bytesRead >= 0) current += bytesRead;
            } while (bytesRead > -1);

            bos.write(mybytearray, 0, current);
            bos.flush();
            //System.out.println("File " + FILE_TO_RECEIVED
            //       + " downloaded (" + current + " bytes read)");


            if (fos != null) fos.close();
            if (bos != null) bos.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private boolean sendChangeDatabase(Socket socket ) {
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                FileInputStream fis = new FileInputStream(Environment.getExternalStorageDirectory() + File.separator + "/" + "change.db");
                byte[] buffer = new byte[4096];

                while (fis.read(buffer) > 0) {
                    dos.write(buffer);
                }

                fis.close();
                dos.close();
                return true;
            } catch (Exception e) {
                return false;
            }
    }
}
