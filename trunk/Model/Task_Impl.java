public class Task_Impl implements Task {
    private String t_name;
    private String description;
    private String deadline;
    private String priority;
    private String status;
    private String subtask;


    Task_Impl(String t_name,String description,String deadline,String priority,String status,String subtask){
        this.t_name=t_name;
        this.description=description;
        this.deadline=deadline;
        this.priority=priority;
        this.status=status;
        this.subtask=subtask;
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
