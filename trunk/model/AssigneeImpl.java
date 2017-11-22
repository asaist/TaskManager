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
    public void setName(String name) {
        this.name=name;

    }

    @Override
    public String getName() {
        return name;
    }


}
