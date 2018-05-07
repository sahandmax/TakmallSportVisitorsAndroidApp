package com.takmallsport.takmallsportvisitorsapp.util.filetransfer;


import com.takmallsport.takmallsportvisitorsapp.util.filetransfer.httpdHandlers.CleanDeviceHandler;
import com.takmallsport.takmallsportvisitorsapp.util.filetransfer.httpdHandlers.DownloadDBHandler;
import com.takmallsport.takmallsportvisitorsapp.util.filetransfer.httpdHandlers.GetDeviceNameHandler;
import com.takmallsport.takmallsportvisitorsapp.util.filetransfer.httpdHandlers.SetDeviceNameHandler;
import com.takmallsport.takmallsportvisitorsapp.util.filetransfer.httpdHandlers.UploadDbHandler;

import fi.iki.elonen.router.RouterNanoHTTPD;

/**
 * Created by sahand on 5/6/18.
 */

public class httpdServer extends RouterNanoHTTPD {
    public httpdServer(int port) {
        super(port);
        addMappings();

    }
//    @Override
//    public Response serve(IHTTPSession session) {
//        String msg = "<html><body><h1>Page Not Found</h1><hr>NanoHTTPD on VisitorsApp (Android Device)\n";
//
//        return  newFixedLengthResponse(Response.Status.OK,"text/html",msg);
//    }

    @Override
    public void addMappings() {
        super.addMappings();
        addRoute("/UploadDB",UploadDbHandler.class); // PostFile with File Variable
        addRoute("/UploadDB",UploadDbHandler.class);
        addRoute("/DownloadDB",DownloadDBHandler.class);
        addRoute("/CleanDevice",CleanDeviceHandler.class);
        addRoute("/GetDeviceName",GetDeviceNameHandler.class);
        addRoute("/SetDeviceName", SetDeviceNameHandler.class);
    }




}
