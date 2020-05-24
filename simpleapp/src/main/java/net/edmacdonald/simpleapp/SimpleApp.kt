package net.edmacdonald.simpleapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import java.net.InetAddress

@SpringBootApplication
open class SimpleApp

fun main(args: Array<String>) {
    runApplication<SimpleApp>(*args)
}

data class Subreddit( val name: String, val description: String, val audience: String){
    val link = "http://www.reddit.com/$name";
    val hostname = InetAddress.getLocalHost().hostName
}

fun getRandomSubreddit(): Subreddit =
    jacksonObjectMapper()
    .readValue<List<Subreddit>>(
        SimpleApp::class.java
        .getResource("/data/targeted.json")
        .readText(Charsets.UTF_8)
    )
    .shuffled()
    .first()

@RestController
class RestEndpoints {
    @GetMapping("/api")
    fun fortune() = getRandomSubreddit()
}

@Controller
class HtmlEndpoints {
    @GetMapping("/")
    fun index( model: Model) :String {
        model.addAttribute( "subreddit", getRandomSubreddit() )
        return "index"
    }
}