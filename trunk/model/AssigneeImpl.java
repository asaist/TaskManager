package model;

public class AssigneeImpl implements Assignee {

        private String name;
        private String lastname;
        private String post;

        public AssigneeImpl(String name, String lastname, String post){
            this.name=name;
            this.lastname=lastname;
            this.post=post;
        }
        @Override
        public String create(String S){
            return S;
        }
        @Override
        public String update(String S){
            return S;
        }
        @Override
        public String getLastname() {
        return lastname;
        }
        @Override
        public void setLastname(String lastname) {
        this.lastname = lastname;
    }
        @Override
        public String getPost() {
        return post;
    }
        @Override
        public void setPost(String post) {
        this.post = post;
    }
        @Override
        public void setName(String name) {
        this.name=name;
        }
        @Override
        public String getName() {
        return name;
    }


}
