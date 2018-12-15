package com.ddlab.tornado.github;

import java.util.ArrayList;
import java.util.List;

import com.ddlab.gitpusher.core.IGitHandler;
import com.ddlab.gitpusher.core.UserAccount;
import com.ddlab.gitpusher.github.bean.GitHubRepo;
import com.ddlab.gitpusher.github.bean.Repo;
import com.ddlab.gitpusher.github.core.GitHubHandlerImpl;

public class GitHubUtil {

  public static String[] getAllRepositories(String userName, String password) throws Exception {
    UserAccount userAccount = new UserAccount(userName, password);
    IGitHandler gitHandler = new GitHubHandlerImpl(userAccount);
    
    String[] allRepos = gitHandler.getAllRepositories();
//    GitHubRepo gitHubRepo = gitHandler.getAllRepositories();
//    Repo[] repos = gitHubRepo.getRepos();
//    List<String> repoList = new ArrayList<>();
//    for (Repo repo : repos) repoList.add(repo.getName());
//    String[] allRepos = repoList.toArray(new String[0]);
    
    
    

    //    gitHandler.getAllRepositories();
    //    for (String repoName : allRepos) {
    //      System.out.println("Repo Name : " + repoName);
    //    }
    return allRepos;
  }

  public static String[] getAllGists(String userName, String password) throws Exception {
    UserAccount userAccount = new UserAccount(userName, password);
    IGitHandler gitHandler = new GitHubHandlerImpl(userAccount);
    String[] allGists = gitHandler.getGists();
    for(String gistName : allGists) System.out.println("Gist Name : "+gistName);
    return allGists;
  }
}
