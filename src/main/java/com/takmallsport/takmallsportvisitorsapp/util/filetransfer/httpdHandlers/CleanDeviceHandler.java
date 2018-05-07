package com.takmallsport.takmallsportvisitorsapp.util.filetransfer.httpdHandlers;

import android.os.Environment;

import com.takmallsport.takmallsportvisitorsapp.util.ApplicationClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

/**
 * Created by sahand on 5/6/18.
 */

public class CleanDeviceHandler extends RouterNanoHTTPD.GeneralHandler {
    @Override
    public String getMimeType() {
        return "text/html";
    }

    @Override
    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }

    @Override
    public NanoHTTPD.Response get(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        if (new File(Environment.getExternalStorageDirectory() + "/" + "change.db").delete())
        return NanoHTTPD.newFixedLengthResponse(getStatus(), getMimeType(), "DEVICE_CLEANED");
        else
            return NanoHTTPD.newFixedLengthResponse(getStatus(), getMimeType(), "FAIL");
    }

}
