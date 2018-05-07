package com.takmallsport.takmallsportvisitorsapp.util.filetransfer.httpdHandlers;

import android.os.Environment;
import android.util.Log;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import java.io.File;
import java.util.List;
import java.util.Map;

import fi.iki.elonen.NanoFileUpload;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.router.RouterNanoHTTPD;

/**
 * Created by sahand on 5/6/18.
 */

public class UploadDbHandler extends RouterNanoHTTPD.GeneralHandler  {
    NanoFileUpload uploader = new NanoFileUpload(new DiskFileItemFactory());
    public Map<String, List<FileItem>> files;
    @Override
    public String getMimeType() {
        return "text/html";
    }
    @Override
    public NanoHTTPD.Response get(RouterNanoHTTPD.UriResource uriResource, Map<String, String> urlParams, NanoHTTPD.IHTTPSession session) {
        session.getHeaders().put("content-length", "AA");
        try {
            files = uploader.parseParameterMap(session);
            //File database = files.get("database").get(0).;
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "/" + "data.db");
            file.delete();
            files.get("file").get(0).write(file);
            Log.d("TAG",files.size() + "" );
            return NanoHTTPD.newFixedLengthResponse("UPLOAD_SUCCESS");
        } catch (FileUploadException e) {
            e.printStackTrace();
            return NanoHTTPD.newFixedLengthResponse("UPLOAD_FAIL");
        } catch (Exception e) {
            e.printStackTrace();
            return NanoHTTPD.newFixedLengthResponse("UPLOAD_FAIL");
        }

    }


    @Override
    public NanoHTTPD.Response.IStatus getStatus() {
        return NanoHTTPD.Response.Status.OK;
    }
}
