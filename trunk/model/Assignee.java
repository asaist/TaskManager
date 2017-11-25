package model;

public interface Assignee {
    String name = null;
    String lastNmae = null;
    String post = null;

    String create(String S);
    String update(String S);

    void setName(String name);

    String getName();

    void setLastname(String lastNmae);

    String getLastname();

    void setPost(String post);

    String getPost();


    }





