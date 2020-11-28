package com.example.demo.Controller;

import com.example.demo.Beans.Books;
import com.example.demo.Exception.ItemNotFoundException;
import com.example.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping(value = "/addbooks" ,produces = "application/json")
    public String addBooks(@RequestBody Books books)
    {
        itemService.addItem(books);
        return "success";
    }

    @GetMapping(value = "/getbooks")
    public List<Books> getBooks()
    {
        return itemService.getBooks();
    }

    @GetMapping(value = "/getbooks/{id}")
    public ResponseEntity<Books> searchBook(@PathVariable int id) throws ItemNotFoundException {
        Books ob = new Books();
        ob = itemService.searchBook(id);

        if(ob==null)
        {
            throw new ItemNotFoundException("Employee not found for this id :: " + id);

        }
        return ResponseEntity.ok().body(ob);
    }
}
