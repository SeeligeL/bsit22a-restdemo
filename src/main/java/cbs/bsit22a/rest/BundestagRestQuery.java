//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package cbs.bsit22a.rest;

import java.util.List;

public class BundestagRestQuery extends BasicRestQuery {
    private static final RestParam API_KEY = new RestParam("apikey", "rgsaY4U.oZRQKUHdJhF9qguHMkwCGIoLaqEcaHjYLF");

    public BundestagRestQuery(String dataset, RestParam... additionalParams) {
        super(dataset, List.of(API_KEY), additionalParams);
    }

    protected String getURL() {
        return "https://search.dip.bundestag.de/api/v1";
    }
}
