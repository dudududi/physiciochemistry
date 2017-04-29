package edu.agh.physiciochemistry;

import edu.agh.physiciochemistry.model.Gas;
import edu.agh.physiciochemistry.model.IsothermalExpansionProcess;
import edu.agh.physiciochemistry.model.Process;
import netscape.javascript.JSObject;

/**
 * Created by dudek on 3/23/17.
 */

@SuppressWarnings("unused")
public class JavaAPI {

    public static final String JS_NAME = "JavaAPI";

    @SuppressWarnings("unused")
    public void count(int x, double y, JSObject callback){
        double result = x*y;
        callback.call("onResult", result);
        System.out.println(result);
    }

    public void invokeIsothermalExpansionProcess(JSObject gas, JSObject params, JSObject callback){
        Process.Result result = (new IsothermalExpansionProcess()).execute(Gas.fromJSObject(gas), Process.Params.fromJSObject(params));
        callback.call("onResult", 15);//result.toJSObject());
    }

    public void invokeAdiabaticExpansionProcess(){

    }

    public void invokeIsothermalCompressProcess(){

    }

    public void invokeAdiabaticCompressProcess(){

    }

}
