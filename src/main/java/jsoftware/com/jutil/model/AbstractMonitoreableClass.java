/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jsoftware.com.jutil.model;

import jsoftware.com.jutil.model.utils.Monitoreable;

/**
 *
 * @author juanp
 */
public abstract class AbstractMonitoreableClass implements Monitoreable {

    protected boolean flag_dev_log;
    protected String name_module;

    public AbstractMonitoreableClass(boolean flag_dev_log, String name_module) {
        this.flag_dev_log = flag_dev_log;
        this.name_module = name_module;
    }

    @Override
    public void devLog(String msg) {
        if (flag_dev_log) {
            System.out.println("%s: %s".formatted(name_module, msg));
        }
    }

    @Override
    public void errLog(String msg) {
        if (flag_dev_log) {
            System.err.println("%s: %s".formatted(name_module, msg));
        }
    }

    protected void stop() {
        errLog("SYS - STOP");
        System.exit(1);
    }

    protected void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            errLog("STOP ERR");
            System.getLogger(name_module).log(System.Logger.Level.ERROR, "SLEEP - ERROR");
        }
    }

}
