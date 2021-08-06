package com.laptrinhjavaweb.controller;

import com.laptrinhjavaweb.controller.output.NewOutput;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/practice-web")
public class NewAPI {
//    @RequestMapping(value = "/new" , method = RequestMethod.POST)
//    @ResponseBody
//    public NewDTO createNew(@RequestBody NewDTO model){
//        return model;
//    }
    @Autowired
    //@Qualifier("INewService")
    private INewService newService;

    @GetMapping("/new")
    public NewOutput showNew(@RequestParam(value = "page",required = false) Integer page,
                             @RequestParam(value = "limit",required = false) Integer limit) {
        NewOutput result = new NewOutput();
        if(page != null && limit != null){
            result.setPage(page);
            Pageable pageable = PageRequest.of(page-1,limit ,Sort.unsorted());
            result.setListResult(newService.findAll(pageable));
            result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
        }else{
            result.setListResult(newService.findAll());
        }
        return result;
    }


//
//    @GetMapping("/new")
//    public List<NewsEntity> getNews(){
//        return newService.getAllNew();
//    }

    @PostMapping("/new")
   // @ResponseBody
    public NewDTO createNew(@RequestBody NewDTO model){
        return newService.save(model);
    }

    @PutMapping("/new/{id}")
    public NewDTO updateNew(@RequestBody NewDTO model , @PathVariable("id") long id){
        model.setId(id);
        return newService.save(model);
    }

    @DeleteMapping("/new")
    public void deleteNew(@RequestBody long[] ids){
        newService.delete(ids);
    }
}
