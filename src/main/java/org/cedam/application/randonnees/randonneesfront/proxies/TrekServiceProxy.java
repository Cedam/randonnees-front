package org.cedam.application.randonnees.randonneesfront.proxies;

import java.util.List;

import org.cedam.application.randonnees.randonneesfront.bean.TrekBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "apprandonnees-back", url = "localhost:8085")
public interface TrekServiceProxy {

    String beanName = "/treks";
    
    @GetMapping(value = beanName)
    List<TrekBean> listeDesTreks();

    @GetMapping( value = beanName+"/{id}")
    TrekBean recupererUnTrek(@PathVariable("id") int id);

}
