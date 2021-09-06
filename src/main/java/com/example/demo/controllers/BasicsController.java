package com.example.demo.controllers;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;


@Controller
public class BasicsController {

    @Resource
    UserRepository userRepo;

    @RequestMapping("/")
    public String displayRoot() {
        return "welcome";
    }

    @RequestMapping("/welcome")
    public String displayWelcomePage() {
        return "welcome";
    }

    @RequestMapping("/sign-up")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @RequestMapping("/register_success")
    public String showSuccessfulRegistrationForm() {
        return "register_success";
    }

//    @PostMapping("/process_register")
//    public String processRegister(@ModelAttribute("user") User user) {
//        System.out.println("Log process_register step: " + user.getFirstName());
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        System.out.println(user.getFirstName() + "  " + user.getEmail() + "    " + user.getPassword());
//
//        userRepo.save(user);
//        return "redirect:register_success";
//    }

    @PostMapping("/process_register")
    public String processRegister(@ModelAttribute User incomingUser) {

        User userToAdd = new User(incomingUser.getEmail());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(incomingUser.getPassword());
        userToAdd.setPassword(encodedPassword);

        userToAdd.setRole(incomingUser.getRole());
        userToAdd.setFirstName(incomingUser.getFirstName());
        userToAdd.setLastName(incomingUser.getLastName());
        userToAdd.setSubscribeToNewsInd(incomingUser.isSubscribeToNewsInd());

        userToAdd.setSchoolOrganization(incomingUser.getSchoolOrganization());
        userToAdd.setDistrict(incomingUser.getDistrict());
        userToAdd.setCountry(incomingUser.getCountry());
        userToAdd.setState(incomingUser.getState());
        userToAdd.setCity(incomingUser.getCity());
        userToAdd.setGradeRange(incomingUser.getGradeRange());
        userToAdd.setSchoolType(incomingUser.getSchoolType());
        userToAdd.setNumberOfStudents(incomingUser.getNumberOfStudents());
        userToAdd.setPercentOfFreeLunches(incomingUser.getPercentOfFreeLunches());
        userToAdd.setDescription(incomingUser.getDescription());

        userToAdd.setDateCreated(LocalDate.now());
        userToAdd.setDateUpdate(LocalDate.now());
        userRepo.save(userToAdd);

        return "redirect:register_success";
    }

    @RequestMapping("/about-us")
    public String displayAboutUsPage() {

        return "aboutUs";
    }

    @GetMapping("/login")
    public String displayLoginPage() {

        return "login";
    }

    @RequestMapping("/faq")
    public String displayFaqPage() {

        return "faq";
    }

    @RequestMapping("/awards")
    public String displayAwardsPage() {

        return "awards";
    }

    @RequestMapping("/privacy")
    public String displayPrivacyPage() {

        return "privacy";
    }

    @RequestMapping("/terms-of-use")
    public String displayTermsOfUsePage() {

        return "termsOfUse";
    }

    @RequestMapping("/activity-help")
    public String displayActivityHelpPage() {

        return "activityHelp";
    }


    @RequestMapping("/our-games")
    public String displayOurGamesPage() {

        return "allGamesView";
    }

    @RequestMapping("/nano-start-up")
    public String displayNanoStartUpGamePage() {

        return "nanoStartUp";
    }

    @RequestMapping("/manufacturing-technician")
    public String displayManufacturingTechnicianGamePage() {

        return "manufacturingTechnician";
    }

    @RequestMapping("/manufacturing-quiz")
    public String displayManufacturingQuizPage() {

        return "manufacturingQuiz";
    }


    @RequestMapping("/simple-machines")
    public String displaySimpleMachinesGamePage() {

        return "simpleMachines";
    }

    @RequestMapping("/get-involved")
    public String displayGetInvolvedPage() {

        return "getInvolved";
    }

    @RequestMapping("/donate")
    public String displayDonatePage() {

        return "donate";
    }

    @RequestMapping("/teachers")
    public String displayTeachersPage() {

        return "teacherResources";
    }

    @RequestMapping("/basic-page")
    public String displayBasicPage() {

        return "basicPage";
    }



}
