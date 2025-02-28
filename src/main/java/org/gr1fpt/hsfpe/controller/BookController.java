package org.gr1fpt.hsfpe.controller;

import jakarta.servlet.http.HttpSession;
import org.gr1fpt.hsfpe.model.Book;
import org.gr1fpt.hsfpe.service.BookCategoryService;
import org.gr1fpt.hsfpe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    BookCategoryService bookCategoryService;

    @GetMapping("/page")
    public String showPage(Model model, HttpSession session) {
        String role = (String) session.getAttribute("role");
        if (role == null) {
            return "redirect:/login";
        }
        else if (role.equals("customer"))
        {
            return "forbidden";
        }
        List<Book> list = bookService.getAll();
        model.addAttribute("books", list);
        model.addAttribute("newBook", new Book());
        model.addAttribute("categories", bookCategoryService.getAll());
        model.addAttribute("role", role); // Thêm role vào Model
        return "page";
    }


    @PostMapping("/create-book")
    public String createBook(Book book) {
        bookService.create(book);
        return "redirect:/page";
    }

    @PostMapping("/delete-book")
    public String deleteBook(@RequestParam int id) {
        bookService.delete(id);
        return "redirect:/page";
    }

    @PostMapping("/update-book")
    public String updateBook(Book book) {
        bookService.update(book);
        return "redirect:/page";
    }

    @GetMapping("/search-book")
    public String searchBook(@RequestParam String name, Model model) {
        List<Book> searchResults = bookService.findByName(name);
        model.addAttribute("books", searchResults);
        model.addAttribute("newBook", new Book());
        model.addAttribute("categories", bookCategoryService.getAll());
        model.addAttribute("searchName", name);
        return "page";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, String password, HttpSession session) {
        String url ="redirect:/login?error";
        if ("admin".equals(username) && "12345".equals(password)) {
            session.setAttribute("role", "admin");
            url= "redirect:/page";
        }
        else  if ("staff".equals(username) && "12345".equals(password)) {
            session.setAttribute("role", "staff");
            url= "redirect:/page";
        }
        else  if ("customer".equals(username) && "12345".equals(password)) {
            session.setAttribute("role", "customer");
            url= "redirect:/page";
        }
        return url;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}