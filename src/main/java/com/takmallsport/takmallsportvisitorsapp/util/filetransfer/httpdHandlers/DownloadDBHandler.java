package com.takmallsport.takmallsportvisitorsapp.util.filetransfer.httpdHandlers;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

/**
 * Created by sahand on 5/6/18.
 */

public class DownloadDBHandler extends RouterNanoHTTPD.DefaultStreamHandler {

    @Override
    public String getMimeType() {
        return "text/plain";
    }

    @Override
    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }

    @Override
    public InputStream getData() {
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "/" + "change.db");

        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
            return null;
        }

    }
}
