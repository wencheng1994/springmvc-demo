package tech.st.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String dispalyProfile(ProfileForm proFileForm) {
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "profile/profilePage";
        }

        System.out.println("save ok: " + profileForm);
        return "redirect:/profile";
    }
}
