package com.pooja.issueapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {
    @Autowired
    IssueRepository issueRepository;

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Issue addIssue(Issue issue){
        return issueRepository.save(issue);
    }

    public Optional <Issue> getIssueById(int id){
        return issueRepository.findById(id);
    }

    public Issue updateIssue(Issue issue){
        Optional<Issue> optIssue = getIssueById(issue.getId());
        if(optIssue.isPresent()) {
            return issueRepository.save(issue);
        }
        return null;
    }
    public Issue deleteIssue(int id){
        Optional<Issue> optIssue = getIssueById(id);
        if(optIssue.isPresent()) {
             issueRepository.deleteById(id);
             return optIssue.get();
        }
        return null;

    }


}
