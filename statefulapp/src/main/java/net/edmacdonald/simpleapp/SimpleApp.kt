package net.edmacdonald.simpleapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import java.io.File
import java.io.FileWriter
import java.net.InetAddress

@SpringBootApplication
open class SimpleApp

fun main(args: Array<String>) {
    runApplication<SimpleApp>(*args)
}

data class Subreddit( val name: String, val description: String, val audience: String, var remaining: Int){
    val link = "http://www.reddit.com/$name";
    val hostname = InetAddress.getLocalHost().hostName
}

val JSON_FILE = "/tmp/targeted.json";


@ExperimentalStdlibApi
@Synchronized
fun getRandomSubreddit(): Subreddit {
    var file = File(JSON_FILE)

    var subreddits =
        jacksonObjectMapper()
        .readValue<List<Subreddit>>(
            if(file.exists())
                file.inputStream()
            else
                SimpleApp::class.java
                .getResource("/data/targeted.json")
                .openStream()
        )
        .shuffled()
        .toMutableList()


    var subreddit = subreddits.removeLast()

    subreddit.remaining = subreddits.size

    if(subreddit.remaining > 0)
        jacksonObjectMapper().writeValue( FileWriter(File(JSON_FILE)), subreddits )
    else if( file.exists() )
        file.delete()

    return subreddit
}

@ExperimentalStdlibApi
@RestController
class RestEndpoints {
    @GetMapping("/api")
    fun fortune() = getRandomSubreddit()

//  Need to implement a health check so that k8s health checks dont' burn subreddits
    @GetMapping("/healthcheck")
    fun healthcheck() = object {}
}

@ExperimentalStdlibApi
@Controller
class HtmlEndpoints {
    @GetMapping("/")
    fun index( model: Model) :String {
        model.addAttribute( "subreddit", getRandomSubreddit() )
        return "index"
    }
}