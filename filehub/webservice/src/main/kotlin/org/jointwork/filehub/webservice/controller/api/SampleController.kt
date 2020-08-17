package org.jointwork.filehub.webservice.controller.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/sample")
class SampleController() {

    @GetMapping("/")
    fun get():String {
        return "Hello!"
    }
}