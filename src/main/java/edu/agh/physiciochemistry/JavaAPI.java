package edu.agh.physiciochemistry;

import netscape.javascript.JSObject;

/**
 * Created by dudek on 3/23/17.
 */
public class JavaAPI {

    public static final String JS_NAME = "JavaAPI";

    @SuppressWarnings("unused")
    public void count(int x, double y, JSObject callback){
        double result = x*y;
        callback.call("onResult", result);
        System.out.println(result);
    }

    public void invokeIsothermalExpansionProcess(){

    }

    public void invokeAdiabaticExpansionProcess(){

    }

    public void invokeIsothermalCompressProcess(){

    }

    public void invokeAdiabaticCompressProcess(){

    }

}
