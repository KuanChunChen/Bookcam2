package five.project.bookcam.bookcam.mvc.model;

/**
 * Created by user on 2018/3/19.
 */

public class FourTab_Sellingbook {
    private int type;
    private String name;
    private String time;

    public FourTab_Sellingbook(int type,String name,String time) {
        this.type = type;
        this.name = name;
        this.time = time;
    }
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }






}
