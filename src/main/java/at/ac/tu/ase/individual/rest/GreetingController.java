package at.ac.tu.ase.individual.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public ResponseEntity greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Greeting(counter.incrementAndGet(), String.format(template, name)));
	}

  @GetMapping("/greeting/{id}")
  public ResponseEntity greetingWithId(@PathVariable(value = "id") String id) {
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Greeting(counter.incrementAndGet(), String.format(template, id)));
  }

  @PostMapping("/greeting/post")
  public ResponseEntity greetingPost(@RequestBody Greeting greeting) {
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(new Greeting(counter.incrementAndGet(), String.format(template, greeting.getContent())));
  }
}
