package com.deltragon.cordova;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

import android.webkit.WebView;
import android.webkit.WebSettings;

public class AndroidZoom extends CordovaPlugin {

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        WebView wkWebView = (WebView) webView.getEngine().getView();
        WebSettings settings = wkWebView.getSettings();

        // both of these settings basically do the same thing, the first turns on zoom in general, the second one the builtin zoom controls (pinch or the buttons)
        // since the builtin zoom controls are the only ones currently supported, it wouldn't make sense not to have these set to the same thing
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);

        // this controls whether to show the buttons for zoom
        // since they can be in the way of the app, don't display them, pinch should be enough
        settings.setDisplayZoomControls(false);
    }
}


