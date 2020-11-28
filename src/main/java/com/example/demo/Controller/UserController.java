package com.example.demo.Controller;

import com.example.demo.Beans.Books;
import com.example.demo.Exception.ItemNotFoundException;
import com.example.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    ItemService itemService;

    @PostMapping(value = "/adduser" ,produces = "application/json")
    public String addUser(@RequestBody Books books)
    {
        itemService.addItem(books);
        return "success";
    }

    @GetMapping(value = "/getuser")
    public List<Books> getUser()
    {
        return itemService.getBooks();
    }

    @GetMapping(value = "/getuser/{id}")
    public ResponseEntity<Books> searchUser(@PathVariable int id) throws ItemNotFoundException {
        Books ob = new Books();
        ob = itemService.searchBook(id);

        if(ob==null)
        {
            throw new ItemNotFoundException("Employee not found for this id :: " + id);

        }
        return ResponseEntity.ok().body(ob);
    }
}
