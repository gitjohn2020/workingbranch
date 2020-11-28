package com.example.demo.Service;

import com.example.demo.Beans.Books;
import com.example.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepositry;

    public void addItem(Books books)
    {
        itemRepositry.save(books);

    }

    public List<Books> getBooks()
    {
        return itemRepositry.findAll();
    }

    public Books searchBook(int id)
    {
        return itemRepositry.findById(id);
    }
}
