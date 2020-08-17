package org.jointwork.filehub.webservice.controller

import org.jointwork.filehub.core.Sample
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/")
    fun home(model: Model): String {
        Sample().add("head","tail")
        model["title"] = "Home"
        return "Home"
    }
}