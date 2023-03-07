package com.pooja.issueapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class IssueRestController {
    @Autowired
    IssueService issueService;

    @GetMapping("/issues")
    public List<Issue> findAllIssue() {
        System.out.println("Calling GET request");
        return issueService.getAllIssues();
    }

    @PostMapping("/add")
    public Issue add(@RequestBody Issue issue){
        System.out.println("Calling POST request");
        return issueService.addIssue(issue);

    }
    @GetMapping("/issues/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Issue> optionalIssue = issueService.getIssueById(id);
        System.out.println("Calling GETbyId request");
        if (optionalIssue.isPresent()) {
            return new ResponseEntity<>(optionalIssue.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found",HttpStatus.OK);
    }

    @PutMapping("/update")
    public Issue update(@RequestBody Issue issue){
        System.out.println("Calling PUT request");
        return issueService.updateIssue(issue);
    }

    @DeleteMapping("/issues/{id}")
    public Issue deleteById(@PathVariable int id) {
        System.out.println("Calling DELETE request");
        return issueService.deleteIssue(id);
    }




}
