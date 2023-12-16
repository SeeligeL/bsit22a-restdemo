package cbs.bsit22a.rest;


import java.util.List;

public class OpenLigaRestQuery extends BasicRestQuery {

    public OpenLigaRestQuery(String dataset) {
        super(dataset, List.of(), new RestParam[0]);
    }

    @Override
    protected String getURL() {
        return "https://api.openligadb.de";
    }
}