package edu.agh.physiciochemistry;

import edu.agh.physiciochemistry.model.AdiabaticExpansionProcess;
import edu.agh.physiciochemistry.model.Gas;
import edu.agh.physiciochemistry.model.IsothermalExpansionProcess;
import edu.agh.physiciochemistry.model.AdiabaticExpansionProcess;
import edu.agh.physiciochemistry.model.Process;
import netscape.javascript.JSObject;

/**
 * Created by dudek on 3/23/17.
 */

@SuppressWarnings("unused")
public class JavaAPI {

    public static final String JS_NAME = "JavaAPI";

    public void invokeIsothermalExpansionProcess(JSObject gasObj, JSObject paramsObj, JSObject callback){
        System.out.println("Invoked Isothermal Process with params:");

        Gas gas = Gas.fromJSObject(gasObj);
        System.out.println("Gas: " + gas);

        Process.Params params = Process.Params.fromJSObject(paramsObj);
        System.out.println("Params: " + params);

        Process.Result result = (new IsothermalExpansionProcess()).execute(gas, params);

        System.out.println("Falling back to JS callback with result: " + result);
        callback.call("onResult", result.toJSArgs());
    }

    public void invokeAdiabaticExpansionProcess(JSObject gasObj, JSObject paramsObj, JSObject callback){
        System.out.println("Invoked Adiabatic Process with params:");

        Gas gas = Gas.fromJSObject(gasObj);
        System.out.println("Gas: " + gas);

        Process.Params params = Process.Params.fromJSObject(paramsObj);
        System.out.println("Params: " + params);

        Process.Result result = (new AdiabaticExpansionProcess()).execute(gas, params);

        System.out.println("Falling back to JS callback with result: " + result);
        callback.call("onResult", result.toJSArgs());

    }
}
