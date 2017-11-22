package model;



public class ColoringImpl implements Coloring {
    private String color;

    ColoringImpl(String color){
        this.color=color;
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
