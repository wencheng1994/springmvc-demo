package tech.st.springmvc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller public class TwitterControler {

   @Autowired private Twitter twitter;

   @RequestMapping("/twitter")
   public String tweet(@RequestParam(defaultValue = "SpringMVC4") String search, Model modle) {
      SearchResults results = twitter.searchOperations().search(search);
      List<Tweet> tweets = results.getTweets();
      modle.addAttribute("tweets", tweets);
      modle.addAttribute("search", "search string");
      return "resultPage";
   }
}
