 public class Assignee_Impl implements Assignee {

        private String name;
        private String lastname;
        private String post;

        Assignee_Impl(String name,String lastname,String post){
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
        public String delete(String S){
            return S;
        }

}
