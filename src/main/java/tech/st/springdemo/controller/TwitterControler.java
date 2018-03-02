package tech.st.springdemo.controller;

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
//      SearchResults results = twitter.searchOperations().search(search);
//      String text = results.getTweets().get(0).getText();

//      List<String> tweets = results.getTweets().stream().map(Tweet::getText).collect(Collectors.toList());
//      modle.addAttribute("tweets", tweets);

      Tweet tweet = new Tweet(109333, "I am very happy for that day", new Date(), "Jenny Wang", "http://www.baiud.com/img/", 131433L, 234324L, "zh-CN", "twitter");
      Tweet tweet2 = new Tweet(109333, "I am very happy for that day", new Date(), "Jenny Wang", "http://www.baiud.com/img/", 131433L, 234324L,
         "zh-CN", "twitter");
//
//
//      List<Tweet> tweets = results.getTweets();
      List<Tweet> tweets = new ArrayList<>();
      tweets.add(tweet);
      tweets.add(tweet2);

      modle.addAttribute("tweets", tweets);
      modle.addAttribute("search", "search string");
      modle.addAttribute("message", "Hello from the page");
//      modle.addAttribute("message", text);
      return "resultPage";
   }
}
