package edu.agh.physiciochemistry;

import netscape.javascript.JSObject;

/**
 * Created by dudek on 3/23/17.
 */
public class JavaScriptAPI {
    public static final String JS_LOCATION = "window.jsAPI";
    private JSObject jsObject;

    public JavaScriptAPI(JSObject object){
        this.jsObject = object;
    }

    public void callSampleMethod(){
        jsObject.call("echo", "Pozdrowienia dla JavaScriptu");
    }
}
