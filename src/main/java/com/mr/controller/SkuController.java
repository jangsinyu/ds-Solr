package com.mr.controller;

import com.mr.model.TMallSku;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by JangSinyu on 2018/11/15.
 */
@Controller
public class SkuController {

    @Autowired
    private HttpSolrServer httpSolrServer;

    @ResponseBody
    @RequestMapping("getSkuListByKey")
    public List<TMallSku> getSkuListByKey(String key) throws SolrServerException {
        SolrQuery query = new SolrQuery();
        query.setQuery("skuMch:"+key);
        QueryResponse response = httpSolrServer.query(query);
        List<TMallSku> skuList = response.getBeans(TMallSku.class);
        return skuList;
    }


}
