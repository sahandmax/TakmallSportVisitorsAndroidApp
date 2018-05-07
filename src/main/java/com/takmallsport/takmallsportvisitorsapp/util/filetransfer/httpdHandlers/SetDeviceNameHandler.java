package com.takmallsport.takmallsportvisitorsapp.util.filetransfer.httpdHandlers;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.takmallsport.takmallsportvisitorsapp.util.ApplicationClass;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

/**
 * Created by sahand on 5/6/18.
 */

public class SetDeviceNameHandler extends RouterNanoHTTPD.DefaultHandler {

    public Map<String, List<String>> decodedParamters;
    @Override
    public String getMimeType() {
        return "text/html";
    }

    @Override
    public String getText() {
        return "Error";
    }

    @Override
    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }

    public NanoHTTPD.Response get(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        try {
            session.parseBody(new HashMap<String, String>());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NanoHTTPD.ResponseException e) {
            e.printStackTrace();
        }


        for (Map.Entry<String, String> entry : urlParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String text = "<div> Param: " + key + "&nbsp;Value: " + value + "</div>";

            return NanoHTTPD.newFixedLengthResponse(getStatus(), getMimeType(), text);
        }
        try {
            Map<String, String> ParamsMap = session.getParms();
            String value = ParamsMap.get("device_name");
            writeDeviceName(value);
            return NanoHTTPD.newFixedLengthResponse(getStatus(), getMimeType(), "OK");
        } catch (Exception e) {
            return NanoHTTPD.newFixedLengthResponse(getStatus(), getMimeType(), "FAIL");
        }

    }

    private void writeDeviceName(String data) {
        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(ApplicationClass.getContext().openFileOutput("devicename.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
