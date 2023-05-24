package vn.code.skycloud.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.code.skycloud.models.Book;

@Controller
public class BookController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/books")
    public String showBooks(Model model) {
        // books.add(new Book("t1", "Author 1"));
        model.addAttribute("books", books);
        return "book";
    }

    @PostMapping("/saveBooks")
    public String saveBooks(@ModelAttribute("books") List<Book> books) {
        return "redirect:/books";
    }
}
