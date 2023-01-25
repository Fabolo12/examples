package com.controllers;

import com.models.Article;
import com.models.Category;
import com.models.Person;
import com.service.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private static final Random RANDOM = new Random();

    private final UserResource service;

    @Autowired
    public ArticleController(UserResource service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView getArticle(ModelAndView modelAndView) {
        final Article article = getArticle();
        modelAndView.addObject("article", article);
        modelAndView.setViewName("articleView");
        return modelAndView;
    }

    @GetMapping("/local")
    public ModelAndView getArticlesLocal(ModelAndView modelAndView) {
        final List<Article> articles = Arrays.asList(getArticle(), getArticle(), getArticle());
        modelAndView.addObject("articles", articles);
        modelAndView.setViewName("articleView1");
        return modelAndView;
    }

    @GetMapping("/expressions")
    public ModelAndView getArticleExpressions(ModelAndView modelAndView) {
        final Article article = getArticle();
        modelAndView.addObject("article", article);
        modelAndView.setViewName("articleView2");
        return modelAndView;
    }

    @GetMapping("/form")
    public ModelAndView getArticleForm(ModelAndView modelAndView) {
        Article article = new Article();
        article.setTitle("Default title");
//        Article article = getArticle();
        modelAndView.addObject("article", article);
        modelAndView.setViewName("articleView3");
        return modelAndView;
    }

    @GetMapping("/radio")
    public ModelAndView getArticleRadio(ModelAndView modelAndView) {
        Article article = getArticle();
        modelAndView.addObject("article", article);
        modelAndView.addObject("vips", List.of("VIP-1", "VIP-2", "VIP-3"));
        modelAndView.setViewName("articleView4");
        return modelAndView;
    }

    @GetMapping("/flag")
    public ModelAndView getArticleFlag(ModelAndView modelAndView) {
        Article article = getArticle();
        article.setCategories(
                List.of(
                        new Category("Category-1", false),
                        new Category("Category-2", true)
                )
        );
        modelAndView.addObject("article", article);
        modelAndView.setViewName("articleView5");
        return modelAndView;
    }

    @GetMapping("/select")
    public ModelAndView getArticleSelect(ModelAndView modelAndView) {
        Article article = getArticle();
        modelAndView.addObject("article", article);
        modelAndView.addObject("vips", List.of("VIP-1", "VIP-2", "VIP-3"));
        modelAndView.setViewName("articleView6");
        return modelAndView;
    }

    @GetMapping("/if")
    public ModelAndView getArticlesIf(ModelAndView modelAndView) {
//        final List<Article> articles = Arrays.asList(getArticle(), getArticle(), getArticle());
        final List<Article> articles = new ArrayList<>();
        modelAndView.addObject("articles", articles);
        modelAndView.setViewName("articleView7");
        return modelAndView;
    }

    @GetMapping("/switch")
    public ModelAndView getArticlesSwitch(ModelAndView modelAndView) {
        final Article article1 = getArticle();
        final Article article2 = getArticle();
        article2.setVip("VIP-2");
        final Article article3 = getArticle();
        article3.setVip("VIP-1");
        final List<Article> articles = Arrays.asList(article1, article2, article3);
        modelAndView.addObject("articles", articles);
        modelAndView.setViewName("articleView8");
        return modelAndView;
    }

    @GetMapping("/locale")
    public ModelAndView getArticleLocale(ModelAndView modelAndView) {
        final Article article = getArticle();
        modelAndView.addObject("article", article);
        modelAndView.setViewName("articleView9");
        return modelAndView;
    }

    @PostMapping
    public String saveArticle(@ModelAttribute Article article, ModelAndView modelAndView) {
        System.out.println(article);
        modelAndView.addObject("article", article);
        return "/articleView";
    }

    @PutMapping
    public ModelAndView saveArticle2(@ModelAttribute Article article, ModelAndView modelAndView) {
        System.out.println(article);
        modelAndView.addObject("article", article);
        modelAndView.setViewName("articleView");
        return modelAndView;
    }

    @GetMapping("/valid")
    public ModelAndView getArticleValid(ModelAndView modelAndView) {
        Article article = new Article();
        modelAndView.addObject("article", article);
        modelAndView.setViewName("articleView10");
        return modelAndView;
    }

    @PostMapping("/valid")
    public ModelAndView saveArticle(@ModelAttribute @Valid Article article, BindingResult bindingResult,
                                    ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("article", article);
            modelAndView.setViewName("articleView10");
            return modelAndView;
        }
        System.out.println(article);
        modelAndView.setViewName("articleView");
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("user", new Person());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView registration(@ModelAttribute Person user, ModelAndView modelAndView) {
        service.save(user);
        modelAndView.setViewName("redirect:/article");
        return modelAndView;
    }

    @GetMapping("/security")
    public ModelAndView security(ModelAndView modelAndView) {
        modelAndView.setViewName("articleView11");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView modelAndView) {
        System.out.println("Only for admin user!");
        modelAndView.setViewName("articleView11");
        return modelAndView;
    }

    //    @ModelAttribute(name = "article")
    private Article getArticle() {
        Article article = new Article();
        article.setAuthor(getName());
        article.setContent(getArticleContent());
        article.setTitle(getTitle());
        article.setVip("VIP-0");
        return article;
    }

    private String getName() {
        return "Name-" + RANDOM.nextInt(100);
    }

    private String getArticleContent() {
        return "Content-" + RANDOM.nextInt(100);
    }

    private String getTitle() {
        return "Title-" + RANDOM.nextInt(100);
    }
}
