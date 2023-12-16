package cbs.bsit22a;

import cbs.bsit22a.rest.BasicRestQuery;
import cbs.bsit22a.rest.BundestagRestQuery;
import cbs.bsit22a.rest.OpenLigaRestQuery;
import cbs.bsit22a.rest.RestParam;


/**
 * JavaFX App
 */
public class App {

    public static void main(String[] args) {
        //launch();
        runOpenLigaExample();
        runBundestagExample();
    }

    private static void runOpenLigaExample() {
        BasicRestQuery query = new OpenLigaRestQuery("getmatchdata/bl1/2023/Augsburg");
        query.printResponse();
    }
    private static void runBundestagExample() {
        BasicRestQuery query = new BundestagRestQuery("person", new RestParam("f.wahlperiode", "20"));
        query.printResponse();
    }


/*    @Override
    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
//        stage.show();
    }*/

}