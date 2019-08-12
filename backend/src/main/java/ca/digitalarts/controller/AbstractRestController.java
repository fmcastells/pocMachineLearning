package ca.digitalarts.controller;

import ca.digitalarts.dao.CreateUser;
import ca.digitalarts.dao.model.User;
import ca.digitalarts.dao.impl.CreateUserImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AbstractRestController {

    private User user = new User();
    private CreateUser createUser = new CreateUserImpl();
    private List<String> getUserList = new ArrayList<>();

    @GetMapping("/login")
    public void login(Model model) {
        List<String> names = new ArrayList<>();
        List<String> categories = new ArrayList<>();
        List<String> expenses = new ArrayList<>();
        names.add("User1");
        names.add("User2");
        categories.add("Category1");
        categories.add("Category2");
        expenses.add("Expense1");
        expenses.add("Expense2");
        model.addAttribute("names", names);
        model.addAttribute("categories", categories);
        model.addAttribute("expenses", expenses);
    }

    @GetMapping("/create/{type}")
    public void create(@PathVariable String type, @RequestParam(name = "names", required = false) List<String> names, Model model) {
        if ("user".equalsIgnoreCase(type)) {
            names.forEach(this::setUserRepository);
            model.addAttribute("names", getUserList);
        } else if ("category".equalsIgnoreCase(type)) {
            System.out.println(type);
        } else {
            System.out.println(type);
        }
    }

    @GetMapping("/add/{type}")
    public void add(@PathVariable String type) {
        if ("user".equalsIgnoreCase(type)) {
            System.out.println(type);
        } else if ("category".equalsIgnoreCase(type)) {
            System.out.println(type);
        } else {
            System.out.println(type);
        }
    }

    private void setUserRepository(String name) {
        user.setName(name);
        createUser.buildUser(user);
        System.out.println(createUser.getUserMap().values());
        for (User userName : createUser.getUserMap().values()) {
            System.out.println(userName.getName());
            getUserList.add(userName.getName());
        }
    }
}
