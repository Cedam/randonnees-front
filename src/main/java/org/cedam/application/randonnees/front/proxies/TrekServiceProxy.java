package org.cedam.application.randonnees.front.proxies;

import java.util.List;

import org.cedam.application.randonnees.front.bean.TrekBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "apprandonnees-back", url = "localhost:8085", path = "/treks")
public interface TrekServiceProxy {

    @GetMapping(value = "")
    List<TrekBean> listeDesTreks();

    @GetMapping( value = "/{id}")
    TrekBean recupererUnTrek(@PathVariable("id") int id);

}
