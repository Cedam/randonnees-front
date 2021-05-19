package org.cedam.application.randonnees.front.proxies;

import java.util.List;

import org.cedam.application.randonnees.front.bean.TrekBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "randonnees-back-trek", url = "localhost:8085", path = "/treks")
public interface TrekServiceProxy {

    @GetMapping(value = "")
    List<TrekBean> getAll();

    @GetMapping(value = "/id?id={id}")
    TrekBean getById(@PathVariable("id") long id);

    @PostMapping(value = "/save")
    TrekBean save(@RequestBody TrekBean trek);

}
