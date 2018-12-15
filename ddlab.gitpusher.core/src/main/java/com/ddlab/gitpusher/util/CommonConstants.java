package com.ddlab.gitpusher.util;

public class CommonConstants {
    //Product Specific

    public static final String GENERIC_COMIT_MSG = "Code committed and pushed by {0} "
            + "on " + CommonUtil.getTodayDateTime()
            + " " + "using DDLAB Gitpusher tool";
    
    public static final String GENERIC_LOGIN_ERR_MSG = "Inappropriate credentials, check your user name and password combination";
    public static final String GENERIC_LOCAL_GIT_EXIST = "Unable to read the local .git directory to find out the Repo URL";
    public static final String NO_CONNECTION_MSG = "Unable to connect ...";

    // GITHUB Details
    public static final String GITHUB_GIST_ERR_MSG = "Unable to create a Gist in GitHub.";
    public static final String GIT_API_URI = "https://api.github.com";
    public static final String REPO_API = "/user/repos"; // To get all repos, also used for creating a repo
    public static final String USER_API = "/user"; // To get user details
    public static final String GIST_API = "/users/{0}/gists";
    public static final String SEARCH_REPO_API =
            "/repos/{0}/{1}"; // To search the repo /repos/<loginUser>/<repoName>
    public static String GITHUB_REPO_CLONE_URI =
            "https://github.com/{0}/{1}.git"; // "https://github.com/debjava/Hello-World.git"

    public static final String GITHUB_GET_GIST_API = GIT_API_URI + GIST_API;

    public static final String GITHUB_CREATE_GIST_API = "/gists";

    //BitBucket API Details
    public static final String BITBUCKET_API_URI = "https://api.bitbucket.org/2.0";
    public static final String BITBUCKET_USER_API_URI = "/user";
    public static final String BITBUCKET_ALL_REPO_API_URI = "/repositories/{0}";
    public static final String BITBUCKET_EXISTING_REPO_API_URI = "/repositories/{0}/{1}";
    public static final String BITBUCKET_CREATE_API_URI = "/repositories/{0}/{1}";
    //https://sambittechy@bitbucket.org/sambittechy/dd111.git
    public static final String BITBUCKET_CLONE_API_URI = "https://{0}@bitbucket.org/{1}/{2}.git";
    public static final String BITBUCKET_GET_OR_CREATE_GIST_API_URI = "/snippets/{0}";
    
    //Bitbucket Constants
    public static final String BITBUCKET_SNIPPET_ERR_MSG = "Unable to create a Snippet in Bitbucket.";
    public static final String BITBUCKET_CLONE_ERR_MSG = "Unable to clone the project from Bitbucket.";
    public static final String BITBUCKET_REPO_ERR_MSG = "Unable to create a repo in Bitbucket, a repository may already exist.";


}
