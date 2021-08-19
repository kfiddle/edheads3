package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavController {


    @RequestMapping("/user-entry-form")
    public String displayUserEntryFormPage() {

        return "userEntry";
    }

    @RequestMapping("/welcome")
    public String displayWelcomePage() {

        return "welcome";
    }

//    START ABOUT US SECTION MAPPING

    @RequestMapping("/about-us")
    public String displayAboutUsPage() {

        return "aboutUs";
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

//    END ABOUT US SECTION MAPPING

//    START OUR GAMES SECTION MAPPING

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

    @RequestMapping("/simple-machines")
    public String displaySimpleMachinesGamePage() {

        return "simpleMachines";
    }

//    END OUR GAMES SECTION MAPPING

}

