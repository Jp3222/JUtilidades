/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jutil.framework;

import com.jutil.dbcon.connection.JDBModels;

/**
 *
 * @author juan-campos
 */
public class LaunchApp implements MainSystem {

    private static LaunchApp instance;

    public synchronized static LaunchApp getInstance(MainSystem main) {
        if (instance == null) {
            instance = new LaunchApp(main);
        }
        return instance;
    }

    public synchronized static LaunchApp getInstance() {
        return instance;
    }
    private final MainSystem main;
    private final LocalSession session;
    private final JDBModels tables;
    private boolean cache_load_main;
    private boolean reLoad;

    private LaunchApp(MainSystem main) {
        this(main, null, null);
    }

    public LaunchApp(MainSystem main, LocalSession session, JDBModels tables) {
        this.main = main;
        this.session = session;
        this.tables = tables;
    }

    @Override
    public synchronized boolean conectionDB() {
        return main.conectionDB();
    }

    @Override
    public synchronized boolean appFiles() {
        return main.appFiles();
    }

    @Override
    public synchronized boolean cache() {
        return main.cache();
    }

    @Override
    public synchronized boolean run() {
        return main.run();
    }

    @Override
    public synchronized boolean openSys() {
        return main.openSys();
    }

    @Override
    public synchronized boolean closeSys() {
        return main.closeSys();
    }

    /**
     * @throws java.lang.InterruptedException
     */
    public void main() throws InterruptedException {

        main.appFiles();

        main.openSys();

        main.conectionDB();

        if (cache_load_main) {
            main.cache();
        }

        synchronized (main) {
            main.run();
            main.wait();
        }

        main.closeSys();
    }

    public void doWhileRun() throws InterruptedException {
        main.appFiles();

        main.openSys();

        do {

            main.conectionDB();

            if (cache_load_main) {
                main.cache();
            }

            synchronized (main) {
                main.run();
                main.wait();
            }

        } while (reLoad);

        main.closeSys();

    }

    public void setCacheLoadMain(boolean cache_load_main) {
        this.cache_load_main = cache_load_main;
    }

    public boolean isCacheLoadMain() {
        return cache_load_main;
    }

    public void setReLoad(boolean reLoad) {
        this.reLoad = reLoad;
    }

    public boolean isReLoad() {
        return reLoad;
    }

    public MainSystem getMain() {
        return main;
    }

    public LocalSession getSession() {
        return session;
    }

    @Override
    public Object getResources(String key) {
        return main.getResources(key);
    }

}
